package com.example.virtualdecorar.screens

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.virtualdecorar.MainActivity
import com.example.virtualdecorar.R
import com.example.virtualdecorar.navigation.AppScreens
import com.example.virtualdecorar.ui.theme.Black
import com.example.virtualdecorar.ui.theme.Green
import com.example.virtualdecorar.ui.theme.LightGreen1
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(navController: NavController, context: MainActivity) {
    val animations = listOf(
        R.raw.splash,
        R.raw.intro1,
        R.raw.intro2
    )

    val titles = listOf(
        "Virtual Decor",
        "Explore ",
        "Virtual view"
    )

    val descriptions = listOf(
        "Welcome to Virtual Decor",
        "Explore wide varieties of furniture's.",
        "Get Virtual view of furniture's"
    )

    val pager = rememberPagerState(pageCount = animations.size)
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        //adding a column to separate the pager and page indicator
        HorizontalPager(state = pager,
            modifier = Modifier.wrapContentSize()) { currentPage->
            //Layout for onboarding screen
            Column(modifier = Modifier
                .wrapContentSize()
                .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {

                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animations[currentPage]))
                //Animation
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(400.dp)
                )
                //Main text
                Text(
                    text = titles[currentPage],
                    textAlign =  TextAlign.Center,
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold
                )

                //Description text
                Text(
                    text = descriptions[currentPage],
                    Modifier.padding(top = 16.dp),
                    textAlign =  TextAlign.Center,
                    fontSize = 20.sp
                )

            }

            
        }

        PageIndicator(
            pageCount = animations.size,
            currentPage =  pager.currentPage,
            modifier = Modifier.padding(36.dp)
        )


    }

    BottomButtons(
        pager = pager,
        navController = navController,
        pageCount = animations.size,
        context = context
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomButtons(pager: PagerState, navController: NavController, pageCount: Int, context: MainActivity) {

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)
    ){
        if(pager.currentPage != pageCount - 1){
            Text(text = "Next",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clickable {
                        scope.launch {
                            pager.scrollToPage(pager.currentPage + 1)
                        }
                    },
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Black
            )

            Text(text = "Back",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .alpha(if (pager.currentPage == 0) 0f else 1f)
                    .clickable {
                        scope.launch {
                            pager.scrollToPage(pager.currentPage - 1)
                        }
                    },
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Black
            )
        }
        else{
            OutlinedButton(onClick = {
                onBoardingFinished(context)
                navController.popBackStack()
                navController.navigate(AppScreens.HomeScreen.name)
            },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightGreen1
                )) {
                Text(text = "Get Started",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Black
                )
            }
        }

    }
}

@Composable
fun PageIndicator(pageCount: Int, currentPage: Int, modifier: Modifier) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ){
      //We will add this composable pagecount number of time, so will use repeat

        repeat(pageCount){
            Indicator(isSelected = it == currentPage)
        }
    }
}

private fun onBoardingFinished(context: MainActivity) {
    val sharedPref = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    val editor = sharedPref.edit()
    editor.putBoolean("isFinished", true)
    editor.apply()
}

@Composable
fun Indicator(isSelected: Boolean) {

    val width = animateDpAsState(targetValue = if (isSelected) 36.dp else 16.dp, label = "")
    Box(modifier = Modifier
        .padding(2.dp)
        .height(16.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(if (isSelected) Green else LightGreen1)
        )
}
