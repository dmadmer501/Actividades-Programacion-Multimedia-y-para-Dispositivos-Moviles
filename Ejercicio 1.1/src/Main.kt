//Ejercicio
//
//
// Realiza un programa que solicite por consola tres números enteros, y los muestre por pantalla en orden.
// Nota: los if en Kotlin tienen una estructura similar a en Java. NO utilices Kotlin Playground para
// hacer el ejercicio, porque no podrás introducir datos por consola.

fun main() {
    print("Escribe el primer número: ")
    val numero1 : Int = readln().toInt()
    print("Escribe el segundo número: ")
    val numero2 : Int = readln().toInt()
    print("Escribe el tercer número: ")
    val numero3 : Int = readln().toInt()

    if (numero1 > numero2 && numero1 > numero3) {
        if (numero2 > numero3) {
            print("$numero3 - $numero2 - $numero1")
        } else {
            print("$numero2 - $numero3 - $numero1")
        }
    }

    if (numero2 > numero1 && numero2 > numero3) {
        if (numero1 > numero3) {
            print("$numero3 - $numero1 - $numero2")
        } else {
            print("$numero1 - $numero3 - $numero2")
        }
    }

    if (numero3 > numero1 && numero3 > numero2) {
        if (numero1 > numero2) {
            print("$numero1 - $numero1 - $numero3")
        } else {
            print("$numero1 - $numero2 - $numero3")
        }
    }
}