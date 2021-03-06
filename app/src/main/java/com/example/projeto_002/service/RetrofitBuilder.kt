package com.example.projeto_002.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    //Cria uma instacia do retrofit passando a url base.
    private val retrofitGitHub = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getGitHubService(): ServiceGitHub{
        return retrofitGitHub.create(ServiceGitHub::class.java)
    }

}