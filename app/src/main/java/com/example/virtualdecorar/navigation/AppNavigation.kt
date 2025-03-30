package com.example.virtualdecorar.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.example.virtualdecorar.ui.AppState
import com.example.virtualdecorar.ui.arview.navigation.arViewScreen
import com.example.virtualdecorar.ui.arview.navigation.navigateToARView
import com.example.virtualdecorar.ui.download.navigation.downloadScreen
import com.example.virtualdecorar.ui.download.navigation.navigateToDownload
import com.example.virtualdecorar.ui.products.navigation.PRODUCTS_ROUTE
import com.example.virtualdecorar.ui.products.navigation.navigateToProducts
import com.example.virtualdecorar.ui.products.navigation.productsScreen
import timber.log.Timber

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    appState: AppState,
    startDestination: String = PRODUCTS_ROUTE,
    onShowSnackbar: suspend (String, String?) -> Boolean
) {

    val navController = appState.navController
    NavHost(navController = navController,
        startDestination = startDestination,
        modifier = modifier){
//        composable(AppScreens.SplashScreen.name){
//            SplashScreen(navController = navController, context = context)
//        }
//
//        composable(AppScreens.OnBoardingScreen.name){
//            OnBoardingScreen(navController = navController, context = context)
//        }
//
//        composable(AppScreens.SignupScreen.name){
//            SignupScreen(navController = navController)
//        }
//
//        composable(AppScreens.LoginScreen.name){
//            LoginScreen(navController = navController)
//        }
//
//        composable(AppScreens.TermsAndConditionsScreen.name){
//            TermsAndConditionsScreen(navController)
//        }

        productsScreen { productId ->
            Timber.d("Clicked: $productId")
            navController.navigateToDownload(productId)
        }

        downloadScreen() { productId, _, color ->
            navController.navigateToARView(productId, color)
        }

        arViewScreen(
            onNavigateBack = { navController.navigateToProducts() },
            onShowSnackbar = onShowSnackbar
        )
    }
}