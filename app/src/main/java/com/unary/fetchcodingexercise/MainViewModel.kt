package com.unary.fetchcodingexercise

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.unary.fetchcodingexercise.data.remote.HiringApi
import com.unary.fetchcodingexercise.domain.model.Person
import kotlinx.coroutines.launch

/**
 * ViewModel for the Main activity.
 */
class MainViewModel : ViewModel() {

    // Filtered hiring list
    private val _list = mutableStateOf<List<Person>>(emptyList())
    val list: State<List<Person>> = _list

    // Loading status indicator
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    // Error status indicator
    private val _onError = mutableStateOf(false)
    val onError: State<Boolean> = _onError

    init {
        viewModelScope.launch {
            _isLoading.value = true

            try {
                _list.value = HiringApi.apiService.getList()
                    .filter { !it.name.isNullOrEmpty() }
                    .sortedWith(compareBy<Person> { it.listId }.thenBy { it.name })
                    .toMutableStateList()
            } catch (e: Exception) {
                Log.e("Main", e.message.toString())
                _onError.value = true
            }

            _isLoading.value = false
        }
    }
}