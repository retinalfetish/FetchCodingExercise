package com.unary.fetchcodingexercise.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unary.fetchcodingexercise.R
import com.unary.fetchcodingexercise.domain.model.Person
import com.unary.fetchcodingexercise.ui.theme.FetchCodingExerciseTheme

/**
 * Composable Hiring screen. It displays a header with list of Person data objects.
 */
@Composable
fun HiringScreen(list: List<Person>) {
    Column {
        HiringHeader()
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(list) { person ->
                HiringRow(
                    id = person.id,
                    listId = person.listId,
                    name = person.name.toString()
                )
            }
        }
    }
}

@Composable
fun HiringHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp)
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
            modifier = Modifier.weight(0.4f),
            text = stringResource(R.string.hiring_name),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun HiringRow(id: Int, listId: Int, name: String) {
    Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.weight(0.1f),
                text = id.toString()
            )
            Text(
                modifier = Modifier.weight(0.1f),
                text = listId.toString()
            )
            Text(
                modifier = Modifier.weight(0.4f),
                text = name
            )
        }
        HorizontalDivider(color = Color(0x10000000), thickness = 1.dp)
    }
}

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