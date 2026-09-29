//Define una función llamada configurePrintJob que acepte tres parámetros inmutables:
//
//fileName de tipo String sin valor por defecto (obligatorio).
//pageSize de tipo Int con un valor por defecto de 200.
//isColorMode de tipo Boolean con un valor por defecto de false.
//Dentro de la función, simplemente imprime una línea que muestre el valor de cada uno de los tres parámetros.
//
//En la función main, debes realizar las siguientes cuatro llamadas a configurePrintJob:
//
//Una llamada pasando solo el argumento obligatorio fileName.
//Una llamada pasando el fileName y el pageSize en orden.
//Una llamada pasando el fileName y, usando argumentos nombrados, solo el valor de isColorMode, dejando que pageSize
// use su valor por defecto.
//Una llamada pasando los tres argumentos de forma completa.

fun configurePrintJob(
    fileName: String,
    pageSize: Int = 200,
    isColorMode: Boolean = false,
) {
    println("$fileName, $isColorMode, $pageSize")
}

fun main() {
    configurePrintJob("NombreDeEjemplo")
    configurePrintJob("NombreDeEjemplo2", 120)
    configurePrintJob("NombreDeEjemplo3", isColorMode = true)
    configurePrintJob("NombreDeEjemplo4", 230, true)
}