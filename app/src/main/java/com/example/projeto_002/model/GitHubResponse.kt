package com.example.projeto_002.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GitHubResponse(val result: List<GitHub>)

@Entity
//Mapeando API + Add no Banco com Room
data class GitHub(

    @PrimaryKey
    @ColumnInfo(name = "git_id")
    @SerializedName("id")
    val id : Int,

    @ColumnInfo(name = "git_nodeId")
    @SerializedName("node_id")
    val nodeId : String,


    @ColumnInfo(name = "git_nome")
    @SerializedName("name")
    val name : String,


    @ColumnInfo(name = "git_fullName")
    @SerializedName("full_name")
    val fullName : String,


    @ColumnInfo(name = "git_private")
    @SerializedName("private")
    val private : String,


    @ColumnInfo(name = "git_owner")
    @SerializedName("owner")
    val owner : String,




){

}
