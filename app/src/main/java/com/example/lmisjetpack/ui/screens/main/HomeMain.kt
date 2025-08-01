package com.example.lmisjetpack.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lmisjetpack.ui.components.BottomBar
import com.example.lmisjetpack.ui.navigation.Screen
import com.example.lmisjetpack.ui.screens.home.AllCourses
import com.example.lmisjetpack.ui.screens.home.Dashboard
import com.example.lmisjetpack.ui.screens.home.Home
import com.example.lmisjetpack.ui.screens.home.MyCourses

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMainScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(
        Screen.Home, Screen.AllCourses, Screen.MyCourses, Screen.Dashboard
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text("Home") }) },
        bottomBar = { BottomBar(navController, bottomNavItems) }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) { Home() }
            composable(Screen.AllCourses.route) { AllCourses() }
            composable(Screen.MyCourses.route) { MyCourses() }
            composable(Screen.Dashboard.route) { Dashboard() }
        }
    }
}