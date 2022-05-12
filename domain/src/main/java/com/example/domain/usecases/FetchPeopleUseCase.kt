package com.example.domain.usecases

import com.example.domain.repositories.PeopleRepository
import javax.inject.Inject

class FetchPeopleUseCase @Inject constructor(
    private val repository: PeopleRepository
) {
    operator fun invoke() = repository.fetchPeople()
}