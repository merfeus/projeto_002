package com.example.projeto_002.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projeto_002.database.dao.GitRepositoryDAO
import com.example.projeto_002.model.Owner
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.model.Repository
import com.example.projeto_002.model.User

@Database(
    entities = [
        Repository::class,
        Owner::class,
        PullRequest::class,
        User::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getGitHubRepository(): GitRepositoryDAO

    companion object {

        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "github_app_db")
                .allowMainThreadQueries()
                .build()
        }
    }
}