package com.example.projeto_002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.repository.GitHubRepository

class MainViewModel : ViewModel() {

    private val repository = GitHubRepository()

    private val _GITREPO = MutableLiveData<List<GitHubResponse>>()
    val gitRepo: LiveData<List<GitHubResponse>> = _GITREPO

    private val _ERROR = MutableLiveData<String>()
    val error: LiveData<String> = _ERROR

    fun getAllRepo(){
        repository.fecthAll(){response, error ->
            response?.let {
                _GITREPO.value = it
            }
            error?.let {
                _ERROR.value = it
            }
        }
    }
}