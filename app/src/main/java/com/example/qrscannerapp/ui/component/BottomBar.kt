package com.example.qrscannerapp.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.qrscannerapp.R
import com.example.qrscannerapp.ui.utils.itemNavigation
import com.example.qrscannerapp.ui.utils.screenNavigation


@Composable
fun BottomBar(navHostController: NavHostController,backStackEntry: NavBackStackEntry?){
    NavigationBar(
        containerColor = Color.White
    ) {
        itemNavigation.forEach {
            item ->
            val isSelected = screenNavigation[item.title] == backStackEntry?.destination?.route
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    selectedIconColor = colorResource(id = R.color.blue_primary),
                    selectedTextColor = colorResource(id = R.color.blue_primary)
                ),
                selected = isSelected,
                label = { Text(text = item.title)},
                onClick = { navHostController.navigate(screenNavigation[item.title]!!) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                    )
                }
            )
        }
    }
}