package com.example.projeto_002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projeto_002.R
import com.example.projeto_002.adapter.AdapterGit
import com.example.projeto_002.databinding.MainFragmentBinding
import com.example.projeto_002.model.GitHubResponse
import com.example.projeto_002.model.Repository
import com.example.projeto_002.view.dialog.PullRequestFragment
import com.example.projeto_002.view_model.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.main_fragment) {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private val adapter = AdapterGit()

    private val observerGitRepo = Observer<List<Repository>> {
        adapter.refesh(it)
    }

    private val observerError = Observer<String?> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding = MainFragmentBinding.bind(view)

        binding.recyclerViewGitRepo.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewGitRepo.adapter = adapter

        viewModel.gitRepo.observe(viewLifecycleOwner, observerGitRepo)
        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.getAllRepo()

//        binding. { showBottomSheetDialog() }

    }

    fun showBottomSheetDialog(){
        val bottomSheet = PullRequestFragment()
        bottomSheet.show(parentFragmentManager, "dialog_pull")
    }

}