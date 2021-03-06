package com.example.projeto_002.repository

import com.example.projeto_002.database.dao.GitRepositoryDAO
import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.model.Repository
import com.example.projeto_002.service.ServiceGitHub
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GitHubRepository @Inject constructor(
    private val gitDAO: GitRepositoryDAO,
    private val service: ServiceGitHub
) {

    fun fecthAll(
        language: String,
        sort: String = "stars",
        page: Int = 1,
        onComplete: (GitHubResponse?, String?) -> Unit
    ) {
        val call = service.fecthRepo(
            language = "language:$language",
            sort = sort,
            page = page
        )
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
                    onComplete(null, "Não foram encontradas PR")
                }
            }

            override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                onComplete(null, t.message)
            }

        })
    }

    fun insertTODb() {

    }

    fun fetchRepositoryFormDatabase(language: String) {

    }

    fun fetchAllFromDataBaseWithFilter(query: String): List<Repository> {
        return gitDAO.fetchFiltered(query)
    }
}



