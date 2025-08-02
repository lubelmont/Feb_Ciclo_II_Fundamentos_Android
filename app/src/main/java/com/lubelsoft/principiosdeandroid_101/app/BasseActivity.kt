package com.lubelsoft.principiosdeandroid_101.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lubelsoft.principiosdeandroid_101.R
import com.lubelsoft.principiosdeandroid_101.app.about.AcercaDeFragment
import com.lubelsoft.principiosdeandroid_101.app.about.NosotrosFragment
import com.lubelsoft.principiosdeandroid_101.app.about.TiendaFragment


class BasseActivity : AppCompatActivity(){

        private lateinit var bottomNavigationView: BottomNavigationView
        private lateinit var drawerLayout: DrawerLayout

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_base)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            // Configurar toolbar con estilo más moderno
            setupToolbar()

            bottomNavigationView = findViewById(R.id.bottomNavigationView)


            bottomNavigationView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_acerca_de -> {
                        loadFragment(AcercaDeFragment())

                        true
                    }
                    R.id.nav_nosotros -> {
                        loadFragment(NosotrosFragment())
                        true
                    }
                    R.id.nav_tienda -> {
                        loadFragment(TiendaFragment())
                        true
                    }
                    else -> false
                }
            }

            // Cargar fragment por defecto al iniciar
            loadFragment(AcercaDeFragment())
            bottomNavigationView.selectedItemId = R.id.nav_acerca_de

        }

        private fun setupToolbar() {
            findViewById<Toolbar>(R.id.toolbar).apply {
                setSupportActionBar(this)
                // Aquí puedes agregar más configuraciones del toolbar si necesitas
                // title = "Mi App"
                // subtitle = "Subtítulo"
                setBackgroundColor(resources.getColor(android.R.color.white, theme))
                supportActionBar?.title = "Fragments"
                supportActionBar?.subtitle = "Ejemplos"
                supportActionBar?.setDisplayHomeAsUpEnabled(true)

            }
        }

        private fun loadFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .commit()
        }

        override fun onSupportNavigateUp(): Boolean {
            onBackPressedDispatcher.onBackPressed()
            return true
        }
    }
