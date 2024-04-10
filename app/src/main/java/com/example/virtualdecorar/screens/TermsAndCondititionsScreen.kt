package com.example.virtualdecorar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.virtualdecorar.components.TextBoldHeading
import com.example.virtualdecorar.ui.theme.White

@Composable
fun TermsAndConditionsScreen(navController: NavHostController) {

    Surface(modifier = Modifier
        .fillMaxSize()
        .background(White)
        .padding(16.dp)) {

        TextBoldHeading(value = "Terms and Conditions")
    }
    
}