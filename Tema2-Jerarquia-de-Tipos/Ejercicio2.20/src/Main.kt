// Concatenacion con '+': solo funciona con otros tipos si el PRIMER
// operando es String (Int.plus no acepta un String).

fun main() {
    val s1: String = "abc" + 1        // OK -> "abc1"
    val s2: String = "abc".plus(1)    // equivalente al anterior
    val s3: String = "abc" + true     // OK -> "abctrue"

    // val s4: String = 1 + "abc"     // ERROR DE COMPILACION: Int.plus no recibe String

    // Soluciones equivalentes para el caso invalido:
    val s5: String = "1" + "abc"      // "1abc"
    val s6: String = "abc${1}"        // plantilla -> "abc1"
    val s7: String = 1.toString() + "abc"   // "1abc"

    println(s1)
    println(s2)
    println(s3)
    println("$s5 / $s6 / $s7")

    // Suma numerica dentro de la expresion interpolada:
    val total: Int = 2 + 3
    println("total = ${total + 1}")   // total = 6

    // Comparacion segura de cadenas con '==' (compara contenido, no referencia)
    val a: String = "Baldomero"
    val b: String = "Baldomero"
    println(a == b)                    // true
}
