package com.example.projeto_002.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.projeto_002.repository.GitHub

@Dao
interface GitDAO {

    @Query("SELECT * FROM GitHub")
    fun getAll(): List<GitHub>?
    //função all() para retornar todos os registros da tabela.
    //@Query é o reponsável pela busca.


    @Query("SELECT * FROM GITHUB WHERE git_id = :gitId")
    fun byId(gitId: Int): GitHub?
    //função byId() para retornar um unico registro da tabela.

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gitHub: GitHub)
    //insert() para inserir os registros no banco
    //onConflict server para validar quando o insert identifica algum resigtro duplicado.


}