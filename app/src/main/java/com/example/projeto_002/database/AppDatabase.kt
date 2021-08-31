package com.example.projeto_002.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projeto_002.model.Owner
import com.example.projeto_002.repository.GitHubRepository

@Database(
    entities = [
        GitHubRepository::class,
        Owner::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {


    companion object {
        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "github_app_db")
                .allowMainThreadQueries()
                .build()
        }
    }
}