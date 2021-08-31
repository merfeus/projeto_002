package com.example.projeto_002.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GitHubResponse(

    @SerializedName("total_count")
    val total: Long,
    @SerializedName("items")
    val items: List<Repository>

    )
@Entity
data class Repository(
    @PrimaryKey
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val nameRepository: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("pulls_url")
    val pullsUrl: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("forks")
    val forks: Int,
    @Embedded
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("stargazers_count")
    val stars: Int,
    var details: PullRequest
) : Serializable

@Entity
data class Owner(
    @PrimaryKey
    @SerializedName("id")
    val id: Long,
    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val idOwner: Int,
    @SerializedName("avatar_url")
    val avatarUrl: String,
)