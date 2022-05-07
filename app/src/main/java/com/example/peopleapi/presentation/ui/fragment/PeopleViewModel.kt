package com.example.peopleapi.presentation.ui.fragment

import com.example.peopleapi.presentation.base.BaseViewModel
import com.example.domain.usecase.FetchPeopleUseCase
import com.example.peopleapi.presentation.models.PeopleModelUI
import com.example.peopleapi.presentation.models.toUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val fetchPeopleUseCase: FetchPeopleUseCase
) : BaseViewModel() {
    private val _peopleState = mutableUIStateFlow<List<PeopleModelUI>>()
    val peopleState = _peopleState.asStateFlow()

    init {
        fetchPeople()
    }

    fun fetchPeople() {
        fetchPeopleUseCase().collectRequest(_peopleState) { it.map { it.toUI() } }
    }
}