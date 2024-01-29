package com.abdelrahman.posts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdelrahman.posts.PostViewModel
import com.abdelrahman.posts.PostsViewModel
import com.abdelrahman.posts.R
import com.abdelrahman.posts.databinding.ActivityMainBinding
import com.abdelrahman.posts.`interface`.OnPostClickListener
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var postsAdapter:PostsAdapter
    private val viewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()

    }

    private fun getPosts(){
        viewModel.getPosts()
        lifecycleScope.launch {
            viewModel.posts.collect{
                postsAdapter = PostsAdapter(){id->
                    val intent = Intent(this@MainActivity,  PostActivity::class.java)
                    intent.putExtra("postId", id)
                    startActivity(intent)
                }
                postsAdapter.submitList(it)
                binding.postsRv.adapter = postsAdapter
                binding.postsRv.layoutManager = LinearLayoutManager(this@MainActivity)

            }
        }
    }

}