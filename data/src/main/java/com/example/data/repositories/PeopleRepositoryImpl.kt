package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.dtos.toDomain
import com.example.data.remote.apiservice.PeopleApiService
import com.example.domain.repositories.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val service: PeopleApiService
) : BaseRepository(), PeopleRepository {
    override fun fetchPeople() = doRequest {
        service.fetchPeople().map { it.toDomain() }
    }
}