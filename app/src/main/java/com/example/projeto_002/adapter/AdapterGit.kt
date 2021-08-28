package com.example.projeto_002.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projeto_002.R
import com.example.projeto_002.databinding.ItemGitRepositoryBinding
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.model.Repository
import com.example.projeto_002.utils.toUpperFirstChar

class AdapterGit() : RecyclerView.Adapter<GitRepoViewHolder>() {

    private var listOfGitRepo: MutableList<Repository> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_git_repository, parent, false).let {
                GitRepoViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        listOfGitRepo[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOfGitRepo.size

    fun refesh(newList: List<Repository>) {
        listOfGitRepo = arrayListOf()
        listOfGitRepo.addAll(newList)
        notifyDataSetChanged()
    }
}

class GitRepoViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private var binding: ItemGitRepositoryBinding = ItemGitRepositoryBinding.bind(itemView)

    fun bind(reposi: Repository) {

        binding.nameRepository.text = reposi.name.toUpperFirstChar()
        binding.descriptionRepository.text = reposi.description.toUpperFirstChar()
        binding.starsRepository.text = reposi.stars.toString()
        binding.nameOwner.text = reposi.owner.login.toUpperFirstChar()
        binding.forkRepository.text = reposi.forks.toString()
        reposi.owner?.let {
            Glide.with(itemView.context)
                .load(it.avatarUrl)
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .into(binding.avatarUser)
        }
    }

}