package com.example.githubrepo.reposlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepo.R
import com.example.githubrepo.models.Repo


class RepoViewHolder(view: View): RecyclerView.ViewHolder(view) {   // takes a view that its going to bind t
    private val name: TextView = view.findViewById(R.id.name)

    fun bind(repo: Repo){
        name.text = repo.name
    }
}
val diffCallback = object : DiffUtil.ItemCallback<Repo>(){
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem === newItem   // === operator is used to compare the reference of two variable or object. It will only be true if both the objects or variables pointing to the same object.
    }

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem == newItem
    }

}
class ReposAdapter(private val repoClickHandler: (Repo) -> Unit) : ListAdapter<Repo, RepoViewHolder>(diffCallback) // takes a model and view holder
{    // takes ni reporClick handler of functional type
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)  // converting xml appearance definition into view Objects into code is calleld inflation
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        // we will get the reference to our holder, and well call the bind method on it,
        // pass in the current item at that position
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {   // item view for root of the view
            repoClickHandler(getItem(position))
        }
    }
    

}