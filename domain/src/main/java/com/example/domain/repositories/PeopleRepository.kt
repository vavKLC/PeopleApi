package com.example.domain.repositories

import com.example.domain.either.Either
import com.example.domain.models.PeopleModel
import kotlinx.coroutines.flow.Flow

interface PeopleRepository {
    fun fetchPeople(): Flow<Either<String, List<PeopleModel>>>
}