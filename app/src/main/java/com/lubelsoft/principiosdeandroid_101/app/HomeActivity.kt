package com.lubelsoft.principiosdeandroid_101.app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lubelsoft.principiosdeandroid_101.R
import com.lubelsoft.principiosdeandroid_101.app.countries.CountriesListActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnCountries : Button = findViewById(R.id.btn_home_countries)
        val btnCalc : Button = findViewById(R.id.btn_home_calc)
        val btnAbout : Button = findViewById(R.id.btn_home_acerca)

        btnCountries.setOnClickListener {
            goToCountries()
        }


    }

    private fun goToCountries(){
        val intent = Intent(this, CountriesListActivity::class.java)
        startActivity(intent)
    }
}