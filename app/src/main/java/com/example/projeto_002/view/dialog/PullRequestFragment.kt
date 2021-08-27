package com.example.projeto_002.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projeto_002.R

class PullRequestFragment : Fragment() {

    companion object {
        fun newInstance() = PullRequestFragment()
    }

    private lateinit var viewModel: PullRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pull_request_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}