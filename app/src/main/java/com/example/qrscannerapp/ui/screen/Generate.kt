package com.example.qrscannerapp.ui.screen

import android.Manifest
import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import com.example.qrscannerapp.MainActivity
import com.example.qrscannerapp.R
import com.example.qrscannerapp.ui.utils.DownloadUtil
import com.example.qrscannerapp.ui.utils.encodeAsBitmap

@Composable
fun GenerateScreen(innerPadding:PaddingValues = PaddingValues(30.dp)){
    var textUrl by remember{ mutableStateOf("") }
    var bitmapImageState by remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current
    val downloadUtil = DownloadUtil()

    val requestPermission = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {
            permission ->
            if (permission){
                downloadUtil.saveDownloadedImage(context = context, bitmap = bitmapImageState!!)
            }else{
                val rationalRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )

                if(rationalRequired){
                    Toast.makeText(context,"Location Permission is required for this feature to work",
                        Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context,"Location Permission is required. Please enable it in android settings",
                        Toast.LENGTH_LONG).show()
                }
            }

        })
    Column(
        Modifier
            .padding(innerPadding)
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
            OutlinedTextField(
                value = textUrl,
                onValueChange = { textUrl = it },
                label = { Text(text = "Add Text")},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = colorResource(id = R.color.blue_primary),
                    focusedBorderColor = colorResource(id = R.color.blue_primary)
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = {
                    bitmapImageState = encodeAsBitmap(str = textUrl, ctx = context)
                },
                shape = RoundedCornerShape(10),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.blue_primary)
                )
            ) {
                Text(text = "Generate", fontWeight = FontWeight.Medium)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        if(bitmapImageState != null){
            Image(bitmap = bitmapImageState!!.asImageBitmap(), contentDescription = "bitmap image")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                             if(downloadUtil.hasDownloadPermission(context)){
                                 downloadUtil.saveDownloadedImage(context,
                                     bitmapImageState!!
                                 )
                             }else{
                                 requestPermission.launch(
                                     Manifest.permission.WRITE_EXTERNAL_STORAGE
                                 )
                             }


            }, colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                id = R.color.blue_primary
            ))) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.baseline_download_24), contentDescription = "download")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Download")
                }
            }
        }
        
    }
}
