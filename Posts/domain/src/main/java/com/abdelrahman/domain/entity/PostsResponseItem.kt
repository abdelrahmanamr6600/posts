package com.abdelrahman.domain.entity

data class PostsResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)