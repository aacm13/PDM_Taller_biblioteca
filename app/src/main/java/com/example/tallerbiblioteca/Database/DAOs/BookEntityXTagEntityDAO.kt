package com.example.tallerbiblioteca.Database.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tallerbiblioteca.Database.Entities.BookEntityXAuthorEntity
import com.example.tallerbiblioteca.Database.Entities.TagEntity
import com.example.tallerbiblioteca.Database.Entities.BookEntity
import com.example.tallerbiblioteca.Database.Entities.BookEntityXTagEntity

@Dao
interface BookEntityXTagEntityDAO {
    @Insert
    fun insert(bookEntityXAuthorEntity: BookEntityXAuthorEntity)

    @Query(
        "SELECT * FROM book INNER JOIN bookXtag ON " +
                "book.book_id=bookXtag.book_id WHERE " +
                "bookXtag.tag_id=:Id"
    )
    fun getBooksForTags(Id: Int): List<BookEntityXTagEntity>

    @Query(
        "SELECT * FROM tag INNER JOIN bookXtag ON " +
                "tag.tag_id=bookXtag.tag_id WHERE " +
                "bookXtag.book_id=:Id"
    )
    fun getTagsForBooks(Id: Int): List<BookEntityXTagEntity>
}

//fun getAllBooksFromTag(tag: TagEntity): List<BookEntity>
