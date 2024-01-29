package com.abdelrahman.domain.repo

import com.abdelrahman.domain.entity.PostsResponseItem

interface PostRepo {
    suspend fun getPostFromRemote(postId:Int): PostsResponseItem
}