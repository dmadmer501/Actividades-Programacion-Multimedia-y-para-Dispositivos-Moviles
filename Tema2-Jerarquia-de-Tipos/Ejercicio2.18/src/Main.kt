// Booleanos: por que mezclar Int y Boolean es error de compilacion,
// cortocircuito con && y ||, y metodos infix and/or sin cortocircuito.

fun main() {
    val condition: Int = 1
    // if (condition) { println("condition es true") }
    // ERROR DE COMPILACION: type mismatch - Int no puede convertirse a Boolean

    // Equivalente explicito y correcto:
    if (condition != 0) {
        println("condition no es cero")
    }

    // El cortocircuito protege el acceso a una referencia nula:
    val texto: String? = null
    val longitud: Int = if (texto != null && texto.length > 3) texto.length else 0
    println("longitud = $longitud")

    // || corta cuando el lado izquierdo ya es true:
    val claveOk: Boolean = false
    val esAdmin: Boolean = true
    if (esAdmin || pedirClave()) {
        println("acceso permitido")
    }

    // and / or son funciones infix: evaluan SIEMPRE los dos operandos
    val resultado: Boolean = claveOk and pedirClave()
    println("resultado = $resultado")
}

fun pedirClave(): Boolean {
    println("  (pidiendo clave...)")
    return false
}
