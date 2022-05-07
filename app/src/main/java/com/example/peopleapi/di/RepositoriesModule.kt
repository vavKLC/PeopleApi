package com.example.peopleapi.di

import com.example.data.repositories.PeopleRepositoryImpl
import com.example.domain.repositories.PeopleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun providePeopleRepository(repository: PeopleRepositoryImpl): PeopleRepository
}