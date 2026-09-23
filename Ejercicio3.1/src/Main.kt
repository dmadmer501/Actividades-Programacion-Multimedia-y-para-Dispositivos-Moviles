//Realiza un programa en el que se define una función isPrime que reciba un número entero y retorne si es número primo
// o no. La función main() deberá llamar a la función isPrime varias veces con valores diferentes para probarla
// (ver tema Estructuras básicas si lo necesitas)

fun isPrime(entero: Int) : Boolean {
    if (entero <= 1) return false

    if (entero == 2) return true

    if (entero % 2 == 0) return false

    var i = 3
    while (i * i <= entero) {
        if (entero % i == 0) {
            return false
        }
        i += 2
    }
    return true
}

fun main() {
    val testNumbers = arrayOf(-5, 0, 1, 2, 3, 4, 7, 9, 13, 17, 25, 29)

    for (num in testNumbers) {
        if (isPrime(num)) {
            println("El número $num es primo")
        } else {
            println("El número $num no es primo")
        }
    }
}