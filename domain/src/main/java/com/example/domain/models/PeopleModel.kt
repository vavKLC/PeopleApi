package com.example.domain.models

data class PeopleModel(
    val id: String,
    val name: String,
    val gender: String?,
    val age: String,
    val eye_color: String,
    val hair_color: String,
    val films: List<String>,
    val species: String,
    val url: String
)

