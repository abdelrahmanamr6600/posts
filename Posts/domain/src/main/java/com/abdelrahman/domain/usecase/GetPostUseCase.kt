package com.abdelrahman.domain.usecase
import com.abdelrahman.domain.repo.PostRepo
class GetPostUseCase(private val postRepo: PostRepo) {
    suspend operator fun invoke (postId:Int) = postRepo.getPostFromRemote(postId)
}