//Define una función llamada calculateMetrics que acepte exactamente tres parámetros en el siguiente orden: dataList de
// tipo List<Int>, includeAverage de tipo Boolean, y precisionDigits de tipo Int.
//Escribe la declaración de la función usando una sintaxis multilínea para los parámetros y asegúrate de incluir el
// trailing comma después del último parámetro.
//Luego, dentro de la función, simplemente imprime por separado los tres valores que recibe.
//Finalmente, llama a la función calculateMetrics desde la función main proporcionándole argumentos de ejemplo,
// utilizando también la sintaxis multilínea para los argumentos y el correspondiente trailing comma.

fun calculateMetrics(
    dataList: List<Int>,
    includeAverage: Boolean,
    precisionDigits:Int,
) {
    println("$dataList, $includeAverage, $precisionDigits")
}

fun main() {
    calculateMetrics(
        listOf(1, 2, 3),
        true,
        4,
    )
}