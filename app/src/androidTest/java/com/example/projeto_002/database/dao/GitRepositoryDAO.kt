package com.example.projeto_002.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.projeto_002.database.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class GitRepositoryDAO {

    private lateinit var database: AppDatabase
    private lateinit var dao: GitRepositoryDAO


    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ) .allowMainThreadQueries().build()
        dao - database.Git
    }

    @After

    fun teardown(){
        database.close()
    }
}