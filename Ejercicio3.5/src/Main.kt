//Realiza un programa en el que definas una función isLeapYear que reciba un año e indique si es bisiesto o no
// calculándolo mediante una única expresión. Prueba la función con distintos valores.

fun isLeapYear(year: Int): Boolean = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

fun main() {
    val TestYear = intArrayOf(
        2024, // Bisiesto: divisible por 4 y no por 100
        2025, // No bisiesto: no divisible por 4
        2000, // Bisiesto: divisible por 400
    )

    for (year in TestYear) {
        val result = if (isLeapYear(year)) "es bisiesto" else "no es bisiesto"
        println("El anio $year $result")
    }
}
