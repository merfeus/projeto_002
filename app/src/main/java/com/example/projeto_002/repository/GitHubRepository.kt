package com.example.projeto_002.repository

import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.service.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitHubRepository() {

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
                } else {
                    onComplete(null, "Nenhum encontrado")
                }
            }

            override fun onFailure(call: Call<GitHubResponse>, t: Throwable) {
                onComplete(null, t.message)
            }
        })
    }

    fun fecthPullDetails(
        name: String,
        nameRepository: String,
        onComplete: (List<PullRequest>?, String?) -> Unit
    ) {
        val call = service.getAllPull(name, nameRepository)
        call.enqueue(object : Callback<List<PullRequest>> {
            override fun onResponse(
                call: Call<List<PullRequest>>,
                response: Response<List<PullRequest>>
            ) {
                if (response.body() != null) {
                    onComplete(response.body(), null)
                } else {
                    onComplete(null, "Nenhum pull request encontrado")
                }
            }

            override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                onComplete(null, t.message)
            }

        })
    }
}


