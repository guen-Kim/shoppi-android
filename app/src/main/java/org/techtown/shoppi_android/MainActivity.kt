package org.techtown.shoppi_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // app themes 색상 참조하지 않음.
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_main)
        bottomNavigationView.itemIconTintList = null



    }

}