package com.abdelrahman.posts.di

import com.abdelrahman.data.remote.ApiService
import com.abdelrahman.data.repo.PostRepoImpl
import com.abdelrahman.data.repo.PostsRepoImpl
import com.abdelrahman.domain.repo.PostRepo
import com.abdelrahman.domain.repo.PostsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

@Provides
    fun provideRepo(apiService: ApiService):PostsRepo{
        return PostsRepoImpl(apiService)
    }
    @Provides
    fun providePostRepo(apiService: ApiService): PostRepo {
        return PostRepoImpl(apiService)
    }
}