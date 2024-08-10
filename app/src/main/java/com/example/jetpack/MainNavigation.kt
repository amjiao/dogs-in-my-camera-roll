package com.example.jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(Screen.MainScreen.route){
            MainScreen(navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }
        composable(
            route = Screen.DetailScreen.route + "/{postId}",
            arguments = listOf(
                navArgument("postId"){
                    type = NavType.IntType
                    nullable = false
                }
            )){ entry ->
                DetailScreen(postId = entry.arguments?.getInt("postId") ?: error("postId is null"), navController)
        }
        composable(
            route = Screen.CommentScreen.route + "/{postId}",
            arguments = listOf(
                navArgument("postId"){
                    type = NavType.IntType
                    nullable = false
                }
            )
        ){ entry ->
            Comments(postId = entry.arguments?.getInt("postId") ?: error("postId is null"), navController)
        }
        composable(Screen.DogGeneratorScreen.route){
            DogGenerator(navController)
        }
        composable(Screen.ProfileScreen.route){
            Profile(navController)
        }

        val gson = Gson()
        composable(Screen.CollectionScreen.route + "/{list}" + "/{title}",
            arguments = listOf(
                navArgument("title"){
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val itemsJson = backStackEntry.arguments?.getString("list")
            itemsJson?.let {
                val items: List<Post> = gson.fromJson(it, object : TypeToken<List<Post>>() {}.type)
                CollectionScreen(items, navController,
                    title = backStackEntry.arguments?.getString("title") ?: error("title is null")
                )
            }
        }
    }
}



