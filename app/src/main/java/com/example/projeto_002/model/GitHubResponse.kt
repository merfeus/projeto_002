package com.example.projeto_002.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

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
    @SerializedName("stargazers_count")
    val stars: Int,
    @Embedded
    @SerializedName("details")
    var details: PullRequest,
    @Embedded
    @SerializedName("owner")
    val owner: Owner,
)

@Entity
data class Owner(
    @PrimaryKey
    @ColumnInfo(name = "owner_id")
    val id: Long,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatarUrlOwner: String,
)