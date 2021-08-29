package com.example.projeto_002.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GitHubResponse(val items: List<Repository>)

data class Repository(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val nameRepository: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("pulls_url")
    val pullsUrl: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("forks")
    val forks: Int,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stars: Int,
    var details: PullRequest
) : Serializable

data class Owner(

    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val idOwner: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)