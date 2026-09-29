// Plantillas de cadena avanzadas ($var, ${expresion}, $$ de Kotlin 2.2+)
// y construcción eficiente de cadenas en bucle con StringBuilder.

fun main() {
    val precio: Double = 29.99
    val rebaja: Double = 9.99

    // Interpolación simple y con expresión
    println("Precio: $precio")
    println("Ahorro: ${precio - rebaja}")

    // Dólar escapado en cadena normal
    println("Precio con \$: \$$precio")

    // Plantilla multilínea con prefijo $$ (Kotlin 2.2.0+):
    // en este modo, $ es literal y se interpola con $$
    val descripcion: String = $$"""
        |Rebajas: $$$rebaja
        |Habitual: $$$precio
        |Ahorro: $$${precio - rebaja}
        """.trimMargin()
    println(descripcion)

    // StringBuilder: más eficiente que concatenar con + dentro de un bucle
    val sb = StringBuilder()
    for (i in 1..5) {
        sb.append("V(${i * i}) ")
    }
    println(sb.toString().trim())
}
