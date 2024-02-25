package com.example.virtualdecorar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.virtualdecorar.R
import com.example.virtualdecorar.ui.theme.Green
import com.example.virtualdecorar.ui.theme.WhiteSHADE2
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

@Composable
fun SplashScreen(navController: NavHostController) {



    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Green),
        contentAlignment = Alignment.Center){
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(painterResource(id = R.drawable.furniture), contentDescription = "furniture icon",
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop)

            Text(text = "VirtualDecor",
                style = MaterialTheme.typography.displaySmall,
                fontSize = 28.sp,
                color = WhiteSHADE2,
                modifier = Modifier.padding(start = 4.dp))
        }
    }
}