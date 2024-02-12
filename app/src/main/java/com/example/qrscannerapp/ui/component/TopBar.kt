package com.example.qrscannerapp.ui.component

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.example.qrscannerapp.R
import com.example.qrscannerapp.ui.utils.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navBackStackEntry: NavBackStackEntry?){
    CenterAlignedTopAppBar(
        modifier = Modifier
            .height(64.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.blue_primary)
        ),
        navigationIcon = {
            if(navBackStackEntry?.destination?.route != Screen.QrScreen.route){
                IconButton(onClick = { /*TODO*/ },Modifier.fillMaxHeight()) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                }
            }
        },
        title = {
            Text(
                text = "QR Scanner",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.Medium,
                color = Color.White
            ) },
    )
}