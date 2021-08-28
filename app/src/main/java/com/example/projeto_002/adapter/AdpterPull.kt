package com.example.projeto_002.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_002.model.PullRequest

class AdpterPull(val itemClick: (PullRequest) -> Unit) : RecyclerView.Adapter<PullListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullListViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PullListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

class PullListViewHolder(item: View) : RecyclerView.ViewHolder(item){

}