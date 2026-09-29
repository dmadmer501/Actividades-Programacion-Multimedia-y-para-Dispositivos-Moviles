import kotlin.random.Random

//Crea un programa en Kotlin que declare una variable de tipo Any? que podrá contener un valor entero, una cadena de
// texto o null, dependiendo de un número aleatorio entre 0 y 100 que debe generarse mediante la
// función Random.nextInt(lim_inf, lim_sup_no_incluido) (comprueba visualmente que se importa el
// paquete kotlin.random.Random al principio de tu programa).
//
//Si el número está en el rango [0, 33], asigna null a la variable. Si el número está en el rango [34, 66], asigna el
// valor 5 a la variable. Si el número está en el rango [67, 100], asigna a la variable la cadena "Baldomero".
//
//El progrma deberá mostrar por pantalla el número aleatorio generado y el tipo de contendio de la variable de
// tipo Any?. Así el programa debe imprimir "La variable es nula" si contiene null, "La variable es un número entero"
// si contiene un valor de tipo Int y "La variable es una cadena de texto" si contiene un valor de tipo String.

fun main() {
    var valor: Any? = Random.nextInt(0, 100)
    val rangoBajo: IntRange = 0..33
    val rangoMedio: IntRange = 34..66
    val rangoAlto: IntRange = 67..100

    if (valor in rangoBajo) {
        println("Salió $valor")
        valor = null
        println("la variable es nula: $valor")
    }

    if (valor in rangoMedio) {
        println("Salió $valor")
        valor = 5
        println("La variable es un número entero: $valor")
    }

    if (valor in rangoAlto) {
        println("Salió $valor")
        valor = "Baldomero"
        println("La variable es una cadena de texto: $valor")
    }
}