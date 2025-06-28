package com.lubelsoft.principiosdeandroid_101.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import com.lubelsoft.principiosdeandroid_101.R

class MainActivity : AppCompatActivity() {


    private lateinit var db: FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val btnIniciar = findViewById<AppCompatButton>(R.id.btnOne)
        val etUser = findViewById<AppCompatEditText>(R.id.etUser)
        val etPassword = findViewById<AppCompatEditText>(R.id.etPassword)


        btnIniciar.setOnClickListener {

            if(etUser.text.isNullOrEmpty() || etPassword.text.isNullOrEmpty()){
                Toast.makeText(this, "Por favor ingrese usuario y contraseña", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

            iniciarSesion(etUser.text.toString().trim(), etPassword.text.toString().trim())
            //testConection()
        }


    }

    private fun testConection(){

        db = FirebaseFirestore.getInstance()
        db.collection("test").add(mapOf("timestamp" to System.currentTimeMillis()))

    }


    private fun iniciarSesion(usuario: String, password: String){


        db = FirebaseFirestore.getInstance()

        db.collection("users")
            .whereEqualTo("username", usuario)
            .whereEqualTo("password", password)
            .get()
            .addOnSuccessListener { documents ->
                if(documents.isEmpty){
                    Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
                    navigateToListContry()

                }
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents: ", exception)

            }

    }

    private fun navigateToListContry(){
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

}


