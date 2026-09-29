//Realiza un programa que defina una variable de tipo Number, inicializada con un valor de tipo Double, Float o Int.
//Después realiza la conversión de la variable a los tres tipos hacia tres variables.
//Finalmente, compara el valor original convertido a Double y el resultado de la conversión del valor original a Int y
//vuelto a convertir a Double, para comprobar si se ha producido pérdida de información. - Haz lo mismo para comprobar
//si se ha producido pérdida de información al pasar a Float.
//Cambia el literal de inicialización de la variable de tipo Number para probar con diferentes posibilidades.

fun analizarPerdida(original: Number) {
    val valorDouble : Double = original.toDouble()
    println("A doble = $valorDouble")
    val valorFloat : Float = original.toFloat()
    println("A Float = $valorFloat")
    val valorInt : Int = original.toInt()
    println("A Int = $valorInt")

    val intADouble: Double = valorInt.toDouble()
    val perdidaInt: Boolean = valorDouble != intADouble
    println("Original -> $valorDouble  vs  Vuelta -> $intADouble")
    if (perdidaInt) {
        println("Hubo perdida")
    } else {
        println("No hubo perdida")
    }

    val intAFloat: Double = valorFloat.toDouble()
    val perdidaFloat: Boolean = valorDouble != intADouble
    println("Original -> $valorDouble  vs  Vuelta -> $intAFloat")
    if (perdidaFloat) {
        println("Hubo perdida")
    } else {
        println("No hubo perdida")
    }
}

fun main() {
    val numero1: Number = 123.456789012345
    analizarPerdida(numero1)

    val numero2: Number = 45.5f
    analizarPerdida(numero2)

    val numero3: Number = 42
    analizarPerdida(numero3)

    val numero4: Number = 100.0
    analizarPerdida(numero4)
}