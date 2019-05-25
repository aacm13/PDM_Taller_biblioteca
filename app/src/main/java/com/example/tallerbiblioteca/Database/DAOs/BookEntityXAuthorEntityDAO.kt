package com.example.tallerbiblioteca.Database.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tallerbiblioteca.Database.Entities.BookEntityXAuthorEntity
import com.example.tallerbiblioteca.Database.Entities.AuthorEntity
import com.example.tallerbiblioteca.Database.Entities.BookEntity

@Dao
interface BookEntityXAuthorEntityDAO {
    @Insert
    fun insert(bookEntityXAuthorEntity : BookEntityXAuthorEntity)

    @Query("SELECT * FROM book INNER JOIN bookXauthor ON " +
            "book.book_id=bookXauthor.book_id WHERE " +
            "bookXauthor.tag_id=:Id")
             fun getBooksForTags(Id:Int): List<BookEntityXAuthorEntity>

    @Query("SELECT * FROM tag INNER JOIN bookXauthor ON " +
            "author.author_id=bookXauthor.author_id WHERE " +
            "bookXauthor.book_id=:Id")
    fun getTagsForBooks(Id:Int): List<BookEntityXAuthorEntity>



}

//fun getAllBooksFromAuthor(name: AuthorEntity):List<BookEntity>

/*@Query("SELECT * FROM repo INNER JOIN user_repo_join ON" +
        "repo.id=user_repo_join.repoId WHERE " +
        "user_repo_join.userId=:userId")
List<Repo> getRepositoriesForUsers(final int userId);*/

/*
SELECT column_name(s)
FROM table1
INNER JOIN table2
ON table1.column_name = table2.column_name;*/