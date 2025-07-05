package com.lubelsoft.principiosdeandroid_101.ejecicios

import android.util.Log
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import org.json.JSONArray
import java.io.IOException

fun main(){

    getContriesFromAmerica()
    Thread.sleep(5000)
}


fun getContriesFromAmerica(){
    var client = OkHttpClient()
    var request = okhttp3.Request.Builder()
        .url("https://restcountries.com/v3.1/region/Americas?fields=name,flags")
        .build()

    client.newCall(request).enqueue(object : okhttp3.Callback {
        override fun onFailure(call: Call, e: IOException) {
            e.printStackTrace()


        }

        override fun onResponse(call: Call, response: Response) {
            response.body?.let { responseBody ->
                val json = JSONArray(responseBody.string())
               println(json)
            }
        }
    })

}