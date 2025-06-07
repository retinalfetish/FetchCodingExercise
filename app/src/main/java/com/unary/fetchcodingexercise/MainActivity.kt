package com.unary.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unary.fetchcodingexercise.ui.HiringScreen
import com.unary.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

/**
 * Main activity for the hiring application.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            FetchCodingExerciseTheme {
                val viewModel: MainViewModel = viewModel()
                val hiringState by viewModel.hiringState.collectAsState()

                Surface(modifier = Modifier.fillMaxSize()) {
                    HiringScreen(
                        list = hiringState.list,
                        isLoading = hiringState.isLoading,
                        isFailure = hiringState.isFailure
                    )
                }
            }
        }
    }
}