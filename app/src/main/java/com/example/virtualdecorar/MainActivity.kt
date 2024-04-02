package com.example.virtualdecorar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.virtualdecorar.navigation.AppScreens
import com.example.virtualdecorar.screens.OnBoardingScreen
import com.example.virtualdecorar.screens.SplashScreen
import com.example.virtualdecorar.ui.theme.VirtualDecorARTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VirtualDecorARTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.name){
                        composable(AppScreens.SplashScreen.name){
                            SplashScreen(navController = navController)
                        }

                        composable(AppScreens.OnBoardingScreen.name){
                            OnBoardingScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}