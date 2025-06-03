package com.unary.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.unary.fetchcodingexercise.data.remote.HiringApi
import com.unary.fetchcodingexercise.domain.model.Person
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
                    Text(
                        modifier = Modifier.padding(innerPadding),
                        text = list.toString()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FetchCodingExerciseTheme {

    }
}