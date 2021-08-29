package com.example.projeto_002.service

import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.model.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceGitHub {

    @GET("/search/repositories?q=language:Java&sort=fork&order=desc")
    fun getAllRepo(): Call<GitHubResponse>

    @GET("/repos/{name}/{nameRepository}/pulls")
    fun getAllPull(
        @Path("name") name: String,
        @Path("nameRepository") nameRepository: String):
        Call<List<PullRequest>>
}