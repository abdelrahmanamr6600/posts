package com.abdelrahman.domain.repo

import com.abdelrahman.domain.entity.PostsResponse

interface PostsRepo {
    suspend fun getPostsFromRemote():PostsResponse
}