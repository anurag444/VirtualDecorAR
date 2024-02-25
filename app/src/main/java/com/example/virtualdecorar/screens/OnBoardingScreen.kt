package com.example.virtualdecorar.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun OnBoardingScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "On Boarding Screen")
    }
}