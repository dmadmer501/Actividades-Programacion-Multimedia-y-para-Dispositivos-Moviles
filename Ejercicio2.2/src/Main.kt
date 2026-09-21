//Crea una variable que contenga un número entero muy, muy grande (más de 25 dígitos) como un String.
//Convierte ese String a BigInteger usando algún metodo disponible.
//Súmale a este BigInteger el número 99, convertido previamente a BigInteger con algún metodo factoría disponible.
//Imprime el resultado final de la suma.

import java.math.BigInteger

fun main() {
    val numeroGrande: String = "1000000000000000000001"
    val numeroGrandeANumero : BigInteger = numeroGrande.toBigInteger()
    val noventaYNueve : BigInteger = BigInteger.valueOf(99L)
    val resultado : BigInteger = numeroGrandeANumero + noventaYNueve

    println("Numero original: $numeroGrande")
    println("Numero a sumar: $noventaYNueve")
    println("Resultado final: $resultado")
}