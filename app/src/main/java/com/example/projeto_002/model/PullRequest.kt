package com.example.projeto_002.model

import com.google.gson.annotations.SerializedName

data class GitHubPulls()

data class User(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
)

data class PullRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("body")
    val body: String

)
