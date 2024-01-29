package com.abdelrahman.data.remote

import com.abdelrahman.domain.entity.PostsResponse
import com.abdelrahman.domain.entity.PostsResponseItem
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("posts")
    suspend fun getPosts():PostsResponse
    @GET("posts/{postId}")
    suspend fun getPostById(@Path("postId") id:Int):PostsResponseItem
}