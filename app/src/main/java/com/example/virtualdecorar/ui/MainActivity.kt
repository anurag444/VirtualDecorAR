package com.example.virtualdecorar.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.virtualdecorar.data.utils.NetworkMonitor
import com.example.virtualdecorar.ui.theme.VirtualDecorARTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberAppState(
                networkMonitor = networkMonitor
            )

            VirtualDecorARTheme {
                VirtualDecorARApp(appState)
            }
        }
    }
}