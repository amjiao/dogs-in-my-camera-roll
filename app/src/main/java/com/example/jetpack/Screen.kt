package com.example.jetpack

sealed class Screen(val route: String){
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object HomeScreen : Screen("home_screen")
    object CommentScreen : Screen("comment_screen")
    object DogGeneratorScreen : Screen("dog_generator_screen")
    object ProfileScreen : Screen("profile_screen")
    object CollectionScreen : Screen("collection_screen")

    fun withArgs(vararg args: String): String {
        return buildString{
            append(route)
            args.forEach{
                append("/$args")
            }
        }
    }
}
