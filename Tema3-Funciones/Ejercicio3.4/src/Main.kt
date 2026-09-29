//Define una función llamada validateValue que acepte un único parámetro llamado inputNumber de tipo Int y que debe
// devolver un valor de tipo String. Dentro de esta función, utiliza una expresión if para determinar el valor de
// retorno: si inputNumber es mayor que cero, la función debe retornar la cadena "Value is positive". Si inputNumber es
// menor o igual a cero, la función no debe retornar un valor, sino que debe lanzar una excepción de tipo
// IllegalArgumentException con el mensaje "Input must be greater than zero". Asegúrate de que tu if se use como una
// expresión y que la llamada a la excepción actúe como la rama else de esa expresión.

fun validateValue(inputNumber: Int): String {
    if (inputNumber > 0) return "Value is positive"
    else throw IllegalArgumentException("Input must be greater than zero")
}

fun main() {
    println(validateValue(4))
    println(validateValue(0))
}