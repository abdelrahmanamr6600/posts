package com.abdelrahman.posts

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abdelrahman.domain.entity.PostsResponseItem
import com.abdelrahman.domain.usecase.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase):ViewModel() {
    private val _post: MutableStateFlow<PostsResponseItem?> = MutableStateFlow(null)
    val post: StateFlow<PostsResponseItem?> = _post
    fun getPost(postId:Int) {
        viewModelScope.launch {
            try {
                _post.value = getPostUseCase(postId)
            } catch (e: Exception) {
                Log.e("PostsViewLog", e.message!!)

            }
        }
    }
}