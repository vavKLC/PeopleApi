package com.example.data.repositories

import com.example.data.repositories.base.BaseRepository
import com.example.data.remote.dtos.toDomain
import com.example.data.remote.apiservices.PeopleApiService
import com.example.domain.repositories.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val service: PeopleApiService
) : BaseRepository(), PeopleRepository {
    override fun fetchPeople() = doRequest {
        service.fetchPeople().map { it.toDomain() }
    }
}