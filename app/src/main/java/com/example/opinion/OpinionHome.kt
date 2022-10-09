package com.example.opinion

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.opinion.data.DataProvider
import androidx.compose.foundation.lazy.items
import com.example.opinion.data.Author

@Composable
fun OpinionHomeContent(navigateToProfile: (Author) -> Unit) {
    val authors = remember { DataProvider.authorList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp )
    ) {
        items(
            items = authors,
            itemContent = {
                AuthorListItem(author = it, navigateToProfile)
            }
        )
    }
}
