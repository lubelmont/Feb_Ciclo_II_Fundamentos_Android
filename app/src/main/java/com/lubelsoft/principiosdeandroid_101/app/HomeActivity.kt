package com.lubelsoft.principiosdeandroid_101.app

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.lubelsoft.principiosdeandroid_101.R
import com.lubelsoft.principiosdeandroid_101.app.countries.CountriesListActivity

class HomeActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {


    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home_content)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //configurar toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            0,0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()



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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_paises-> {
                goToCountries()
            }
        }
       drawerLayout.closeDrawers()

        return true
    }
}