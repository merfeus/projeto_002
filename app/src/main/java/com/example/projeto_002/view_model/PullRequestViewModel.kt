package com.example.projeto_002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.repository.GitHubRepository

class PullRequestViewModel : ViewModel() {

    val _PULLREQUEST = MutableLiveData<List<PullRequest>>()
    val pullRequest: LiveData<List<PullRequest>> = _PULLREQUEST

    val _ERROR = MutableLiveData<String>()
    val error: LiveData<String> = _ERROR

    fun fetchPullRequest(nameUser: String, nameRepository: String) {
        val repository = GitHubRepository()
        repository.fecthPullDetails(nameUser, nameRepository) { response, error ->
            response?.let {
                _PULLREQUEST.value = it
            }

            error?.let {
                _ERROR.value = it
            }
        }
    }
}