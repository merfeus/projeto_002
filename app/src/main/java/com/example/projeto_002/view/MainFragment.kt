package com.example.projeto_002.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projeto_002.R
import com.example.projeto_002.adapter.AdapterGit
import com.example.projeto_002.databinding.MainFragmentBinding
import com.example.projeto_002.model.Repository
import com.example.projeto_002.view.dialog.PullRequestFragment
import com.example.projeto_002.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar

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
        adapter.refesh(it)
    }

    private val observerError = Observer<String?> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }
    private val observerPage = Observer<Int>{ page ->
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

        viewModel.getAllRepo(LANGUAGE)

        binding.searchEditText.editText?.addTextChangedListener( object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let {
                    if (it.length > 3){
                        viewModel.fetchFiltered(it.toString(), it.toString())
                    }
                }
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                p0?.let {
                    if (it.isEmpty()){
                        viewModel.getAllRepo(LANGUAGE)
                    }
                }
            }

        })

        binding.nextPage.setOnClickListener {
            viewModel.nextPage()
        }

        binding.prevPage.setOnClickListener {
            viewModel.prevPage()
        }

    }

}