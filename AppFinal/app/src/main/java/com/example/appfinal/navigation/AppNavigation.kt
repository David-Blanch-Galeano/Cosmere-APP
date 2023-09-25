package com.example.appfinal.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appfinal.Screens.*

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route){
            MenuInicial(navController)
        }
        composable(route = AppScreens.ScreenMenu.route){
            MenuInicial(navController)
        }
        composable(route = AppScreens.SecondScreen.route){
            Guia(navController)
        }
        composable(route = AppScreens.TherdScreen.route){
            Orden(navController)
        }
        composable(route = AppScreens.FourthScreen.route){
            Cosmere(navController)
        }
        composable(route = AppScreens.FithScreen.route){
            Personajes(navController)
        }
        composable(route = AppScreens.SixScreen.route){
            NoCosmere(navController)
        }
        composable(route = AppScreens.SevenScreen.route){
            Brandon(navController)
        }
    }
}