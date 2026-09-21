//Realiza un programa que solicite por consola una cadena de caracteres y diga para cada carácter si está en
// mayúscula, si está en minúscula o no es una letra (la ñ no cuenta como letra), para lo que debe comprobar
// que el código numérico correspondiente al carácter está en el rango numérico de los códigos que van de
// la A la Z, o de la a a la z.
//Realiza los siguientes pasos:
//Define dos variables String, firstName inicializada con el valor Alan y lastName inicializada con Turing,
// y una variable yearOfBirth de tipo Int con el valor 1912.
//A continuación, crea una variable fullName concatenando firstName, un espacio y lastName.
//Después, crea una variable firstChar que acceda al primer carácter de fullName usando la sintaxis de indexación,
// e imprime su valor.
//Luego, crea una variable isSameName y usa el operador de comparación para verificar si firstName es igual a Alan,
// e imprime isSameName.
//Finalmente, define una variable biography como una cadena multilínea que use trimMargin() con el prefijo | y que
// contenga la siguiente información usando plantillas de cadena (cada dato en una línea): Full Name: [Valor de fullName].
// Year: [Valor de yearOfBirth]. The first letter is: [Valor de firstChar]. Imprime el valor de biography.

fun main() {
    print("Introduce una cadena de caracteres: ")
    val cadena: String = readln()

    //del 65 al 90. ñ = 209
    val abecedarioMayus: IntRange = 65..90
    //del 97 al 122. ñ = 241
    val abecedarioMinus: IntRange = 97..122

    for (c in cadena) {
        if (c.code in abecedarioMayus) {
            println("$c es una letra mayúscula")
        }
        if (c.code in abecedarioMinus) {
            println("$c es una letra minúscula")
        }
        if (c.code !in abecedarioMinus && c.code !in abecedarioMayus){
            println("$c no es una letra")
        }
    }

    println("--------------------------------------------------------------")

    val firstName: String = "Alan"
    val lastname: String = "Turing"
    val yearOfBirth: Int = 1912

    val fullName: String = "$firstName $lastname"

    val firstChar: Char = fullName.first()
    println(firstChar)

    val isSameName: Boolean = firstName == "Alan"
    println(isSameName)

    println("--------------------------------------------------------------")

    val biography: String = """
        |Full Name: [Valor de fullName]. 
        |Year: [Valor de yearOfBirth]. 
        |The first letter is: [$firstChar]
    """.trimMargin()

    println(biography)
}