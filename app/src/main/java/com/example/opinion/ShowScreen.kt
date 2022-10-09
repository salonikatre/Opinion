package com.example.opinion

import android.icu.text.CaseMap.Title
import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.res.TypedArrayUtils.getText
import com.example.opinion.data.Author

@Composable
fun ShowScreen(author: Author) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints { 
            Surface() {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    ProfileHeader(author = author, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileContent(author = author, containerHeight = this@BoxWithConstraints.maxHeight)

                }
            }

        }

    }
}

@Composable
private fun ProfileHeader(
    author: Author,
    containerHeight: Dp
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = author.authorImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null

    )
}

@Composable
private fun ProfileContent(author: Author, containerHeight: Dp) {
    Column {

        Title(author = author)
        ProfileProperty(label = stringResource(id = R.string.authority) , value = author.authority)
        ProfileProperty(label = stringResource(id = R.string.name), value = author.name.toString())
        ProfileProperty(label = stringResource(id = R.string.article), value = author.article)
        Article(author = author)
        Spacer(modifier = Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))

    }
}

@Composable
private fun Title(author: Author) {
    Column(modifier = Modifier.padding(start = 8.dp)) {
        Text(
            text = author.title,
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
private fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider(modifier = Modifier.padding(bottom = 8.dp))
        Text(
            text = label,
            modifier = Modifier.height(48.dp),
            style = MaterialTheme.typography.button

        )
        Text(
            text = value,
            modifier = Modifier.height(40.dp),
            fontWeight = FontWeight.Thin,
            style = MaterialTheme.typography.caption,
            overflow = TextOverflow.Visible
        )
    }

}
@Composable
private fun Article(author: Author) {
    Column(modifier = Modifier.padding(start = 18.dp)) {
        Text(
            text = author.article,
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Thin
        )
        
    }
}










