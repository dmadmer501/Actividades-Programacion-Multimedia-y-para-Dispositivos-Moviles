//Define tres funciones sobrecargadas en el ámbito principal, todas con el nombre sumValues:
//
//La primera versión de sumValues debe aceptar dos parámetros inmutables, firstNumber y secondNumber, ambos de tipo Int,
// y retornar su suma como un Int.
//La segunda versión de sumValues debe aceptar un array de valores de tipo Double llamado doubleValues, y retornar la
// suma de todos ellos como un Double.
//La tercera versión de sumValues debe aceptar dos parámetros inmutables: una String llamada prefix y un Int llamado
// count. Esta función debe retornar una String que contenga
// el prefix repetido count veces (por ejemplo, si prefix es "A-" y count es 3, retorna "A-A-A-").
//En la función main, haz las tres llamadas necesarias para probar cada versión de sumValues y guarda los resultados en
// variables inmutables llamadas resultInt, resultDouble y resultString, respectivamente.
// Finalmente, imprime cada uno de esos tres resultados.

fun sumValues(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}

fun sumValues(doubleValues: DoubleArray): Double {
    var suma = 0.0
    for (value in doubleValues) {
        suma += value
    }
    return suma
}

fun sumValues(prefix: String, count: Int): String {
    var sumaCadena: String = ""
    for (i in 0 ..< count) {
        sumaCadena += prefix
    }
    return sumaCadena
}

fun main() {
    val resultInt = sumValues(3, 2)
    val resultDouble = sumValues(doubleArrayOf(2.3, 3.2))
    val resultString = sumValues("A-", 3)

    println(resultInt)
    println(resultDouble)
    println(resultString)

}