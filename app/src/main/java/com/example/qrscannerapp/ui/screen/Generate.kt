package com.example.qrscannerapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrscannerapp.R

@Composable
fun GenerateScreen(innerPadding:PaddingValues = PaddingValues(30.dp)){
    Column(
        Modifier
            .padding(innerPadding)
            .padding(horizontal = 10.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            OutlinedTextField(
                value = "www.radifa.my.id",
                onValueChange = {},
                label = { Text(text = "Add Url")},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = colorResource(id = R.color.blue_primary),
                    focusedBorderColor = colorResource(id = R.color.blue_primary)
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue_primary)
                )
            ) {
                Text(text = "Generate", fontWeight = FontWeight.Medium)
            }
        }
        
    }
}

