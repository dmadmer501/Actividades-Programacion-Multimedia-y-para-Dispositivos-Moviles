// Compara el boxing automático de Kotlin (Array<Int>, genéricos y tipos
// nullables) frente a los arrays de primitivos sin boxing (IntArray).

fun main() {
    // Array<Int>: cada celda guarda un objeto Integer de la JVM (boxed)
    val boxed: Array<Int> = arrayOf(1, 2, 3)
    // IntArray: guarda enteros primitivos de la JVM (sin boxing)
    val primitivo: IntArray = intArrayOf(1, 2, 3)

    for (n in boxed) print("$n ")
    println()
    for (n in primitivo) print("$n ")
    println()

    // Genérico: obliga a usar el tipo boxed, no el primitivo
    val lista: List<Int> = listOf(1, 2, 3)
    // Nullable: null solo cabe en una referencia -> boxed
    val listaConNulos: List<Int?> = listOf(1, null, 3)

    println("Lista boxed: $lista")
    println("Lista nullable: $listaConNulos")
}
