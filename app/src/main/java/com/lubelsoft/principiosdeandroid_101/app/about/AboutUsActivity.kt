package com.lubelsoft.principiosdeandroid_101.app.about


import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lubelsoft.principiosdeandroid_101.R
import com.lubelsoft.principiosdeandroid_101.app.BasseActivity

class AboutUsActivity : BasseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var toolbar: ActionBar

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about_us)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       // toolbar = supportActionBar!!

    }
}