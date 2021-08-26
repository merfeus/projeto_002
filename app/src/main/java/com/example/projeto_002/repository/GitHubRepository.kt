package com.example.projeto_002.repository

import android.content.Context
import com.example.projeto_002.database.AppDataBase
import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubRepository(private val context: Context) {

    private val dataBase = AppDataBase.getDataBase(context)
    val service = RetrofitBuilder.getGitHubService()

    fun fecthAll(onComplete: (GitHubResponse?, String?) -> Unit) {
        val call = service.getAllRepo()
        call.enqueue(object : Callback<GitHubResponse> {
            override fun onResponse(
                call: Call<GitHubResponse>,
                response: Response<GitHubResponse>
            ) {
                if (response.body() != null) {
                    onComplete(response.body(), null)
                    println(onComplete)
                } else {
                    onComplete(null, "Nenhum Repositorio Encontrado")
                }
            }

            override fun onFailure(call: Call<GitHubResponse>, t: Throwable) {
                onComplete(null, t.message)
            }
        })

    }
}

