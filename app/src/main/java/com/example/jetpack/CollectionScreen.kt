package com.example.jetpack

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CollectionScreen(collection: List<Post>, navController: NavController, title: String){
    Scaffold(
        bottomBar = {
            NavigationBar{
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "home") },
                    label = { Text("home") },
                    selected = false,
                    onClick = { navController.navigate(Screen.MainScreen.route)}
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.PlayArrow, contentDescription = "generate dog") },
                    label = { Text("generate a dog") },
                    selected = false,
                    onClick = { navController.navigate(Screen.DogGeneratorScreen.route)}
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "profile") },
                    label = { Text("profile") },
                    selected = false,
                    onClick = { navController.navigate(Screen.ProfileScreen.route)}
                )
            }
        }
    ){innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)){
            OutlinedButton(onClick = {
                navController.popBackStack()
            }){
                Text("<")
            }
            Row(){
                Column(modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .padding(10.dp)){
                    Text(
                        fontSize = 36.sp,
                        text = "${title}"
                    )
                    Text("@username",
                        fontSize = 24.sp)
                }
            }
            Row(){
                LazyColumn{
                    items(collection.size){
                        ImageCard(
                            collection[it].postId,
                            collection[it].imgId,
                            collection[it].name,
                            collection[it].breed,
                            collection[it].story,
                            collection[it].notes,
                            collection[it].contentDescription,
                            navController
                        )
                    }
                }
            }
        }
    }
}