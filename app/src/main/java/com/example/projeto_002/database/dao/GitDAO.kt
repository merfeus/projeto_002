package com.example.projeto_002.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projeto_002.model.GitHubRepo

@Dao
interface GitDAO {

    @Query("SELECT * FROM git_repo")
    fun getAll(): List<GitHubRepo>?
    //função getall() para retornar todos os registros da tabela.
    //@Query é o reponsável pela busca.


    @Query("SELECT * FROM git_repo WHERE id = :id")
    fun byId(id: Int): GitHubRepo?
    //função byId() para retornar um unico registro da tabela.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gitHub: GitHubRepo)
    //insert() para inserir os registros no banco
    //onConflict server para validar quando o insert identifica algum resigtro duplicado.


}