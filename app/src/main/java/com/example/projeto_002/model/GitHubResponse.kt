package com.example.projeto_002.repository

import com.google.gson.annotations.SerializedName

data class GitHubResponse(val result: List<GitHub>)

data class GitHub(
    @SerializedName("id")
    val id : String,

    @SerializedName("node_id")
    val nodeId : String,

    @SerializedName("name")
    val name : String,

    @SerializedName("full_name")
    val fullName : String,

    @SerializedName("private")
    val private : String,

    @SerializedName("owner")
    val owner : String,




){

}
