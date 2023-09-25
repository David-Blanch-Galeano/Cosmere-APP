package com.example.appfinal.navigation

sealed class AppScreens(var route: String){

    object FirstScreen: AppScreens("MenuInicial")
    object ScreenMenu: AppScreens("Menu")
    object SecondScreen: AppScreens("Guia")
    object TherdScreen: AppScreens("Orden")
    object FourthScreen: AppScreens("Cosmere")
    object FithScreen: AppScreens("Personajes")
    object SixScreen: AppScreens("NoCosmere")
    object SevenScreen: AppScreens("Brandon")

}