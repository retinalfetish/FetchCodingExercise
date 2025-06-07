package com.unary.fetchcodingexercise

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unary.fetchcodingexercise.data.remote.HiringApi
import com.unary.fetchcodingexercise.domain.model.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Main activity.
 */
class MainViewModel : ViewModel() {

    // Hiring list state
    private val _hiringState = MutableStateFlow(HiringState())
    val hiringState: StateFlow<HiringState> = _hiringState

    init {
        viewModelScope.launch {
            _hiringState.value = HiringState(isLoading = true)

            try {
                _hiringState.value = HiringState(
                    list = HiringApi.apiService.getList()
                        .filter { !it.name.isNullOrEmpty() }
                        .sortedWith(compareBy<Person> { it.listId }.thenBy { it.name })
                        .toMutableStateList()
                )
            } catch (e: Exception) {
                _hiringState.value = HiringState(isFailure = true)
                Log.e("Main", e.message.toString())
            }
        }
    }
}