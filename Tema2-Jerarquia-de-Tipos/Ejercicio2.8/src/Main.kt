//Declara una variable inmutable firstVariable a la que asignas un literal numérico entero, y otra variable inmutable
// secondVariable a la que asignas la cadena de texto "Hello World".
//A continuación, declara una tercera variable inmutable, thirdVariable, de tipo explícito Any, y asígnale el valor de
// firstVariable.
//Finalmente, declara una última variable, fourthVariable, de tipo explícito Any?, asígnale el valor null, y luego,
// en una línea posterior, intenta asignarle el valor de secondVariable.

fun main() {
    var firstVariable: Int = 4
    var secondVariable: String = "Hello World"
    var thirdVariable: Any = firstVariable
    var fourthVariable: Any? = null
    fourthVariable = secondVariable
}

