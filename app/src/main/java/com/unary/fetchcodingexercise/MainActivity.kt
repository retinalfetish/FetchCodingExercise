package com.unary.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import com.unary.fetchcodingexercise.data.remote.HiringApi
import com.unary.fetchcodingexercise.domain.model.Person
import com.unary.fetchcodingexercise.ui.HiringScreen
import com.unary.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FetchCodingExerciseTheme {
                var list by remember { mutableStateOf<List<Person>>(emptyList()) }

                LaunchedEffect(Unit) {
                    list = HiringApi.apiService.getList().toMutableStateList()
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        HiringScreen(list = list)
                    }
                }
            }
        }
    }
}