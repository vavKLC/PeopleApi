package com.example.data.remote.apiservice


import com.example.data.dtos.PeopleModelDto
import retrofit2.http.GET

interface PeopleApiService {

    @GET("people")
    suspend fun fetchPeople(): List<PeopleModelDto>
}