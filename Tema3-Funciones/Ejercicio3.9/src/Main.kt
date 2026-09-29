//Define una función llamada analyzeScores que acepte los siguientes parámetros en este orden:
//
//minThreshold de tipo Int.
//scores marcado como vararg de tipo Int.
//sortAscending de tipo Boolean con un valor por defecto de true.
//Dentro de la función, haz lo siguiente:
//
//Imprime el valor de minThreshold.
//Itera sobre el parámetro scores e imprime cada puntuación.
//En la función main, llama a analyzeScores dos veces:
//
//La primera llamada debe pasar minThreshold y una lista de cuatro puntuaciones (scores),
// permitiendo que sortAscending use su valor por defecto.
//La segunda llamada debe pasar minThreshold y una lista de dos puntuaciones, pero esta vez,
// debes pasar el valor false al parámetro sortAscending utilizando argumentos con nombre,
// para que el compilador no lo confunda con una puntuación más.

fun analiyzeScores(
    minThreshold: Int,
    vararg scores: Int,
    sortAscending: Boolean = true,
) {
    println("minThreshold: $minThreshold")
    println("sortAscending: $sortAscending")
    print("scores: ")

    for (score in scores) {
        print("$score ")
    }

    println("\n" + "-".repeat(30))

}

fun main() {
    analiyzeScores(5, 4, 3, 2, 1)
    analiyzeScores(4, 3, 2, sortAscending = false)
}