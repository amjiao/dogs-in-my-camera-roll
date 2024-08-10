package com.example.jetpack

import DogViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun DogGenerator(navController: NavController, dogViewModel: DogViewModel = viewModel()) {
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
    ){ innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ){
            val dogImageUrl by dogViewModel.dogImageUrl.observeAsState()
            Button(onClick = {
                navController.navigate(Screen.MainScreen.route)
            }) {
                Text("<")
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                dogImageUrl?.let { url ->
                    Image(
                        painter = rememberImagePainter(url),
                        contentDescription = null,
                        modifier = Modifier
                            .size(300.dp)
                            .padding(16.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(onClick = { dogViewModel.fetchRandomDogImage() }) {
                    Text("Fetch New Dog Image")
                }
            }
        }

    }
}

