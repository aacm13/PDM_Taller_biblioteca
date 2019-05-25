package com.example.tallerbiblioteca.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerbiblioteca.Models.Book
import com.example.tallerbiblioteca.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class BookListAdapter  internal constructor(
    context: Context
) : RecyclerView.Adapter<BookListAdapter.BookViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var books = emptyList<Book>()

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bookName: TextView = itemView.findViewById(R.id.book_name)
        val bookAuthor: TextView = itemView.findViewById(R.id.book_author)
        //val bookCover: ImageView = itemView.findViewById(R.id.book_cover)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val current = books[position]
        holder.bookName.text = current.book.bookTitle
        holder.bookAuthor.text = current.book.bookAuthor
    }

    internal fun setWords(books: List<Book>) {
        this.books = books
        notifyDataSetChanged()
    }

    override fun getItemCount() = books.size
}