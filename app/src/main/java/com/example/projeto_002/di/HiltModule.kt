package com.example.projeto_002.di

import android.content.Context
import com.example.projeto_002.database.AppDatabase
import com.example.projeto_002.database.dao.GitRepositoryDAO
import com.example.projeto_002.repository.GitHubRepository
import com.example.projeto_002.service.RetrofitBuilder
import com.example.projeto_002.service.ServiceGitHub
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    fun provideGithubRepository(dao: GitRepositoryDAO, service: ServiceGitHub): GitHubRepository =
        GitHubRepository(dao, service)

    @Provides
    fun provideGitHubService(): ServiceGitHub = RetrofitBuilder.getGitHubService()

    @Provides
    fun provideGitDataBase(@ApplicationContext context: Context): GitRepositoryDAO {
        return AppDatabase.getDatabase(context).getGitHubRepository()
    }
}