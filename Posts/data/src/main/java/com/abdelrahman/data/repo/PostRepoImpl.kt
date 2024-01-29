package com.abdelrahman.data.repo

import com.abdelrahman.data.remote.ApiService
import com.abdelrahman.domain.entity.PostsResponseItem
import com.abdelrahman.domain.repo.PostRepo


class PostRepoImpl(private val apiService: ApiService ):PostRepo {
    override suspend fun getPostFromRemote(postId: Int): PostsResponseItem = apiService.getPostById(postId)


}