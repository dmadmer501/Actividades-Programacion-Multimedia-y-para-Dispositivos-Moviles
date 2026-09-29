// Creación, copia y conversión de arrays:
// arrayOf, Array(n){lambda}, arrayOfNulls, copyOf (con y sin lambda) y toIntArray.

fun main() {
    // arrayOf(): array con los valores indicados
    val base: Array<String> = arrayOf("foo", "bar", "baz")

    // Array(tamaño) { índice -> valor }: inicialización por lambda
    val cuadrados: Array<Int> = Array(5) { i -> i * i }

    // arrayOfNulls(): array de un tipo nullable relleno de null
    val huecos: Array<Int?> = arrayOfNulls<Int?>(3)

    // copyOf(n): recorta (n menor) o rellena con null (n mayor)
    val truncado: Array<String> = base.copyOf(2)

    // copyOf(n) { indice -> valor }: rellena con lambda (Kotlin 2.2+)
    val ampliado: Array<String> = base.copyOf(5) { i -> "item $i" }

    // toIntArray(): conversión de Array<Int> (boxed) a IntArray (primitivo)
    val primitivo: IntArray = cuadrados.toIntArray()

    println(base.contentToString())
    println(cuadrados.contentToString())
    println(huecos.contentToString())
    println(truncado.contentToString())
    println(ampliado.contentToString())
    println(primitivo.contentToString())
}
