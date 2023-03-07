package org.techtown.shoppi_android

import android.content.Context
import android.util.Log

class AssetsLoader {


    fun getJsonString(context: Context, fileName: String): String?{
        return kotlin.runCatching {
            loaderAsset(context, fileName)
        }.getOrNull()
    }




    private fun loaderAsset(context: Context, fileName: String): String {
        return context.assets.open(fileName).use { inputStream ->
            val size = inputStream.available()
            val bytes = ByteArray(size)
            inputStream.read(bytes)
            String(bytes)

        }
    }
}

