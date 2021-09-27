package com.example.projeto_002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.repository.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PullRequestViewModel @Inject constructor(private val repository: GitHubRepository) : ViewModel() {

    private val _PULLREQUEST = MutableLiveData<List<PullRequest>>()
    val pullRequest: LiveData<List<PullRequest>> = _PULLREQUEST

    private val _ERROR = MutableLiveData<String>()
    val error: LiveData<String> = _ERROR

    fun fetchPullRequest(name: String?, nameRepository: String?){
        if (!name.isNullOrEmpty() && !nameRepository.isNullOrEmpty()) {
            repository.fecthPullDetails(name, nameRepository) { response, error ->
                response?.apply {
                    _PULLREQUEST.value = response
                }

                error?.let {
                    _ERROR.value = it
                }
            }
        }
    }
}
