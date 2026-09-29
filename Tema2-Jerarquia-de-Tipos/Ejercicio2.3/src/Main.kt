//Crea una variable llamada initialLetter de tipo Char y asígnale el carácter K.
//Crea una variable tab de tipo Char y asígnale el carácter de tabulación.
//Crea una variable asciiCode de tipo Int. Asígnale el valor Unicode de initialLetter usando la propiedad adecuada de Char.
//Crea una variable codeForSymbol de tipo Int y asígnale el valor Unicode del carácter correspondiendo al signo de dólar.
//Intenta escribir una condición if para verificar si initialLetter es igual al número 75. Comenta esta
// línea de código inmediatamente después de escribirla, y explica en un comentario (con una sola frase) por qué genera
// un error de compilación.
//Imprime initialLetter, tab, asciiCode y codeForSymbol.

fun main() {
    val initialLetter: Char = 'k'
    val tab: Char = '\t'
    val asciiCode: Int = initialLetter.code
    val codeForSymbol: Int = '$'.code

//    if (initialLetter == 75) {
//        println("son iguales")
//    } else {
//        println("no son iguales")
//    }
// Da error, ya que no se pueden comparar un tipo char con un tipo int

    if (initialLetter.code == 75) {
        println("son iguales")
    } else {
        println("son iguales")
    }

    println(initialLetter)
    println(tab)
    println(asciiCode)
    println(codeForSymbol)

}