//Crea una variable llamada closedRange que contenga los números enteros desde 10 hasta 15, ambos inclusive,
// usando la sintaxis abreviada. Imprime este rango.
//Crea una variable llamada openRange que contenga las letras desde A hasta D, excluyendo D,
// usando el operador la sintaxis abreviada. Recorre e imprime cada carácter dentro de este rango usando un bucle for.
//Crea una variable llamada evenProgression que contenga los números pares desde 20 hasta 10, en orden descendente,
// con un salto (paso) de 2. Recorre e imprime cada número de esta progresión.
//Crea una variable isInRange que verifique si el número 12 está dentro de closedRange.
// Imprime el resultado de esta verificación (debería ser true).

fun main() {
    val closedRange: IntRange = 10..15
    println(closedRange)

    val openRange: CharRange = 'A'..<'D'
    for (char in openRange) {
        print(char)
    }

    println()

    val evenProgression: IntProgression = 20 downTo 10 step 2
    for (numero in evenProgression) {
        print("$numero ")
    }

    println()

    val isInRange: Boolean = 12 in closedRange
    println(isInRange)
}