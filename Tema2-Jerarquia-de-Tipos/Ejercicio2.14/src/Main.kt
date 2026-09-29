// Distingue "tipo" de "clase": herencia, interfaces y subtipos.
// Aplica el principio de sustitución de Liskov (la L de SOLID).

open class Animal(val nombre: String)

class Perro(nombre: String) : Animal(nombre)

// Subtipo sin herencia: una clase que implementa una interfaz también es
// subtipo del tipo de la interfaz.
interface Mascota {
    fun jugar(): String
}

class Gato(nombre: String) : Animal(nombre), Mascota {
    override fun jugar(): String = "$nombre juega con una bola de lana"
}

// Acepta el tipo Animal (supertipo) -> cualquier subtipo sirve (Liskov)
fun describir(animal: Animal): String = "Es un ${animal.nombre}"

fun main() {
    val perro: Perro = Perro("Rex")
    println(describir(perro))          // Perro es subtipo de Animal

    val gato: Gato = Gato("Michi")
    println(describir(gato))
    println(gato.jugar())

    // Una clase genera al menos dos tipos: String y String?
    // String es subtipo de String?, por eso se puede asignar aquí.
    val texto: String = "hola"
    val nullable: String? = texto
    println("Longitud: ${nullable?.length ?: 0}")
}
