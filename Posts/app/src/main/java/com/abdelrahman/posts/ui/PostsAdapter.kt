package com.abdelrahman.posts.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abdelrahman.domain.entity.PostsResponse
import com.abdelrahman.domain.entity.PostsResponseItem
import com.abdelrahman.posts.databinding.PostItemBinding
import com.abdelrahman.posts.`interface`.OnPostClickListener

class PostsAdapter(
    private val onItemClickListener: (Int) -> Unit
) : ListAdapter<PostsResponseItem, PostsAdapter.ViewHolder>(PostsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.rootView.setOnClickListener {
            onItemClickListener( getItem(position).id)
        }
    }

    class ViewHolder(private val itemBinding: PostItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(post: PostsResponseItem) {
          itemBinding.postTitleTv.text = post.title
            itemBinding.postBodyTv.text = post.body

        }

    }

    class PostsDiffCallback : DiffUtil.ItemCallback<PostsResponseItem>() {
        override fun areItemsTheSame(
            oldItem: PostsResponseItem,
            newItem: PostsResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PostsResponseItem,
            newItem: PostsResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }
}