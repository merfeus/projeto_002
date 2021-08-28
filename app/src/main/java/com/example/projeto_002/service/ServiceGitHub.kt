package com.example.projeto_002.service

import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.model.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceGitHub {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1...34")
    fun getAllRepo(): Call<GitHubResponse>

    @GET("/repos/{name}/{nameRepository}/pulls/")
    fun getAllPull(
        @Path("nameUser") nameUser: String,
        @Path("nameRepository") name: String
    ): Call<List<PullRequest>>
}