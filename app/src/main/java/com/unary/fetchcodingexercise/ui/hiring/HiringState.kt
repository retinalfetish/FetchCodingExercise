package com.unary.fetchcodingexercise.ui.hiring

import com.unary.fetchcodingexercise.domain.model.Person

data class HiringState(
    val list: List<Person> = emptyList(),
    val isLoading: Boolean = false,
    val isFailure: Boolean = false
)