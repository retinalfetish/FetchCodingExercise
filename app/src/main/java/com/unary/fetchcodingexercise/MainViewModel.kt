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

    private val _list = mutableStateOf<List<Person>>(emptyList())
    val list: State<List<Person>> = _list

    init {
        viewModelScope.launch {
            try {
                _list.value = HiringApi.apiService.getList().toMutableStateList()
                    .filter { !it.name.isNullOrEmpty() }
                    .sortedWith(compareBy<Person> { it.listId }.thenBy { it.name })
            } catch (e: Exception) {
                Log.e("Main", e.message.toString())
            }
        }
    }
}