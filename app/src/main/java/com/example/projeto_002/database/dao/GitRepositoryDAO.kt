package com.example.projeto_002.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.projeto_002.model.Repository

@Dao
interface GitRepositoryDAO {
    //Dps da criacao do DAO partir para o AppDataBase
    @Insert(onConflict = REPLACE)
    fun insert(gitRepository: List<Repository>)

    @Query("SELECT * FROM Repository order by nameRepository")
    fun getAll(): List<Repository>

    @Query("SELECT count(*) FROM Repository WHERE language = :language")
    fun getTotalByLanguge(language: String): Int

    @Query("SELECT * FROM Repository WHERE stars LIKE '%' || :query || '%'")
    fun fetchFiltered(query: String): List<Repository>
}