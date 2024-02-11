package com.example.qrscannerapp.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.qrscannerapp.R

@Composable
fun FloatingButton(){
    FloatingActionButton(
        modifier = Modifier
            .offset(y = 50.dp)
            .size(70.dp)
            .border(width = 4.dp, color = colorResource(id = R.color.blue_secondary), shape = CircleShape),
        shape = CircleShape,
        onClick = {  },
        containerColor = colorResource(id = R.color.blue_primary),
        contentColor = colorResource(id = R.color.blue_tertiary)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
            contentDescription = "Qr",
            modifier = Modifier.size(35.dp),
        )
    }
}