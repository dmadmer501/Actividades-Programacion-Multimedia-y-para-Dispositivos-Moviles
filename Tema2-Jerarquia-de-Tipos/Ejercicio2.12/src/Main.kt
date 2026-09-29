// Comprueba la pérdida de precisión de Double en operaciones decimales
// y compárala con la aritmética exacta de BigDecimal.

import java.math.BigDecimal

fun main() {
    // Double: representación binaria -> error de redondeo
    val sumaDouble: Double = 0.1 + 0.2
    println("Double 0.1 + 0.2 = $sumaDouble")

    // BigDecimal: construido desde String conserva la precisión decimal
    val a: BigDecimal = "0.1".toBigDecimal()
    val b: BigDecimal = BigDecimal("0.2")
    val sumaExacta: BigDecimal = a + b
    println("BigDecimal 0.1 + 0.2 = $sumaExacta")

    // Conversión directa desde un tipo básico
    val desdeInt: BigDecimal = 5.toBigDecimal()
    println("5 convertido a BigDecimal = $desdeInt")
}
