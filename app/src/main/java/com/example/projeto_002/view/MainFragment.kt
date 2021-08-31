package com.example.projeto_002.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_002.R
import com.example.projeto_002.adapter.AdapterGit
import com.example.projeto_002.databinding.MainFragmentBinding
import com.example.projeto_002.model.Repository
import com.example.projeto_002.view.dialog.PullRequestFragment
import com.example.projeto_002.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private val LANGUAGE = "Kotlin"
    private val adapter = AdapterGit {
        val bottomSheet = PullRequestFragment.newInstance(it.owner.login, it.nameRepository)
        bottomSheet.show(parentFragmentManager, "dialog_pull")
    }

    private val observerGitRepo = Observer<List<Repository>> {
        binding.linearLayout2.visibility = GONE
        adapter.refesh(it)
    }

    private val observerError = Observer<String?> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }
    private val observerPage = Observer<Int> { page ->
        viewModel.getAllRepo(LANGUAGE, page)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = MainFragmentBinding.bind(view)

        binding.recyclerViewGitRepo.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewGitRepo.adapter = adapter

        viewModel.gitRepo.observe(viewLifecycleOwner, observerGitRepo)
        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.page.observe(viewLifecycleOwner, observerPage)


        setEventBuuton()
        searchRepository()

    }

    private fun searchRepository() {
        binding.searchEditText.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    if (it.length > 3) {
                        viewModel.fetchFilteredFromDataBase(it.toString())
                    }
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if (it.isEmpty()) {
                        viewModel.getAllRepo(LANGUAGE)
                    }
                }
            }

        })
    }


    private fun setEventBuuton() {

        binding.recyclerViewGitRepo.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    callForMorItens()
                }
            }
        })
    }

    private fun callForMorItens() {
        binding.linearLayout2.visibility = VISIBLE
        viewModel.nextPage()
    }
}