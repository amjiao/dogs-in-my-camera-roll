package com.example.jetpack

import androidx.compose.ui.graphics.painter.Painter

data class Post (
    val postId: Int,
    val imgId: Int,
    val name : String,
    val breed : String,
    val story : String,
    val notes: String,
    val contentDescription: String,
    var comments : MutableList<String> = mutableListOf()
)