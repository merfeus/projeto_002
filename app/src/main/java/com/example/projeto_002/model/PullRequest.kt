package com.example.projeto_002.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PullRequest(
    @SerializedName("title")
    val title: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("user")
    val user: User,
    @SerializedName("body")
    val body: String?,
    @SerializedName("html_url")
    val htmlUrl: String
)
data class User(
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)


