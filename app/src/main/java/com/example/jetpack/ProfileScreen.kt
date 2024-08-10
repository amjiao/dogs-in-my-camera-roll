package com.example.jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun Profile(navController: NavController){
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
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Spacer(Modifier.padding(25.dp))
            Icon(
                Icons.Filled.Person,
                contentDescription = "profile",
                Modifier.size(100.dp)
            )

            Box(Modifier.padding(15.dp)){
                Text("@profile",
                    fontSize = 36.sp
                )
            }

            Text("member since: 2023", fontSize = 20.sp)
            Text("15 posts, 2 collections", fontSize = 20.sp)

            Spacer(Modifier.padding(20.dp))
            Text(text = "My Collections",
                fontSize = 36.sp
            )
            val gson = Gson()
            LazyColumn{
                items(1) {
                    CollectionCard(
                        1, R.drawable.benny,
                        "collection1",
                        "natalies second chance",
                        gson.toJson(PostRepo.postList),
                        PostRepo.postList.size,
                        navController
                    )
                    CollectionCard(
                        2, R.drawable.allie,
                        "collection2",
                        "other dogs",
                        gson.toJson(PostRepo.collection2),
                        PostRepo.collection2.size,
                        navController
                    )
                }
            }
        }
    }
}
