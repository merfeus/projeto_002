package com.example.projeto_002.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class GitHubResponse(val result: List<GitHubRepo>)

//Mapeando API + Add no Banco com Room
@Entity(tableName = "git_repo")
data class GitHubRepo(

    @PrimaryKey
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("description")
    val description: String,
    @SerializedName("pulls_url")
    val pullsUrl: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("forks")
    val forks: Int,
    @Embedded
    val owner : Owner,


)

data class Owner(

    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)