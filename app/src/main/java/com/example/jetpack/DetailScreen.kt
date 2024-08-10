package com.example.jetpack

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(postId: Int, navController: NavController){
    val post = PostRepo.postList[postId-1]

    var showBottomSheet by remember { mutableStateOf(false)}
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false,
    )
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
        Column(Modifier.padding(innerPadding)){
            Box(
                modifier = Modifier
                    .height(400.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                    .fillMaxWidth()
                    .padding(15.dp),
                contentAlignment = Alignment.Center,

                ) {
                Image(
                    painter = painterResource(post.imgId),
                    contentDescription = post.contentDescription,
                    contentScale = ContentScale.Crop
                )
            }

            Column(horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                Text(text = post.name, fontSize = 24.sp)
                Text(text = "breed: ${post.breed}", fontSize = 18.sp)
                Text(text = "how we met: ${post.story}", fontSize = 18.sp)
                Text(text = "notes: ${post.notes}", fontSize = 18.sp)
                Spacer(Modifier.height(20.dp))

                //comments screen
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    OutlinedButton(
                        onClick = {
                            showBottomSheet = true
                        },
                        shape = RoundedCornerShape(2.dp)
                    ){
                        Text("comments")
                    }

                    if(showBottomSheet){
                        ModalBottomSheet(
                            modifier = Modifier.fillMaxHeight(0.5f),
                            sheetState = sheetState,
                            onDismissRequest = {
                                showBottomSheet = false
                            }
                        ) {
                            Comments(postId, navController)
                        }
                    }
                }
                /*LazyColumn{
                    if(post.comments.size < 3){
                        items(post.comments.size){
                            Text(
                                text = post.comments[it],
                                modifier = Modifier
                                    .padding(start = 15.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }else {
                        items(3) {
                            Text(
                                text = post.comments[it],
                                modifier = Modifier
                                    .padding(start = 15.dp, top = 7.dp, end = 7.dp, bottom = 7.dp)
                                    .fillMaxWidth()
                            )
                        }
                    }
                }*/
            }
        }
        Button(onClick = {
            navController.navigate(Screen.MainScreen.route)
        }){
            Text("< back")
        }
    }
}