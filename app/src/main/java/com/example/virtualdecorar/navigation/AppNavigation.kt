package com.example.virtualdecorar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virtualdecorar.MainActivity
import com.example.virtualdecorar.screens.HomeScreen
import com.example.virtualdecorar.screens.LoginScreen
import com.example.virtualdecorar.screens.SignupScreen
import com.example.virtualdecorar.screens.OnBoardingScreen
import com.example.virtualdecorar.screens.SplashScreen
import com.example.virtualdecorar.screens.TermsAndConditionsScreen

@Composable
fun AppNavigation(context: MainActivity) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name){
        composable(AppScreens.SplashScreen.name){
            SplashScreen(navController = navController, context = context)
        }

        composable(AppScreens.OnBoardingScreen.name){
            OnBoardingScreen(navController = navController, context = context)
        }

        composable(AppScreens.SignupScreen.name){
            SignupScreen(navController = navController)
        }

        composable(AppScreens.LoginScreen.name){
            LoginScreen(navController = navController)
        }

        composable(AppScreens.TermsAndConditionsScreen.name){
            TermsAndConditionsScreen(navController)
        }

        composable(AppScreens.HomeScreen.name){
            HomeScreen(navController = navController)
        }
    }
}