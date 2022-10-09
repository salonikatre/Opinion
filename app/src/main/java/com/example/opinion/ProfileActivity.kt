package com.example.opinion

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.example.opinion.data.Author
import com.example.opinion.ui.theme.OpinionTheme

class ProfileActivity : ComponentActivity() {

    private val author: Author by lazy {
        intent?.getSerializableExtra(AUTHOR_ID) as Author
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpinionTheme {
                ShowScreen(author = author)
            }
        }
    }
    companion object {
        private const val AUTHOR_ID = "author_id"
        fun newIntent(context: Context, author: Author) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(AUTHOR_ID, author)

            }
    }
}