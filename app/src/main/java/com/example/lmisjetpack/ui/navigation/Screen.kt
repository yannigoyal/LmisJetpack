package com.example.lmisjetpack.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object AllCourses : Screen("allCourses", "All Courses", Icons.Default.Person)
    data object MyCourses : Screen("myCourses", "My Courses", Icons.Default.Settings)
    data object Dashboard : Screen("dashboard", "Dashboard", Icons.Default.Notifications)

    // Splash and Main (without icons) if needed elsewhere
    data object Splash : Screen("splash", "", Icons.Default.Info)
    data object Main : Screen("main", "", Icons.Default.Menu)
}