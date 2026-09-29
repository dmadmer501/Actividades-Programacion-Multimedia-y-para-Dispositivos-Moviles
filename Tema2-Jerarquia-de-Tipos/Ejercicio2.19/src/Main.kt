// Las tres restricciones que el compilador aplica a un tipo nullable:
// 1) no permite acceder a sus miembros directamente
// 2) no permite asignarlo a un tipo no-nullable
// 3) no permite pasarlo a una funcion que espere un tipo no-nullable

fun longitudSegura(s: String): Int = s.length

fun main() {
    val nombre: String = "Ana"
    var apodo: String? = "Ani"

    println(nombre.length)

    // println(apodo.length)            // ERROR: acceso no seguro sobre nullable
    // val copia: String = apodo        // ERROR: tipos incompatibles
    // println(longitudSegura(apodo))   // ERROR: String? no vale donde se espera String

    // Formas de resolver las tres restricciones:
    println(longitudSegura(apodo!!))          // asercion no-nula
    println(apodo?.length ?: 0)               // safe call + Elvis
    println(longitudSegura(apodo ?: "Guest")) // Elvis como valor por defecto

    apodo = null
    println(apodo?.length ?: "es null")       // sin asercion: no lanza
}
