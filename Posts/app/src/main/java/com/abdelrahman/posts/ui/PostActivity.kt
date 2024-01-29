package com.abdelrahman.posts.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.abdelrahman.posts.PostViewModel
import com.abdelrahman.posts.databinding.ActivityPostBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding
    private val postViewModel : PostViewModel by viewModels()
    private  var postId:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        if (savedInstanceState == null) {
            val extras = intent.extras
            if (extras == null) {
                Log.d("PostActivity", "intent has no data")
            } else {
                postId = extras.getInt("postId")
                Log.d("PostActivity", postId.toString())
                getPost()


            }
        } else {
            postId = savedInstanceState.getSerializable("postId") as Int?
            Log.d("PostActivity", postId.toString())
            getPost()

        }
        setContentView(binding.root)
    }

    private fun getPost(){
        postViewModel.getPost(postId!!)
        lifecycleScope.launch {
            postViewModel.post.collect{
                binding.postTitleTv.text = it?.title
                binding.textView.text = it?.body
            }
        }
    }
}