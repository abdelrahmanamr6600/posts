package com.abdelrahman.posts.di

import com.abdelrahman.domain.repo.PostRepo
import com.abdelrahman.domain.repo.PostsRepo
import com.abdelrahman.domain.usecase.GetPostUseCase
import com.abdelrahman.domain.usecase.GetPosts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(postsRepo: PostsRepo):GetPosts{
        return GetPosts(postsRepo)
    }

    @Provides
    fun providePostUseCase(postRepo: PostRepo):GetPostUseCase{
        return GetPostUseCase(postRepo)
    }
}