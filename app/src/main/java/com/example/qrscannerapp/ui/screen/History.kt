package com.example.qrscannerapp.ui.screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qrscannerapp.R
import com.example.qrscannerapp.ui.utils.MainViewModel
import com.example.qrscannerapp.ui.utils.TimeConverter

@Composable
fun HistoryScreen(innerPadding:PaddingValues = PaddingValues(30.dp),viewModel: MainViewModel){
    val context:Context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        val history = viewModel.history.collectAsState(initial = listOf())
        if(history.value.isNotEmpty()){
            LazyColumn{
                items(history.value){
                    items ->
                    CardHistory(items.url,items.dateTime,context)
                }
            }
        }else{
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "History is Empty",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }

    }
}

@Composable
fun CardHistory(url:String,dateTime:Long,context: Context){
    Card(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .clickable {
                       context.apply {
                           startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                       }
            },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
                    contentDescription = "Logo",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = url,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = TimeConverter(dateTime))
                }
            }
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "website")
        }
    }

}
