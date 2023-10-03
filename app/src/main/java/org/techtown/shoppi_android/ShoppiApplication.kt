package org.techtown.shoppi_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShoppiApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }

}