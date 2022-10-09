package com.example.opinion.data

import java.io.Serializable

data class Author(
    val id: Int,
    val title: String,
    val authority: String,
    val name: String,
    val article: String,
    val authorImageId: Int = 0
) : Serializable