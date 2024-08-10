package com.example.jetpack

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun MainScreen(navController: NavController) {
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
        Column(modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(modifier = Modifier
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(6.dp),


            ){
                Text(
                    modifier = Modifier.padding(10.dp),
                    fontSize = 45.sp,
                    text = "dogs in my"
                )
                Text(
                    modifier = Modifier.padding(10.dp),
                    fontSize = 45.sp,
                    text = "camera roll :)"
                )
            }

            val gson = Gson()
            LazyColumn{
                items(1){
                    CollectionCard(
                        1,
                        R.drawable.ic_launcher_background,
                        "temp",
                        "collection5",
                        gson.toJson(PostRepo.collection2),
                        PostRepo.collection2.size,
                        navController
                    )
                    CollectionCard(
                        3,
                        R.drawable.ic_launcher_background,
                        "temp",
                        "collection5",
                        gson.toJson(PostRepo.collection2),
                        PostRepo.collection2.size,
                        navController
                    )
                    CollectionCard(
                        2,
                        R.drawable.ic_launcher_background,
                        "temp",
                        "collection5",
                        gson.toJson(PostRepo.collection2),
                        PostRepo.collection2.size,
                        navController
                    )
                }
            }
        }
    }

}