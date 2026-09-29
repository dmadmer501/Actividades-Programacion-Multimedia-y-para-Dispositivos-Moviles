// Arrays: copyOf recortando y ampliando, copyOfNullable, y por que los
// huecos de ampliacion acaban valiendo null aunque el tipo no lo sea.

fun main() {
    val original: Array<String> = arrayOf("foo", "bar", "baz")

    // Ampliar con copyOf: rellena los huecos, pero el tipo sigue siendo String
    val floja: Array<String> = original.copyOf(5)
    println(floja.contentToString())
    println("¿hueco 4 es null pese a String? ${floja[4] == null}")

    // copyOfNullable: el tipo de retorno es nullable (Array<String?>)
    val segura: Array<String?> = original.copyOfNullable(5)
    println(segura.contentToString())
    println("¿hueco 4 es null? ${segura[4] == null}")

    // Recortar
    val menor: Array<String> = original.copyOf(2)
    println(menor.contentToString())

    // Un array no cambia de tamaño: original conserva sus 3 posiciones
    println("size original = ${original.size}")
}
