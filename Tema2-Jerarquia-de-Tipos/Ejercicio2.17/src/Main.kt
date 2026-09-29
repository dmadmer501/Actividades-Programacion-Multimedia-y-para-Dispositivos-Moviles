// Rangos de coma flotante: ClosedFloatingPointRange con .. (cerrado) y
// ..< (abierto en el extremo derecho), y pertenencia con in / !in.

fun main() {
    val temperatura: Double = 22.5
    val rangoCalor: ClosedFloatingPointRange<Double> = 20.0..30.0
    val rangoAgua: OpenEndRange<Double> = 0.0..<100.0

    println("22.5 in 20.0..30.0   -> ${temperatura in rangoCalor}")
    println("30.0 in 20.0..30.0   -> ${30.0 in rangoCalor}")
    println("100.0 in 0.0..<100.0 -> ${100.0 in rangoAgua}")
    println("22.5 !in 20.0..30.0  -> ${temperatura !in rangoCalor}")

    // Los tipos de coma flotante no tienen clase de rango dedicada: se
    // recorren con una lista de valores, no con un step de progresión.
    val valores: List<Double> = listOf(0.0, 0.5, 1.0, 1.5)
    for (v in valores) {
        println("$v en [0.0, 1.0] -> ${v in 0.0..1.0}")
    }
}
