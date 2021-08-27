package com.example.projeto_002.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projeto_002.R
import com.example.projeto_002.databinding.ItemGitRepositoryBinding
import com.example.projeto_002.model.GitHubResponse

class AdapterGit : RecyclerView.Adapter<GitRepoViewHolder>() {

    private var listOfGitRepo: MutableList<GitHubResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {

        val itemVIew =
            LayoutInflater.from(parent.context).inflate(R.layout.item_git_repository, parent, false)
        return GitRepoViewHolder(itemVIew)
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        listOfGitRepo[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listOfGitRepo.size

    fun refesh(newList: List<GitHubResponse>) {
        listOfGitRepo = arrayListOf()
        listOfGitRepo.addAll(newList)
        notifyDataSetChanged()
    }
}
class GitRepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var binding: ItemGitRepositoryBinding = ItemGitRepositoryBinding.bind(itemView)

    fun bind(gitResponse: GitHubResponse){

        binding.nameRepository.text = gitResponse.name
        binding.descriptionRepository.text = gitResponse.description
        binding.starsRepository.text = gitResponse.language
        binding.forkRepository.text = gitResponse.forks.toString()
        gitResponse.owner?.let {
            Glide.with(itemView.context)
                .load(it.avatarUrl)
                .into(binding.avatarUser)
        }
    }

}