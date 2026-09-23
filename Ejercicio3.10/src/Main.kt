//Escribe una función en Kotlin llamada calculateAverage que reciba una lista variable de número enteros y calcule su
// media aritmética. El main() deberá llamar a la función con los valores incluidos en un IntArray definido
// previamente en el main().
//Define una función llamada combineData que acepte un único parámetro dataChunks marcado como vararg de tipo Int.
// La función debe recorrer los elementos de dataChunks e imprimir cada valor en una nueva línea.
// En la función main, declara dos arrays inmutables: initialSet, que contenga los enteros 10, 20, y 30; y extraSet,
// que contenga los enteros 40 y 50. Finalmente, llama a la función combineData y, en una sola línea de código,
// pásale todos los elementos de initialSet seguidos por todos los elementos de extraSet.

fun calculateAverage(vararg numbers: Int): Int {
    var sumaNotas: Int = 0

    for(number in numbers) {
        sumaNotas += number
    }

    return sumaNotas / numbers.size
}

fun combineData(vararg dataChuncks: Int) {
    for (dataChunk in dataChuncks) {
        println(dataChunk)
    }
}

fun main() {
    val arrayNotas: IntArray = intArrayOf(3, 3, 5)
    println("La media de es ${calculateAverage(*arrayNotas)}")
    val initialSet: IntArray = intArrayOf(10, 20, 30)
    val extraSet: IntArray = intArrayOf(40, 50)
    combineData(*initialSet, *extraSet)
}