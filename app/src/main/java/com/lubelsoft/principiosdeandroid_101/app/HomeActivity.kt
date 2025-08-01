package com.lubelsoft.principiosdeandroid_101.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.lubelsoft.principiosdeandroid_101.R
import com.lubelsoft.principiosdeandroid_101.app.countries.CountriesListActivity
import androidx.core.content.edit

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


        //Poner ususario en el navigation view

        val headerView = navView.getHeaderView(0)
        val nvHeaderTitle : TextView = headerView.findViewById(R.id.nav_header_title)
        nvHeaderTitle.text = MainActivity.currentUserName ?: "Invitado"



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

    private fun goToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun goToAbout() {
        val intent = Intent(this, BasseActivity::class.java)
        startActivity(intent)
    }

    private fun logout() {
        val prefs = getSharedPreferences("user_session", MODE_PRIVATE)
        prefs.edit { clear() }
        MainActivity.currentUser = null
        MainActivity.currentUserName = null
        MainActivity.currentUserLastName = null
        goToMain()
        finishAffinity()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_paises-> {
                goToCountries()
            }
            R.id.nav_acerca -> {
                goToAbout()
            }
            R.id.nav_logout -> {
                logout()
            }
        }
       drawerLayout.closeDrawers()

        return true
    }
}