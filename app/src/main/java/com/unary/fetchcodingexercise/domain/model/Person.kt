package com.unary.fetchcodingexercise.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * A data class used to hold the details of a single person.
 */
@JsonClass(generateAdapter = true)
data class Person(
    @Json(name = "id") val id: Int,
    @Json(name = "listId") val listId: Int,
    @Json(name = "name") val name: String?
)