package com.abdelrahman.data.repo

import com.abdelrahman.data.remote.ApiService
import com.abdelrahman.domain.entity.PostsResponse
import com.abdelrahman.domain.repo.PostsRepo

class PostsRepoImpl(private val apiService: ApiService):PostsRepo {
    override suspend fun getPostsFromRemote(): PostsResponse = apiService.getPosts()
}