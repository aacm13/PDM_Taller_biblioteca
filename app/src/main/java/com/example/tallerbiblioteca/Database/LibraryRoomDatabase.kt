package com.example.tallerbiblioteca.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tallerbiblioteca.Database.DAOs.*
import com.example.tallerbiblioteca.Database.Entities.*
import java.security.AccessControlContext

@Database(entities = [BookEntity::class, AuthorEntity::class, TagEntity::class, BookEntityXAuthorEntity::class, BookEntityXTagEntity::class], version = 1, exportSchema = false)
public abstract class LibraryRoomDatabase: RoomDatabase() {

    //Aqui se puede ver como se hacen las relaciones entre tablas.
    //https://developer.android.com/reference/android/arch/persistence/room/Relation

    abstract fun bookDao(): BookDAO
    abstract fun authorDAO(): AuthorDAO
    abstract fun tagDAO(): TagDAO
    abstract fun bookXauthorDAO(): BookEntityXAuthorEntityDAO
    abstract fun bookXtagDAO(): BookEntityXTagEntityDAO

    companion object {
        @Volatile
        private var INSTANCE : LibraryRoomDatabase? = null

        fun getInstance(context: Context): LibraryRoomDatabase{
            val tempInstace = INSTANCE
            if (tempInstace != null) return tempInstace

            synchronized(this){
                val instance = Room
                    .databaseBuilder(context, LibraryRoomDatabase::class.java, "LibrosDB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}

