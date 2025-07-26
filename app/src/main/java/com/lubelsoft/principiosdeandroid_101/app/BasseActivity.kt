package com.lubelsoft.principiosdeandroid_101.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lubelsoft.principiosdeandroid_101.R
import com.lubelsoft.principiosdeandroid_101.app.about.AboutUsActivity
import com.lubelsoft.principiosdeandroid_101.app.about.StoreActivity
import com.lubelsoft.principiosdeandroid_101.app.about.WeAreActivity

open class BasseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, AboutUsActivity::class.java))
                    true
                }

                R.id.nav_nosotros -> {
                    startActivity(Intent(this, WeAreActivity::class.java))
                    true
                }

                R.id.nav_tienda -> {
                    startActivity(Intent(this, StoreActivity::class.java))
                    true
                }

                else -> false
            }
        }

    }

}