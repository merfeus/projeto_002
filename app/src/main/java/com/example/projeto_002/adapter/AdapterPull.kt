package com.example.projeto_002.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projeto_002.R
import com.example.projeto_002.databinding.ItemPullBinding
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.utils.toUpperFirstChar

class AdapterPull(val itemClick: (PullRequest) -> Unit) :
    RecyclerView.Adapter<PullListViewHolder>() {

    private var listOfPull = mutableListOf<PullRequest>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullListViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pull, parent, false).let {
                PullListViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: PullListViewHolder, position: Int) {
        listOfPull[position].apply {
            holder.bind(this)

            holder.itemView.setOnClickListener {
                itemClick(this)
            }
        }
    }

    override fun getItemCount(): Int = listOfPull.size

    fun refesh(newList: List<PullRequest>) {
        listOfPull = arrayListOf()
        listOfPull.addAll(newList)
        notifyDataSetChanged()
    }
}

class PullListViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val binding = ItemPullBinding.bind(item)

    fun bind(pullRequest: PullRequest) {
        binding.titlePull.text = pullRequest.title.toUpperFirstChar()
        binding.datePull.text = pullRequest.createdAt
        binding.bodyPull.text = pullRequest.body?.toUpperFirstChar()
        binding.nameOwnerPull.text = pullRequest.user.login.toUpperFirstChar()

        pullRequest.user.let {
            Glide.with(itemView.context)
                .load(it.avatarUrl)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .into(binding.avatarUserPull)
        }
    }


}