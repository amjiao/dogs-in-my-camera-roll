package com.example.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Collection (
    val collectionId: Int,
    val imgId: Int,
    val contentDescription: String,
    val list: List<Post>,
    val size: Int,
    val name : String
)

@Composable
fun CollectionCard(
    collectionId: Int,
    imgId: Int,
    contentDescription: String,
    title: String,
    list: String,
    size: Int,
    navController: NavController
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable{
                navController.navigate(Screen.CollectionScreen.route + "/$list" + "/$title")
            },
        shape = RoundedCornerShape(15.dp)
    ){
        Box(modifier = Modifier
            .height(250.dp)
            .background(color = Color.White),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(imgId),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 400f
                    )
                )
            )
            Spacer(Modifier.padding(15.dp))
            Column(verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize()
            ){
                Text(text = title,
                    color = Color.White,
                    fontSize = 20.sp,
                )
                Text("${size} images",
                    color = Color.White
                )
            }

        }
    }
}