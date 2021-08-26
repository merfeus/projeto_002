package com.example.projeto_002.service

import com.example.projeto_002.model.GitHubResponse
import retrofit2.Call
import retrofit2.http.GET

interface ServiceGitHub {

    @GET("/search/repositories?q=language:Java&sort=stars&page=1")
    fun getAllRepo(): Call<GitHubResponse>
}