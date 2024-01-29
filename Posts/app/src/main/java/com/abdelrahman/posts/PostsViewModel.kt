package com.abdelrahman.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.domain.entity.PostsResponse
import com.abdelrahman.domain.usecase.GetPosts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase:GetPosts
    ):ViewModel() {
    private val _posts:MutableStateFlow<PostsResponse?> = MutableStateFlow(null)
    val posts:StateFlow<PostsResponse?> = _posts
        fun getPosts(){
            viewModelScope.launch {
                try {
                   _posts.value = getPostsUseCase()
                } catch (e:Exception){
                    Log.e("PostsViewLog",e.message!!)

                }
            }
        }



}