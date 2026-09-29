// Comprobación de tipo con is / !is y smart cast (acceso directo a los
// miembros del tipo comprobado) dentro de if y when.

fun describir(obj: Any): String = when (obj) {
    is String -> "String de longitud ${obj.length}"   // smart cast
    is Int -> "Int incrementado: ${obj + 1}"
    is Boolean -> "Boolean: $obj"
    else -> "Tipo desconocido"
}

fun main() {
    val obj: Any = "Hola"

    if (obj is String) {
        println(obj.uppercase())       // sin cast explícito
    }

    if (obj !is Int) {
        println("obj no es un Int")
    }

    println(describir(42))
    println(describir(true))
    println(describir(3.14))
}
