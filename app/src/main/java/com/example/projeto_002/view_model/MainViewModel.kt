package com.example.projeto_002.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projeto_002.model.Repository
import com.example.projeto_002.repository.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GitHubRepository) : ViewModel() {


    private val _GITREPO = MutableLiveData<List<Repository>>()
    val gitRepo: LiveData<List<Repository>> = _GITREPO

    private val _ERROR = MutableLiveData<String>()
    val error: LiveData<String> = _ERROR

    private val _PAGE = MutableLiveData<Int>(0)
    val page: LiveData<Int> = _PAGE


    fun getAllRepo(language: String, page: Int = 1) {
        repository.fecthAll(language = language, page = page) { response, error ->
            response?.let {
                _GITREPO.value = it.items
            }
            error?.let {
                _ERROR.value = it
            }
        }
    }

    fun nextPage() {
        _PAGE.value = _PAGE.value!! + 1

    }

    fun fetchFilteredFromDataBase(query: String) {
        repository.fetchAllFromDataBaseWithFilter(query).apply {
            _GITREPO.value = this
        }
    }
}