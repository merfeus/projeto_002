package com.example.projeto_002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.model.Repository
import com.example.projeto_002.repository.GitHubRepository

class MainViewModel : ViewModel() {

    private val repository = GitHubRepository()

    private val _GITREPO = MutableLiveData<List<Repository>>()
    val gitRepo: LiveData<List<Repository>> = _GITREPO

    private val _ERROR = MutableLiveData<String>()
    val error: LiveData<String> = _ERROR

    fun getAllRepo(){
        repository.fecthAll(){response, error ->
            response?.let {
                _GITREPO.value = it.items
            }
            error?.let {
                _ERROR.value = it
            }
        }
    }
}