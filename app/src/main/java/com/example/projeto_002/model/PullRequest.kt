package com.example.projeto_002.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class PullRequest(
    @PrimaryKey
    @ColumnInfo(name = "pull_id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("name")
    val namePull: String,
    @Embedded
    @SerializedName("user")
    val userPull: User,
    @SerializedName("body")
    val body: String?,
    @SerializedName("html_url")
    val htmlUrl: String
)
@Entity
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_login")
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrlUser: String,
)


