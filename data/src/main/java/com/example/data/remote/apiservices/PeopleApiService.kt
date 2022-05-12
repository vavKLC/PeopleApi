package com.example.data.remote.apiservices


import com.example.data.remote.dtos.PeopleModelDto
import retrofit2.http.GET

interface PeopleApiService {

    @GET("people")
    suspend fun fetchPeople(): List<PeopleModelDto>
}