package com.unary.fetchcodingexercise.ui.hiring

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unary.fetchcodingexercise.R
import com.unary.fetchcodingexercise.domain.model.Person
import com.unary.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

/**
 * Composable Hiring screen to display a header with list.
 */
@Composable
fun HiringScreen(list: List<Person>) {
    Column {
        HiringHeader()
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(list) { person ->
                HiringCard(
                    id = person.id,
                    listId = person.listId,
                    name = person.name.toString()
                )
            }
        }
    }
}

/**
 * Composable header for the hiring list.
 */
@Composable
fun HiringHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(12.dp)
            .statusBarsPadding()
    ) {
        Text(
            modifier = Modifier.weight(0.1f),
            text = stringResource(R.string.hiring_id),
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            modifier = Modifier.weight(0.1f),
            text = stringResource(R.string.hiring_list_id),
            color = MaterialTheme.colorScheme.onPrimary
        )
        Text(
            modifier = Modifier.weight(0.2f),
            text = stringResource(R.string.hiring_name),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

/**
 * Composable card for individual hiring entries.
 */
@Composable
fun HiringCard(id: Int, listId: Int, name: String) {
    Card(
        modifier = Modifier.padding(top = 4.dp, start = 4.dp, end = 4.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(
                modifier = Modifier.weight(0.1f),
                text = id.toString()
            )
            Text(
                modifier = Modifier.weight(0.1f),
                text = listId.toString()
            )
            Text(
                modifier = Modifier.weight(0.2f),
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/**
 * Composable preview for the hiring screen.
 */
@Preview(showBackground = true)
@Composable
fun HiringScreenPreview() {
    FetchCodingExerciseTheme {
        val list = listOf(
            Person(0, 0, "Able"),
            Person(1, 1, "Ben"),
            Person(2, 2, "Chris")
        )

        HiringScreen(list = list)
    }
}