package com.unary.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    HiringScreen(list = viewModel.list.value)
                    if (viewModel.isLoading.value) {
                        CircularProgressIndicator(modifier = Modifier.width(64.dp))
                    }
                    if (viewModel.onError.value) {
                        Text(text = stringResource(R.string.main_error_message))
                    }
                }
            }
        }
    }
}