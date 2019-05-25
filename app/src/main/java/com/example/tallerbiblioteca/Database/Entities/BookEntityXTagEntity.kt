package com.example.tallerbiblioteca.Database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = BookEntityXTagEntity.TABLE_NAME,
    primaryKeys = ["bookIdX", "tagIdX"],
    foreignKeys = [
        ForeignKey(
            entity = BookEntity::class,
            parentColumns = ["bookId"],
            childColumns = ["bookIdX"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TagEntity::class,
            parentColumns = ["tagId"],
            childColumns = ["tagIdX"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class BookEntityXTagEntity (
    @ColumnInfo(name = "book_id") var bookIdX: Int = 0,
    @ColumnInfo(name = "tag_id") var tagIdX: Int = 0
){
    companion object{
        const val TABLE_NAME = "bookXtag"
    }
}
