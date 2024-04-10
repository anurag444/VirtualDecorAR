package com.example.virtualdecorar.screens

import android.content.Context
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.virtualdecorar.MainActivity
import com.example.virtualdecorar.R
import com.example.virtualdecorar.navigation.AppScreens
import com.example.virtualdecorar.ui.theme.LightGreen1
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController, context: MainActivity) {

    //alpha value to animate the text
    val alpha = remember {
        Animatable(0f)
    }
    
    LaunchedEffect(key1 = true){
        alpha.animateTo(1f,
            animationSpec = tween(2000)
        )
        delay(1000)

        //this will clear the back stack for us
        val name:String = if (!onBoardingFinished(context)){
            AppScreens.OnBoardingScreen.name
        } else{
            AppScreens.LoginScreen.name

        }

        navController.popBackStack()
        navController.navigate(name)
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        LoaderAnimation(
            modifier = Modifier.size(200.dp),
            anim = R.raw.splash
        )
        Text(text = "Virtual Decor", fontSize = 24.sp, color = LightGreen1,
            modifier = Modifier.alpha(alpha.value))
    }
}

private fun onBoardingFinished(context: MainActivity): Boolean {
    val sharedPref = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    return sharedPref.getBoolean("isFinished", false)
}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier)
}
