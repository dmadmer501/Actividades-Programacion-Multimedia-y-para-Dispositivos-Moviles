//Escribe una clase en Kotlin llamada De0a100 que represente un rango de números enteros de 0 a 100. Dentro de esta
// clase, define una función infija contains que permita verificar si un número entero está dentro del rango definido
// por la instancia de De0a100.
//Define una clase simple llamada ActionExecutor. Esta clase no debe tener propiedades ni constructor.
// Dentro de la clase ActionExecutor, define una función infix llamada perform que cumpla con los siguientes requisitos:
//
//Acepte un único parámetro inmutable llamado actionName de tipo String.
//
//Imprima la cadena "Executing action: " seguida del valor de actionName.
//En la función main:
//
//Crea una instancia mutable de ActionExecutor llamada executorInstance.
//Llama a la función perform de dos maneras para ejecutar la acción "Cleanup":
//Una vez utilizando la notación estándar (con punto y paréntesis).
//Una vez utilizando la notación infija.

class de0a100 {
    val rango: IntRange = 0..100

    infix fun contains(value:Int): Boolean {
        return value in rango
    }
}

class ActionExecutor {
    infix fun perform(actionName: String) {
        println("Executing action: $actionName")
    }
}

fun main() {
    val executionInstance = ActionExecutor()
    executionInstance.perform("Cleanup")
    executionInstance perform "Cleanup"
}