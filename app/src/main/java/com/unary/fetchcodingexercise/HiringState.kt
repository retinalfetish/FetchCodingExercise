package com.unary.fetchcodingexercise

import com.unary.fetchcodingexercise.domain.model.Person

/**
 * A data class for a list and status indicators.
 */
data class HiringState(
    val list: List<Person> = emptyList(),
    val isLoading: Boolean = false,
    val isFailure: Boolean = false
)