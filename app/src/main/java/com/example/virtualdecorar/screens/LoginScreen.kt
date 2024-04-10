package com.example.virtualdecorar.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.virtualdecorar.R
import com.example.virtualdecorar.components.ButtonComponent
import com.example.virtualdecorar.components.ClickableLoginComponent
import com.example.virtualdecorar.components.DividerComponent
import com.example.virtualdecorar.components.InputField
import com.example.virtualdecorar.components.InputPasswordField
import com.example.virtualdecorar.components.NormalTextSmallHeading
import com.example.virtualdecorar.components.TextBoldHeading
import com.example.virtualdecorar.components.UnderlinedTextComponent
import com.example.virtualdecorar.navigation.AppScreens
import com.example.virtualdecorar.ui.theme.White

@Composable
fun LoginScreen(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(24.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
        ) {
            NormalTextSmallHeading(value = "Hey There,")
            TextBoldHeading(value = "Welcome Back")

            Spacer(modifier = Modifier.height(20.dp))

            InputField(
                "Email",
                painterResource(id = R.drawable.email)
            )
            InputPasswordField(
                "Password",
                painterResource(id = R.drawable.password)
            )

            UnderlinedTextComponent("Forgot Password?")

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent("Login")

            DividerComponent()

            ClickableLoginComponent("Don't have an account? ", "Register") {
                navController.popBackStack()
                navController.navigate(AppScreens.SignupScreen.name)
            }
        }
    }
}