package com.example.virtualdecorar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virtualdecorar.screens.OnBoardingScreen
import com.example.virtualdecorar.screens.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name){
        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController = navController)
        }

        composable(AppScreens.OnBoardingScreen.name){
            OnBoardingScreen(navController = navController)
        }

        composable(AppScreens.HomeScreen.name){

        }
    }
}