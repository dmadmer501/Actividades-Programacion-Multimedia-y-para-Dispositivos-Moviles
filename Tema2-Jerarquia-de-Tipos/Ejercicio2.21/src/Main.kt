// Literales numericos: sufijos L / f, separador de cifras _, inferencia
// de Int frente a Long, y ausencia de notacion octal.

fun main() {
    val entero: Int = 1_000_000                  // 1000000
    val largo: Long = 1_000_000_000_000L          // sufijo L
    val inferido = 12345678912345                 // no cabe en Int -> se infiere Long
    val flotante: Float = 123.5f                  // sufijo f
    val doble: Double = 123.5                     // real sin sufijo -> Double
    val corto: Short = 345                        // sin sufijo: el literal toma el tipo declarado
    val pequeno: Byte = 100

    println("$entero · $largo · $inferido · $flotante · $doble · $corto · $pequeno")
    println("tipo inferido de 'inferido': ${inferido::class.simpleName}")

    // val octal: Int = 0777                      // ERROR: Kotlin no admite octal

    val hex: Int = 0xFF                           // 255
    val bin: Int = 0b1011                         // 11
    println("$hex · $bin")

    // Conversion explicita obligatoria: no hay conversion implicita
    val comoDouble: Double = entero.toDouble()
    val comoByte: Byte = corto.toByte()            // perdio precision: 345 -> 89
    println("$comoDouble · $comoByte")
}
