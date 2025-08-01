package com.example.lmisjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.lmisjetpack.ui.navigation.AppNavGraph
import com.example.lmisjetpack.ui.theme.LmisJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LmisJetpackTheme {
                val navController = rememberNavController()
                AppNavGraph(navController)
            }
        }
    }
}
