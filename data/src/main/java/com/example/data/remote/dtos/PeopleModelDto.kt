package com.example.data.remote.dtos

import com.example.domain.models.PeopleModel
import com.google.gson.annotations.SerializedName

data class PeopleModelDto(
    @SerializedName("id")
     val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("age")
    val age: String,
    @SerializedName("eye_color")
    val eye_color: String,
    @SerializedName("hair_color")
    val hair_color: String,
    @SerializedName("films")
    val films: List<String>,
    @SerializedName("species")
    val species: String,
    @SerializedName("url")
    val url: String
)

fun PeopleModelDto.toDomain() =
    PeopleModel(id, name, gender, age, eye_color, hair_color, films, species, url)

