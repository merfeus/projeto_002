package com.example.projeto_002.repository

import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubRepository() {

    val service = RetrofitBuilder.getGitHubService()

    fun fecthAll(onComplete: (List<GitHubResponse>?, String?) -> Unit) {
        val call = service.getAllRepo()
        call.enqueue(object : Callback<List<GitHubResponse>> {
            override fun onResponse(
                call: Call<List<GitHubResponse>>,
                response: Response<List<GitHubResponse>>
            ) {
                if (response.body() != null){
                    onComplete(response.body(), null)
                } else{
                    onComplete(null, "Nao encontrado Repositorios")
                }
            }

            override fun onFailure(call: Call<List<GitHubResponse>>, t: Throwable) {
                onComplete(null, t.message)
            }

        })
    }
}

