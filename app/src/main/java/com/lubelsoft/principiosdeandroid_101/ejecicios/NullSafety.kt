package com.lubelsoft.principiosdeandroid_101.ejecicios


/**
 * Null safety
 */
fun main(){

    //var nombre: String = "Luis"
    var nombre: String? = null
    println(nombre)


    var apellido: String? = "Apellido"
    var appellidoMaterno = apellido ?: "Sin apellido materno"

    println(appellidoMaterno)

    val longitud = apellido!!.length;



    //Lambdas




   val suma = {a: Int, b: Int -> a + b}


    println(suma(2,3))



    var lista = listOf(1,2,3,4,5)

    lista.forEach { numero ->
        println(numero)
    }



}


fun sumaFunc(a: Int, b: Int): Int
{
    return a + b
}
