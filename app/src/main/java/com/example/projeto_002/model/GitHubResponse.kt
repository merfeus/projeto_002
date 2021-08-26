package com.example.projeto_002.model

import com.google.gson.annotations.SerializedName

data class GitHubResponse(

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
    @SerializedName("owner")
    val owner : Owner,


)

data class Owner(

    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val idOwner: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)