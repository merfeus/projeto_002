package com.example.projeto_002.service

import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceGitHub {

    @GET("/search/repositories")
    fun fecthRepo(
        @Query("q") language: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
    ): Call<GitHubResponse>

    @GET("/repos/{name}/{nameRepository}/pulls")
    fun getAllPull(
        @Path("name") name: String,
        @Path("nameRepository") nameRepository: String
    ): Call<List<PullRequest>>
}