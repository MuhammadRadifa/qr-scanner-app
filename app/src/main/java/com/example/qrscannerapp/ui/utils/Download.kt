package com.example.qrscannerapp.ui.utils

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.qrscannerapp.R
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.text.SimpleDateFormat
import java.util.Locale

class DownloadUtil{

    fun hasDownloadPermission(context: Context):Boolean{
        return ContextCompat.checkSelfPermission(
            context,Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun bitmapToInputStream(bitmap: Bitmap): InputStream {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return outputStream.toByteArray().inputStream()
    }

    @Throws(IOException::class)
    fun saveDownloadedImage(context: Context, bitmap: Bitmap) {

        val stream = bitmapToInputStream(bitmap)

        val fileName = SimpleDateFormat(
            "yyyy-MM-dd-HH-mm-ss-SSS",
            Locale.ENGLISH
        ).format(System.currentTimeMillis())

        val contentValues = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "$fileName.png")
            put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
            }
        }

        val resolver = context.contentResolver

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10 and above
            val contentUri = MediaStore.Downloads.EXTERNAL_CONTENT_URI
            val uri = resolver.insert(contentUri, contentValues)
            if (uri != null) {
                resolver.openOutputStream(uri).use { output ->
                    stream.copyTo(output!!)
                }
            }
        } else {
            // Below Android 10
            val target = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "$fileName.png"
            )

            try {
                FileOutputStream(target).use { output ->
                    stream.copyTo(output)
                }
                // Media scanning to make the image appear in the gallery
                context.sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(target)))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        Toast.makeText(context,"Download Success",Toast.LENGTH_LONG).show()
    }

}