package com.example.projeto_002.view.dialog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projeto_002.R
import com.example.projeto_002.adapter.AdapterPull
import com.example.projeto_002.databinding.PullRequestFragmentBinding
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.view_model.PullRequestViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar

const val OWNER = "owner"
const val REPO = "repo_key"

class PullRequestFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(login: String, nameRepository: String): PullRequestFragment {
            return PullRequestFragment().apply {
                val args = Bundle()
                args.putString(OWNER, login)
                args.putString(REPO, nameRepository)
                this.arguments = args
            }
        }
    }

    private lateinit var viewModel: PullRequestViewModel
    private lateinit var binding: PullRequestFragmentBinding
    private val adapter = AdapterPull {
        val browser = Intent(Intent.ACTION_VIEW, Uri.parse(it.htmlUrl))
        startActivity(browser)
    }

    private val observerPullRequest = Observer<List<PullRequest>> { pull ->
        adapter.refesh(pull)
    }

    private val observerError = Observer<String?> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pull_request_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)
        binding = PullRequestFragmentBinding.bind(view)

        binding.recyclerViewPull.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.recyclerViewPull.adapter = adapter

        viewModel.pullRequest.observe(viewLifecycleOwner, observerPullRequest)
        viewModel.error.observe(viewLifecycleOwner, observerError)

        val owner = arguments?.getString(OWNER)
        val repo = arguments?.getString(REPO)

        viewModel.fetchPullRequest(owner, repo)

    }

    override fun getTheme(): Int = R.style.CustomBottomSheetDialog
}