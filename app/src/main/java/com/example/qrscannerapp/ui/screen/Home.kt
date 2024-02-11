package com.example.qrscannerapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.qrscannerapp.R

@Composable
fun HomeScreen(innerPadding:PaddingValues){
    Column(Modifier.fillMaxSize().padding(innerPadding), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            modifier = Modifier.fillMaxSize(0.6f),
            painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
            contentDescription = "Baseline",
            tint = colorResource(id = R.color.blue_primary)
        )
        Text(text = "Scan Your QR", fontSize = 28.sp, fontWeight = FontWeight.Bold)
    }
}
