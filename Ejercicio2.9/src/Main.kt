//Realiza un programa que solicite las notas de 4 exámenes, los almacene en un array, y después recorra el array y
// obtenga y muestre por pantalla la media aritmética de las notas (ver tema Estructuras básicas).

fun main() {
    val notas: DoubleArray = DoubleArray(4)

    for (i in 0 ..< notas.size) {
        print("Introduce la nota del examen ${i + 1}: ")
        notas[i] = readln().toDouble()
    }

    var suma: Double = 0.0
    for (nota in notas) {
        suma += nota
    }

    val media: Double = suma / notas.size
    println("La media de las notas es: $media")
}

