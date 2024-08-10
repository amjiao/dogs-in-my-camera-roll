package com.example.jetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun Comments(postId: Int, navController: NavController){

    val post = PostRepo.postList[postId-1]
    var textFieldState by remember{
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ){
        Box(Modifier.align(Alignment.Start)){
            Text(text = "Comments",
                fontSize = 24.sp
            )
        }
        Box(Modifier.fillMaxWidth()){
            TextField(
                value = textFieldState,
                label = {
                    Text("comment...")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.width(275.dp).padding(5.dp).align(Alignment.TopStart).background(color = Color.Gray)
            )
            Button(
                onClick = {
                    if (textFieldState.isNotEmpty()) {
                        post.comments.add(textFieldState)
                        textFieldState = ""
                    }
                },
                modifier = Modifier.align(Alignment.CenterEnd)
            ){
                Text("+")
            }
        }

        LazyColumn{
            items(post.comments.size){
                Text(
                    text = post.comments[it],
                    modifier = Modifier.padding(start = 15.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f)
                )
            }
        }
    }
}
