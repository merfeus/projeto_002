package com.example.projeto_002.view.dialog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projeto_002.R
import com.example.projeto_002.view_model.PullRequestViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PullRequestFragment : BottomSheetDialogFragment() {

    private lateinit var viewModel: PullRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pull_request_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)
    }

}