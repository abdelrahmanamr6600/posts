package com.abdelrahman.domain.usecase

import com.abdelrahman.domain.repo.PostsRepo

class GetPosts(private val postsRepo: PostsRepo) {
    suspend operator fun invoke () = postsRepo.getPostsFromRemote()
}