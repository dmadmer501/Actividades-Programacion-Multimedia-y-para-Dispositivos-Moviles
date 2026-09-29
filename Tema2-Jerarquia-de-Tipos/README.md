# 02.1 · Ejercicios 2: Jerarquía de Tipos

> [!NOTE]
> **Origen:**
> Programación Multimedia y Dispositivos Móviles · Tema 2: Jerarquía de tipos
> Apuntes relacionados: 02 - Jerarquia de tipos · Boletín anterior: 01.1 - Ejercicios 1 Introduccion a Kotlin
> **Ruta fuente:** `/home/Dublem/Documentos/Programas_clase/Programación Multimedia y para Dispositivos Móviles/Tema2-Jerarquia-de-Tipos/`

---

## Índice de Ejercicios

- [Ejercicio 2.1 · Tipo Number y análisis de pérdida de precisión en conversiones](#ejercicio-21-tipo-number-y-análisis-de-pérdida-de-precisión-en-conversiones)
- [Ejercicio 2.2 · Números gigantes con BigInteger](#ejercicio-22-números-gigantes-con-biginteger)
- [Ejercicio 2.3 · Tipo Char, código Unicode y seguridad de tipos](#ejercicio-23-tipo-char-código-unicode-y-seguridad-de-tipos)
- [Ejercicio 2.4 · Rangos cerrados, abiertos, progresiones y operador in](#ejercicio-24-rangos-cerrados-abiertos-progresiones-y-operador-in)
- [Ejercicio 2.5 · Evaluación en cortocircuito frente a evaluación completa en booleanos](#ejercicio-25-evaluación-en-cortocircuito-frente-a-evaluación-completa-en-booleanos)
- [Ejercicio 2.6 · Procesamiento de cadenas, filtrado por código ASCII y cadenas multilínea](#ejercicio-26-procesamiento-de-cadenas-filtrado-por-código-ascii-y-cadenas-multilínea)
- [Ejercicio 2.7 · Tipos nullables frente a no-nullables](#ejercicio-27-tipos-nullables-frente-a-no-nullables)
- [Ejercicio 2.8 · Jerarquía de tipos: Any y Any?](#ejercicio-28-jerarquía-de-tipos-any-y-any)
- [Ejercicio 2.9 · Media de un array de notas (DoubleArray)](#ejercicio-29-media-de-un-array-de-notas-doublearray)
- [Ejercicio 2.10 · Variable Any? con contenido aleatorio y rangos](#ejercicio-210-variable-any-con-contenido-aleatorio-y-rangos)
- [Ejercicio 2.11 · Boxing: Array<Int> frente a IntArray](#ejercicio-211-boxing-arrayint-frente-a-intarray)
- [Ejercicio 2.12 · Precisión decimal: Double frente a BigDecimal](#ejercicio-212-precisión-decimal-double-frente-a-bigdecimal)
- [Ejercicio 2.13 · Plantillas de cadena avanzadas y StringBuilder](#ejercicio-213-plantillas-de-cadena-avanzadas-y-stringbuilder)
- [Ejercicio 2.14 · Tipo frente a clase: herencia, interfaces y Liskov](#ejercicio-214-tipo-frente-a-clase-herencia-interfaces-y-liskov)
- [Ejercicio 2.15 · Comprobación de tipo: is, !is y smart cast](#ejercicio-215-comprobación-de-tipo-is-is-y-smart-cast)
- [Ejercicio 2.16 · Creación, copia y conversión de arrays](#ejercicio-216-creación-copia-y-conversión-de-arrays)
- [Ejercicio 2.17 · Rangos de coma flotante: .. y ..](#ejercicio-217-rangos-de-coma-flotante--y-)
- [Ejercicio 2.18 · Booleanos: cortocircuito y métodos infix and/or](#ejercicio-218-booleanos-cortocircuito-y-métodos-infix-andor)
- [Ejercicio 2.19 · Restricciones del compilador sobre tipos nullables](#ejercicio-219-restricciones-del-compilador-sobre-tipos-nullables)
- [Ejercicio 2.20 · Concatenación con + y comparación de cadenas](#ejercicio-220-concatenación-con--y-comparación-de-cadenas)
- [Ejercicio 2.21 · Literales numéricos: sufijos, separadores e inferencia](#ejercicio-221-literales-numéricos-sufijos-separadores-e-inferencia)
- [Ejercicio 2.22 · copyOf/copyOfNullable y huecos null](#ejercicio-222-copyofcopyofnullable-y-huecos-null)

---

## Ejercicio 2.1 · Tipo Number y análisis de pérdida de precisión en conversiones

> [!NOTE]
> **Enunciado:**
> Realiza un programa que defina una variable de tipo `Number`, inicializada con un valor de tipo `Double`, `Float` o `Int`.  
> Después realiza la conversión de la variable a los tres tipos hacia tres variables distintas.  
> Finalmente, compara el valor original convertido a `Double` y el resultado de la conversión del valor original a `Int` y vuelto a convertir a `Double`, para comprobar si se ha producido pérdida de información. Haz lo mismo para comprobar si se produce pérdida al pasar a `Float`.  
> Cambia el literal de inicialización de la variable de tipo `Number` para probar con diferentes posibilidades.

### Clases y métodos introducidos
- `Number`: superclase abstracta de todos los tipos numéricos primitivos en Kotlin (`Byte`, `Short`, `Int`, `Long`, `Float`, `Double`).
- `Number.toDouble()`: convierte cualquier subtipo numérico a `Double` (64 bits, coma flotante IEEE 754).
- `Number.toFloat()`: convierte a `Float` (32 bits, coma flotante).
- `Number.toInt()`: convierte a `Int` (32 bits enteros), **truncando** la parte decimal (descarta todo lo que va tras la coma).

#### Ejemplo simple de funcionamiento
```kotlin
val num: Number = 45.789
val entero: Int = num.toInt()          // Truncado: 45
val decimal: Double = num.toDouble()    // 45.789
val recuperado: Double = entero.toDouble() // 45.0

val hayPerdida: Boolean = (decimal != recuperado) // true (se perdieron los decimales)
println("¿Pérdida al truncar?: $hayPerdida")
```

### Código fuente ([`Ejercicio2.1/src/Main.kt`](Ejercicio2.1/src/Main.kt))

```kotlin
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

    val floatADouble: Double = valorFloat.toDouble()
    val perdidaFloat: Boolean = valorDouble != floatADouble
    println("Original -> $valorDouble  vs  Vuelta -> $floatADouble")
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
```

### Explicación paso a paso
1. **Polimorfismo numérico:** El parámetro `original: Number` acepta cualquier subtipo numérico sin sobrecargar la función.
2. **Conversión explícita obligatoria:** En Kotlin **no existe conversión implícita** entre tipos numéricos (no se puede asignar un `Int` a un `Double` directamente); se deben usar los métodos `.toDouble()`, `.toFloat()` o `.toInt()`.
3. **Comprobación de pérdida:** Al convertir de `Double` a `Int`, se eliminan los decimales. Al volver a `Double`, la comparación `!=` revela la pérdida. Al pasar de `Double` a `Float`, la mantisa se recorta de 53 bits a 24 bits, produciendo diferencias de precisión en números con muchos decimales.

---

## Ejercicio 2.2 · Números gigantes con BigInteger

> [!NOTE]
> **Enunciado:**
> Crea una variable que contenga un número entero muy grande (más de 25 dígitos) como un `String`.  
> Convierte ese `String` a `BigInteger` usando algún método disponible.  
> Súmale a este `BigInteger` el número 99, convertido previamente a `BigInteger` con algún método factoría disponible.  
> Imprime el resultado final de la suma.

### Clases y métodos introducidos
- `java.math.BigInteger`: clase para aritmética de enteros de precisión arbitraria (sin límite de 64 bits de `Long`).
- `String.toBigInteger()`: función de extensión propia de Kotlin para parsear cadenas numéricas a `BigInteger`.
- `BigInteger.valueOf(Long)`: método estático factoría para crear un `BigInteger` a partir de un entero estándar (`Long`).
- `operator fun plus (+)`: en Kotlin, la clase `BigInteger` sobrecarga el operador `+`, permitiendo escribir `a + b` en lugar del imperativo Java `a.add(b)`.

#### Ejemplo simple de funcionamiento
```kotlin
import java.math.BigInteger

val numCadena: String = "999999999999999999999999999999"
val big1: BigInteger = numCadena.toBigInteger()
val big2: BigInteger = BigInteger.valueOf(1L)
val suma: BigInteger = big1 + big2 // Sobrecarga de operador '+'

println("Suma exacta: $suma")
```

### Código fuente ([`Ejercicio2.2/src/Main.kt`](Ejercicio2.2/src/Main.kt))

```kotlin
import java.math.BigInteger

fun main() {
    val numeroGrande: String = "1000000000000000000001"
    val numeroGrandeANumero : BigInteger = numeroGrande.toBigInteger()
    val noventaYNueve : BigInteger = BigInteger.valueOf(99L)
    val resultado : BigInteger = numeroGrandeANumero + noventaYNueve

    println("Numero original: $numeroGrande")
    println("Numero a sumar: $noventaYNueve")
    println("Resultado final: $resultado")
}
```

### Explicación paso a paso
1. **Límite de tipos primitivos:** Un número de más de 25 dígitos supera el valor máximo de `Long` (`2^63 - 1` (≈ 9 × 10¹⁸)), por lo que provocaría desbordamiento inmediato de compilarse como primitivo.
2. **Conversión y factoría:** Se utiliza `.toBigInteger()` sobre la cadena de texto y `BigInteger.valueOf(99L)` para el incremento pequeño.
3. **Operador `+` sintáctico:** Gracias a la sobrecarga de operadores de Kotlin, `numeroGrandeANumero + noventaYNueve` es equivalente a la llamada Java `.add()`, manteniendo el código legible.

---

## Ejercicio 2.3 · Tipo Char, código Unicode y seguridad de tipos

> [!NOTE]
> **Enunciado:**
> Crea una variable llamada `initialLetter` de tipo `Char` y asígnale el carácter `'K'`.  
> Crea una variable `tab` de tipo `Char` y asígnale el carácter de tabulación.  
> Crea una variable `asciiCode` de tipo `Int`. Asígnale el valor Unicode de `initialLetter` usando la propiedad adecuada de `Char`.  
> Crea una variable `codeForSymbol` de tipo `Int` y asígnale el valor Unicode del carácter correspondiente al signo de dólar.  
> Intenta escribir una condición `if` para verificar si `initialLetter` es igual al número 75. Comenta esta línea de código inmediatamente después de escribirla, y explica en un comentario (con una sola frase) por qué genera un error de compilación.  
> Imprime `initialLetter`, `tab`, `asciiCode` y `codeForSymbol`.

### Clases y métodos introducidos
- `Char`: tipo de dato que representa un carácter UTF-16 de 16 bits.
- `Char.code`: propiedad que devuelve el punto de código numérico Unicode (`Int`) correspondiente al carácter.
- Caracteres de escape: `'\t'` (tabulación), `'\n'` (salto de línea), etc.

#### Ejemplo simple de funcionamiento
```kotlin
val letra: Char = 'A'
val puntoUnicode: Int = letra.code // 65
println("El código de '$letra' es $puntoUnicode")

// Error en Kotlin: los tipos no son comparables directamente
// if (letra == 65) { ... } -> Compile Error: Operator '==' cannot be applied to 'Char' and 'Int'
if (letra.code == 65) {
    println("Es la letra con código 65")
}
```

### Código fuente ([`Ejercicio2.3/src/Main.kt`](Ejercicio2.3/src/Main.kt))

```kotlin
fun main() {
    val initialLetter: Char = 'K'
    val tab: Char = '\t'
    val asciiCode: Int = initialLetter.code
    val codeForSymbol: Int = '$'.code

//    if (initialLetter == 75) {
//        println("son iguales")
//    } else {
//        println("no son iguales")
//    }
// Da error, ya que no se pueden comparar un tipo char con un tipo int

    if (initialLetter.code == 75) {
        println("son iguales")
    } else {
        println("no son iguales")
    }

    println(initialLetter)
    println(tab)
    println(asciiCode)
    println(codeForSymbol)
}
```

### Explicación paso a paso
1. **Diferencia con Java:** En Java, `char` es un tipo entero numérico encubierto y se puede hacer `if ('K' == 75)`. En Kotlin, **`Char` no es un número**: es un tipo diferenciado de primera clase.
2. **Propiedad `.code`:** Para obtener el valor numérico hay que consultar explícitamente `.code` (sustituye a la antigua función `.toInt()` de versiones viejas de Kotlin).
3. **Seguridad estática de tipos:** La comparación `initialLetter == 75` es rechazada por el compilador porque `==` exige compatibilidad de tipos entre ambos operandos.

---

## Ejercicio 2.4 · Rangos cerrados, abiertos, progresiones y operador in

> [!NOTE]
> **Enunciado:**
> Crea una variable llamada `closedRange` que contenga los números enteros desde 10 hasta 15, ambos inclusive, usando la sintaxis abreviada. Imprime este rango.  
> Crea una variable llamada `openRange` que contenga las letras desde `'A'` hasta `'D'`, excluyendo `'D'`, usando la sintaxis abreviada. Recorre e imprime cada carácter dentro de este rango usando un bucle `for`.  
> Crea una variable llamada `evenProgression` que contenga los números pares desde 20 hasta 10, en orden descendente, con un salto (paso) de 2. Recorre e imprime cada número de esta progresión.  
> Crea una variable `isInRange` que verifique si el número 12 está dentro de `closedRange`. Imprime el resultado de esta verificación (debería ser `true`).

### Clases y métodos introducidos
- `IntRange` / `CharRange`: tipos que representan secuencias acotadas de valores.
- Operador `..`: rango cerrado (incluye ambos extremos: `a..b` → `[a, b]`).
- Operador `..<`: rango semiabierto (excluye el extremo final: `a..<b` → `[a, b)`).
- Función infija `downTo`: progresión descendente desde un máximo hasta un mínimo.
- Función infija `step`: establece el incremento o decremento de la progresión.
- Operador `in` / `!in`: comprueba pertenencia de un elemento a un rango o colección de forma concisa.

#### Ejemplo simple de funcionamiento
```kotlin
val cerrado: IntRange = 1..5        // 1, 2, 3, 4, 5
val semiabierto: IntRange = 1..<5   // 1, 2, 3, 4
val regresivo = 10 downTo 0 step 2  // 10, 8, 6, 4, 2, 0

val estaDentro: Boolean = 3 in semiabierto // true
println("¿3 está en 1..<5?: $estaDentro")
```

### Código fuente ([`Ejercicio2.4/src/Main.kt`](Ejercicio2.4/src/Main.kt))

```kotlin
fun main() {
    val closedRange: IntRange = 10..15
    println(closedRange)

    val openRange: CharRange = 'A'..<'D'
    for (char in openRange) {
        print(char)
    }

    println()

    val evenProgression: IntProgression = 20 downTo 10 step 2
    for (numero in evenProgression) {
        print("$numero ")
    }

    println()

    val isInRange: Boolean = 12 in closedRange
    println(isInRange)
}
```

### Explicación paso a paso
1. **Rango cerrado con `..`:** `10..15` incluye el 10 y el 15.
2. **Rango semiabierto con `..<`:** `'A'..<'D'` genera únicamente `'A'`, `'B'` y `'C'`.
3. **Progresión con `downTo` y `step`:** Al recorrer hacia abajo, el operador `..` no funciona (produciría un rango vacío). Se utiliza la palabra clave `downTo` y se define el salto con `step 2`.
4. **Comprobación de rango con `in`:** `12 in closedRange` traduce internamente a `12 >= 10 && 12 <= 15`, pero con una sintaxis limpia y expresiva.

---

## Ejercicio 2.5 · Evaluación en cortocircuito frente a evaluación completa en booleanos

> [!NOTE]
> **Enunciado:**
> Define dentro de la función `main` tres variables booleanas: `isReady` inicializada a `true`, `isProcessing` inicializada a `false`, e `isExpensive` inicializada a `true`.  
> Ahora, crea una variable `shortCircuitResult` que use el operador `&&` para evaluar la expresión: `isProcessing && isExpensive`.  
> Después, crea una variable `fullEvalResult` que use el método `and` (con sintaxis infija) para evaluar exactamente la misma expresión: `isProcessing and isExpensive`.  
> Por último, crea una variable `isNotReady` que sea el resultado de negar (`!`) la variable `isReady`.  
> Finalmente, imprime los valores de `shortCircuitResult`, `fullEvalResult` e `isNotReady` para demostrar cómo operan los diferentes operadores lógicos.

### Clases y métodos introducidos
- `Boolean`: tipo booleano con valores `true` o `false`.
- Operador `&&` (cortocircuito): si el primer operando es `false`, el segundo **no se evalúa**.
- Función infija `Boolean.and(other)`: operación lógica AND **sin cortocircuito**; evalúa siempre obligatoriamente ambos operandos.
- Operador `!`: negación lógica unaria.

#### Ejemplo simple de funcionamiento
```kotlin
fun operacionCostosa(): Boolean {
    println("Ejecutando operación costosa...")
    return true
}

val condicion: Boolean = false
// Con && (cortocircuito): la función NUNCA llega a ejecutarse
val r1: Boolean = condicion && operacionCostosa()

// Con .and() / infijo and: la función SIEMPRE se ejecuta
val r2: Boolean = condicion and operacionCostosa()
```

### Código fuente ([`Ejercicio2.5/src/Main.kt`](Ejercicio2.5/src/Main.kt))

```kotlin
fun main() {
    val isReady: Boolean = true
    val isProcessing: Boolean = false
    val isExpensive: Boolean = true

    val shorCircuitResult: Boolean = isProcessing && isExpensive

    val fullEvalResult: Boolean = isProcessing.and(isExpensive)

    val isNotReady: Boolean = !isReady

    println(shorCircuitResult)
    println(fullEvalResult)
    println(isNotReady)
}
```

### Explicación paso a paso
1. **Cortocircuito (`&&` / `||`):** Es el operador habitual en programación. Si el resultado ya está determinado por el operando izquierdo, se detiene la ejecución del derecho (útil para evitar excepciones como `objeto != null && objeto.metodo()`).
2. **Evaluación completa (`and` / `or`):** Son funciones miembro de `Boolean` utilizables en notación infija (`a and b`). Garantizan que ambas expresiones se evalúan siempre, independientemente de que el lado izquierdo sea `false`.
3. **Negación (`!`):** Invierte el valor del booleano `isReady` de `true` a `false`.

---

## Ejercicio 2.6 · Procesamiento de cadenas, filtrado por código ASCII y cadenas multilínea

> [!NOTE]
> **Enunciado:**
> Realiza un programa que solicite por consola una cadena de caracteres y diga para cada carácter si está en mayúscula, si está en minúscula o no es una letra (la 'ñ' no cuenta como letra en este criterio básico), comprobando que el código numérico correspondiente al carácter esté en el rango numérico de los códigos de la `'A'` a la `'Z'`, o de la `'a'` a la `'z'`.  
> Realiza los siguientes pasos complementarios:
> - Define dos variables `String`: `firstName` inicializada a `"Alan"`, `lastName` a `"Turing"`, y una variable `yearOfBirth` de tipo `Int` con el valor `1912`.
> - Crea una variable `fullName` concatenando `firstName`, un espacio y `lastName`.
> - Accede al primer carácter de `fullName` usando indexación o método de primer elemento e imprime su valor.
> - Compara mediante operador de igualdad si `firstName` es igual a `"Alan"`.
> - Define una variable `biography` como una cadena multilínea que use `trimMargin()` con el prefijo `|` conteniendo los datos anteriores.

### Clases y métodos introducidos
- `CharSequence.first()`: método que devuelve el primer carácter (`Char`) de una cadena.
- `String.trimMargin(marginPrefix)`: elimina los espacios en blanco que sirven de sangría antes de un carácter delimitador (por defecto `|`).
- Literales de cadena sin formato / multilínea: encerrados entre triples comillas `""" ... """`, conservan saltos de línea sin necesidad de `\n`.

#### Ejemplo simple de funcionamiento
```kotlin
val nombre = "Kotlin"
val inicial: Char = nombre.first() // 'K'

val ficha: String = """
    |Lenguaje: $nombre
    |Inicial: $inicial
""".trimMargin()
println(ficha)
```

### Código fuente ([`Ejercicio2.6/src/Main.kt`](Ejercicio2.6/src/Main.kt))

```kotlin
fun main() {
    print("Introduce una cadena de caracteres: ")
    val cadena: String = readln()

    // Códigos ASCII: 'A'-'Z' (65..90), 'a'-'z' (97..122)
    val abecedarioMayus: IntRange = 65..90
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
```

### Explicación paso a paso
1. **Iteración sobre cadenas:** Un `String` en Kotlin se recorre directamente con `for (c in cadena)`.
2. **Filtrado por código numérico:** Mediante `c.code in abecedarioMayus` se clasifica el carácter según su posición en la tabla ASCII.
3. **Cadenas multilínea con `trimMargin`:** Permiten escribir textos largos o estructurados (como JSON, SQL o plantillas) manteniendo el código fuente bien indentado en el IDE sin que esos espacios se trasladen a la salida real por consola.

---

## Ejercicio 2.7 · Tipos nullables frente a no-nullables

> [!NOTE]
> **Enunciado:**
> Declara una variable `userName` de tipo `String?` y asígnale el valor `null` inicialmente.  
> Luego, declara otra variable inmutable, `defaultName`, de tipo `String` (no nullable) y asígnale el valor `"Guest"`.  
> A continuación, intenta asignar el valor de `userName` a una nueva variable inmutable, `finalName`, de tipo `String` y observa el error de compilación que se produce.  
> Finalmente, comenta la línea que causa el error y explica en un comentario de una sola línea, en español, por qué el compilador de Kotlin detiene esta asignación.

### Clases y métodos introducidos
- `Tipo?` (Tipo Nullable): indica que la variable puede almacenar una referencia válida o el valor especial `null`.
- `Tipo` (Tipo No Nullable): garantiza en tiempo de compilación que la variable **nunca puede contener `null`**, eliminando de raíz las excepciones `NullPointerException` en tiempo de ejecución.

#### Ejemplo simple de funcionamiento
```kotlin
var puedeSerNulo: String? = "Texto"
puedeSerNulo = null // Válido

var noPuedeSerNulo: String = "Texto"
// noPuedeSerNulo = null // Error de compilación inmediato: Null can not be a value of a non-null-typed String

// Tampoco se puede asignar directamente un nullable a un no-nullable:
// noPuedeSerNulo = puedeSerNulo // Error de compilación: Type mismatch
```

### Código fuente ([`Ejercicio2.7/src/Main.kt`](Ejercicio2.7/src/Main.kt))

```kotlin
fun main() {
    val userName: String? = null
    val defaultName: String = "Guest"
    
    // var finalName: String = userName
    // Este error se produce porque no se le puede asignar un nulo a un tipo no nullable.
}
```

### Explicación paso a paso
1. **Sistema de tipos nulos (Null Safety):** En la jerarquía de tipos de Kotlin, `String` es un subtipo estricto de `String?`. Todo `String` es un `String?`, pero no todo `String?` es un `String`.
2. **Error en tiempo de compilación:** El compilador detecta que `userName` tiene la potencialidad de contener `null`. Dado que `finalName` está declarada como `String` estricto (no nullable), la asignación directa es rechazada antes de que el programa pueda llegar a ejecutarse.

---

## Ejercicio 2.8 · Jerarquía de tipos: Any y Any?

> [!NOTE]
> **Enunciado:**
> Declara una variable inmutable `firstVariable` a la que asignas un literal numérico entero, y otra variable inmutable `secondVariable` a la que asignas la cadena de texto `"Hello World"`.  
> A continuación, declara una tercera variable inmutable, `thirdVariable`, de tipo explícito `Any`, y asígnale el valor de `firstVariable`.  
> Finalmente, declara una última variable, `fourthVariable`, de tipo explícito `Any?`, asígnale el valor `null`, y luego, en una línea posterior, intenta asignarle el valor de `secondVariable`.

### Clases y métodos introducidos
- `Any`: cúspide de la jerarquía de tipos no-nulos en Kotlin. Todos los tipos no-nulos (`Int`, `String`, `Boolean`, clases personalizadas) heredan directa o indirectamente de `Any` (análogo a `Object` en Java).
- `Any?`: cúspide absoluta de toda la jerarquía de Kotlin. Acepta cualquier valor de cualquier tipo, además del valor `null`.

#### Ejemplo simple de funcionamiento
```kotlin
val obj1: Any = 100         // Int es subtipo de Any
val obj2: Any = "Cadena"    // String es subtipo de Any
// val obj3: Any = null     // ERROR: Any no admite null

var universal: Any? = null  // Válido: Any? admite null
universal = obj2            // Válido: Any? también admite cualquier objeto no-nulo
```

### Código fuente ([`Ejercicio2.8/src/Main.kt`](Ejercicio2.8/src/Main.kt))

```kotlin
fun main() {
    var firstVariable: Int = 4
    var secondVariable: String = "Hello World"
    var thirdVariable: Any = firstVariable
    var fourthVariable: Any? = null
    fourthVariable = secondVariable
}
```

### Explicación paso a paso
1. **`Any` como supertipo raíz:** Al declarar `thirdVariable: Any = firstVariable`, se produce una conversión hacia arriba segura (*upcasting*). Dado que `Int` hereda de `Any`, la asignación es totalmente válida.
2. **`Any?` como supertipo universal con soporte de nulos:** `fourthVariable` puede empezar valiendo `null` y en cualquier momento posterior recibir una cadena (`String`), un número o cualquier otra instancia de la JVM, porque todos son compatibles con `Any?`.

---

## Esquema resumen de conceptos clave

| Concepto | Sintaxis / Clase | Comportamiento fundamental |
| --- | --- | --- |
| Superclase Numérica | `Number` | Base de `Int`, `Double`, `Float`, etc. Requiere conversión explícita (`toInt()`, etc.). |
| Precisión Arbitraria | `BigInteger` | Soporta enteros de tamaño infinito; permite operadores `+`, `-`, `*`. |
| Caracteres | `Char` | **No es un número**. Se consulta su valor Unicode con la propiedad `.code`. |
| Rangos | `..`, `..<`, `downTo`, `step` | Generan progresiones de valores; comprobación instantánea con `in`. |
| Evaluación Lógica | `&&` vs `and` | `&&` cortocircuita (detiene evaluación); `and` evalúa ambos lados. |
| Null Safety | `T` vs `T?` | `T` garantiza ausencia total de nulos; `T?` admite `null`. |
| Raíz de la Jerarquía | `Any` / `Any?` | `Any` para cualquier objeto no-nulo; `Any?` para absolutamente cualquier valor o `null`. |

## Relaciones

- Teoría del tema: 01 - Introduccion a Kotlin
- Índice de la asignatura: Índice de PMDM

---

## Ejercicio 2.9 · Media de un array de notas (DoubleArray)

> [!NOTE]
> **Enunciado:**
> Realiza un programa que solicite las notas de 4 exámenes, los almacene en un array, y después recorra el array y obtenga y muestre por pantalla la media aritmética de las notas.

### Clases y métodos introducidos
- `DoubleArray(n)`: constructor de array primitivo de `Double` de tamaño fijo `n`, inicializado a `0.0`.
- `array[i] = v` / `array[i]`: acceso por índice a elementos del array.
- `xs.size`: propiedad con la longitud del array.
- **Bucle indexado** `for (i in 0 ..< xs.size)` frente a **bucle de recorrido** `for (x in xs)`.

#### Ejemplo simple de funcionamiento
```kotlin
fun main() {
    val notas = DoubleArray(3)          // [0.0, 0.0, 0.0]
    notas[0] = 8.5
    notas[1] = 6.0
    notas[2] = 10.0

    for (i in 0 ..< notas.size) {       // indexado: necesito la posición
        println("nota[$i] = ${notas[i]}")
    }
    for (n in notas) {                  // recorrido: solo el valor
        print("$n ")
    }
}
```

### Código fuente ([`Ejercicio2.9/src/Main.kt`](Ejercicio2.9/src/Main.kt))

```kotlin
fun main() {
    val notas: DoubleArray = DoubleArray(4)

    for (i in 0 ..< notas.size) {
        print("Introduce la nota del examen ${i + 1}: ")
        notas[i] = readln().toDouble()
    }

    var suma: Double = 0.0
    for (nota in notas) {
        suma += nota
    }

    val media: Double = suma / notas.size
    println("La media de las notas es: $media")
}
```

### Explicación paso a paso
1. **Array de tamaño fijo con valores por defecto:** `DoubleArray(4)` reserva 4 huecos ya inicializados en `0.0`, así se puede escribir directamente `notas[i]` sin crear el array elemento a elemento.
2. **Por qué el primer bucle es indexado:** para pedir cada nota hace falta el índice (lectura y escritura), y se muestra `i + 1` porque el usuario cuenta los exámenes desde 1 mientras el array empieza en 0.
3. **`..<` (semiabierto):** recorre `0, 1, 2, 3` sin tocar la posición 4, evitando el error típico `ArrayIndexOutOfBoundsException` del clásico `i <= size`.
4. **El segundo bucle es de recorrido puro** (`for (nota in notas)`): solo interesa el valor para acumular en `suma`, que debe ser `var` porque se modifica en cada vuelta.
5. **Media:** `suma / notas.size` — división `Double / Int`; el `Int` se promueve a `Double` en la operación. Con las notas 5, 7, 6, 8 la salida real es `La media de las notas es: 6.5`.

> [!TIP]
> **Alternativa de librería**
> Todo el bloque de acumulación se resume en `notas.average()`, pero el ejercicio pide recorrer el array a mano para practicar los dos estilos de `for`.

---

## Ejercicio 2.10 · Variable Any? con contenido aleatorio y rangos

> [!NOTE]
> **Enunciado:**
> Crea un programa que declare una variable de tipo `Any?` que podrá contener un valor entero, una cadena de texto o `null`, dependiendo de un número aleatorio entre 0 y 100 generado con `Random.nextInt(lim_inf, lim_sup_no_incluido)` (comprobando que se importa `kotlin.random.Random`). Si el número está en `[0, 33]`, asigna `null`; en `[34, 66]`, el valor `5`; en `[67, 100]`, la cadena `"Baldomero"`. Muestra por pantalla el número generado y el tipo de contenido de la variable.

### Clases y métodos introducidos
- `kotlin.random.Random.nextInt(inicio, hasta)`: entero pseudoaleatorio en `[inicio, hasta)` — la frontera superior **no** se incluye.
- `var valor: Any?`: variable del supertipo universal nullable; puede cambiar de tipo de contenido en vuelo porque `Int`, `String` y `null` son subtipos de `Any?`.
- `valor in rangoInt`: operador `in` sobre `IntRange` (el `Any?` se desempaqueta a `Int` para la comparación).
- `asignación de reemplazo de contenido`: tras `valor = null` / `valor = 5` / `valor = "Baldomero"`, la variable contiene un tipo distinto del original.

#### Ejemplo simple de funcionamiento
```kotlin
import kotlin.random.Random

fun main() {
    // Random.nextInt(1, 10) nunca devuelve 10
    for (i in 1..5) {
        val n: Int = Random.nextInt(1, 10)
        println("$n en [1,10): ${n in 1..9}")
    }

    var caja: Any? = Random.nextInt(0, 100)  // empieza siendo Int
    caja = "ahora es String"                  // Any? admite cualquier reemplazo
    println(caja)
}
```

### Código fuente ([`Ejercicio2.10/src/Main.kt`](Ejercicio2.10/src/Main.kt))

```kotlin
import kotlin.random.Random

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
```

### Explicación paso a paso
1. **Una variable, tres tipos:** `Any?` es la cúspide de la jerarquía (02 - Jerarquia de tipos). Guardar primero un `Int` y luego reemplazarlo por `null`, otro `Int` o un `String` es legal porque todos son subtipos de `Any?`.
2. **El aleatorio manda:** `Random.nextInt(0, 100)` genera `0..99`; ese valor inicial determina qué rama se activa. Los tres `IntRange` hacen legible la partición del enunciado.
3. **`valor in rangoMedio` sobre `Any?`:** funciona porque en ese punto el contenido *real* sigue siendo un `Int` (el primer `if` no lo tocó); Kotlin desempaqueta (*unboxing*) para comparar. Si el contenido no fuera numérico, la comprobación `in` lanzaría excepción en tiempo de ejecución — aquí el flujo la protege.
4. **Encadenamiento de reemplazos:** si el sorteo cae en `0..33`, el primer bloque asigna `null`, y los dos `if` restantes ya no se activan porque `null in 34..66` es `false`. Los tres bloques son mutuamente excluyentes por construcción de los rangos.
5. **Salida real (típica):** p. ej. con 71 sorteado → `Salió 71` y `La variable es una cadena de texto: Baldomero`. Como solo se imprime un bloque por ejecución, hay que relanzar el programa para ver los tres casos (o sustituir los tres `if` por un `when (valor)`).

> [!WARNING]
> **Dos detalles del enunciado vs el código**
> - `nextInt(0, 100)` **nunca genera 100**, así que el `rangoAlto = 67..100` tiene un valor imposible; en la práctica cubre `67..99`.
> - En la rama nula, el programa imprime `la variable es nula` con minúscula (el enunciado pedía `"La variable es nula"`), y muestra el `null` interpolado (`la variable es nula: null`).

---

## Esquema resumen de conceptos clave

| Concepto | Sintaxis | Comportamiento fundamental |
| --- | --- | --- |
| Array primitivo con tamaño | `DoubleArray(4)` | Longitud fija, valores por defecto `0.0`; escritura por índice. |
| Bucle indexado | `for (i in 0 ..< xs.size)` | Acceso a posición; `..<` evita el fuera-de-límite. |
| Bucle de recorrido | `for (x in xs)` | Solo valores, más simple cuando no interesa el índice. |
| Aleatoriedad | `Random.nextInt(a, b)` | Entero en `[a, b)`; requiere `import kotlin.random.Random`. |
| Caja universal | `var v: Any?` | Admite cualquier tipo y `null`; se puede reemplazar el contenido por otro tipo. |
| Pertenencia | `v in 34..66` | `in` delega en el rango; con `Any?` desempaca si el contenido real es numérico. |

## Relaciones

- Teoría del tema: 02 - Jerarquia de tipos — `Any?`, `IntRange`, arrays primitivos
- Bloque anterior de ejercicios: 01.1 - Ejercicios 1 Introduccion a Kotlin (2.1–2.8)
- Índice de la asignatura: Índice de PMDM

## Para repasar

- [ ] Crear un `IntArray` de 5 huecos vacíos y recorrerlo escribiendo por índice
- [ ] Diferenciar `for (i in 0 ..< v.size)` de `for (e in v)` y decir cuál usar en cada caso
- [ ] Explicar por qué `Random.nextInt(0, 100)` no puede devolver 100
- [ ] Justificar por qué `var caja: Any?` puede pasar de `Int` a `String` sin error
- [ ] Predecir qué imprimen los tres `if` encadenados cuando el sorteo sale 20

---

## Esquema resumen de conceptos clave

| Concepto | Sintaxis / Clase | Comportamiento fundamental |
| --- | --- | --- |
| Superclase Numérica | `Number` | Base de `Int`, `Double`, `Float`, etc. Requiere conversión explícita (`toInt()`, etc.). |
| Precisión Arbitraria | `BigInteger` | Soporta enteros de tamaño infinito; permite operadores `+`, `-`, `*`. |
| Caracteres | `Char` | **No es un número**. Se consulta su valor Unicode con la propiedad `.code`. |
| Rangos | `..`, `..<`, `downTo`, `step` | Generan progresiones de valores; comprobación instantánea con `in`. |
| Evaluación Lógica | `&&` vs `and` | `&&` cortocircuita (detiene evaluación); `and` evalúa ambos lados. |
| Null Safety | `T` vs `T?` | `T` garantiza ausencia total de nulos; `T?` admite `null`. |
| Raíz de la Jerarquía | `Any` / `Any?` | `Any` para cualquier objeto no-nulo; `Any?` para absolutamente cualquier valor o `null`. |
| Arrays primitivos | `DoubleArray(n)` | Longitud fija, valores por defecto; acceso por índice y recorrido con `for`. |
| Aleatoriedad | `Random.nextInt(a, b)` | Entero en `[a, b)`; requiere `import kotlin.random.Random`. |

---

> [!NOTE]
> **Documentación añadida:** las entradas 2.11–2.22 se derivan directamente del código fuente (no del boletín original). El `Objetivo` resume el comentario de cabecera de cada `Main.kt`.

## Ejercicio 2.11 · Boxing: Array<Int> frente a IntArray

> [!NOTE]
> **Objetivo:** comparar el boxing automático de Kotlin (`Array<Int>`, genéricos, tipos nullables) con los arrays de primitivos sin boxing (`IntArray`).

### Clases y métodos introducidos
- `arrayOf()`: crea un `Array<Int>` en el que cada celda guarda un objeto `Integer` de la JVM (boxed).
- `intArrayOf()`: crea un `IntArray` que guarda enteros primitivos (sin boxing).
- `List<Int>` / `List<Int?>`: los genéricos y los nulos fuerzan referencias boxed.

### Código fuente ([`Ejercicio2.11/src/Main.kt`](Ejercicio2.11/src/Main.kt))

```kotlin
// Compara el boxing automático de Kotlin (Array<Int>, genéricos y tipos
// nullables) frente a los arrays de primitivos sin boxing (IntArray).

fun main() {
    // Array<Int>: cada celda guarda un objeto Integer de la JVM (boxed)
    val boxed: Array<Int> = arrayOf(1, 2, 3)
    // IntArray: guarda enteros primitivos de la JVM (sin boxing)
    val primitivo: IntArray = intArrayOf(1, 2, 3)

    for (n in boxed) print("$n ")
    println()
    for (n in primitivo) print("$n ")
    println()

    // Genérico: obliga a usar el tipo boxed, no el primitivo
    val lista: List<Int> = listOf(1, 2, 3)
    // Nullable: null solo cabe en una referencia -> boxed
    val listaConNulos: List<Int?> = listOf(1, null, 3)

    println("Lista boxed: $lista")
    println("Lista nullable: $listaConNulos")
}
```

### Explicación paso a paso
1. **`Array<Int>` vs `IntArray`:** a nivel de bytecode el primero es un array de referencias a `Integer`; el segundo, un array de enteros primitivos. El resultado impreso es idéntico, pero la huella en memoria difiere.
2. **Genéricos y nulos obligan a boxed:** no existe `List<int>` ni un primitivo que admita `null`; por eso `List<Int>` y `List<Int?>` almacenan referencias.
3. **Uso recomendado:** para rendimiento numérico masivo, preferir los arrays especializados (`IntArray`, `DoubleArray`, etc.).

---

## Ejercicio 2.12 · Precisión decimal: Double frente a BigDecimal

> [!NOTE]
> **Objetivo:** comprobar la pérdida de precisión de `Double` en operaciones decimales y compararla con la aritmética exacta de `BigDecimal`.

### Clases y métodos introducidos
- `Double`: representación binaria en coma flotante; introduce error de redondeo.
- `BigDecimal`: precisión decimal arbitraria; construido desde `String` conserva el valor exacto.
- `String.toBigDecimal()` / `Int.toBigDecimal()`: conversiones a `BigDecimal`.

### Código fuente ([`Ejercicio2.12/src/Main.kt`](Ejercicio2.12/src/Main.kt))

```kotlin
// Comprueba la pérdida de precisión de Double en operaciones decimales
// y compárala con la aritmética exacta de BigDecimal.

import java.math.BigDecimal

fun main() {
    // Double: representación binaria -> error de redondeo
    val sumaDouble: Double = 0.1 + 0.2
    println("Double 0.1 + 0.2 = $sumaDouble")

    // BigDecimal: construido desde String conserva la precisión decimal
    val a: BigDecimal = "0.1".toBigDecimal()
    val b: BigDecimal = BigDecimal("0.2")
    val sumaExacta: BigDecimal = a + b
    println("BigDecimal 0.1 + 0.2 = $sumaExacta")

    // Conversión directa desde un tipo básico
    val desdeInt: BigDecimal = 5.toBigDecimal()
    println("5 convertido a BigDecimal = $desdeInt")
}
```

### Explicación paso a paso
1. **`0.1 + 0.2` en `Double`:** da `0.30000000000000004` porque 0.1 y 0.2 no son representables de forma exacta en binario.
2. **`BigDecimal` desde `String`:** evita arrastrar el error del `Double`; se obtiene `0.3` exacto.
3. **Regla práctica:** usar `BigDecimal` en dinero o cualquier cálculo donde la precisión decimal sea contractual.

---

## Ejercicio 2.13 · Plantillas de cadena avanzadas y StringBuilder

> [!NOTE]
> **Objetivo:** practicar plantillas de cadena avanzadas (`$var`, `${expresion}`, prefijo `$$` de Kotlin 2.2+) y construir cadenas eficientemente con `StringBuilder`.

### Clases y métodos introducidos
- `$var` / `${expresion}`: interpolación simple y con expresión.
- `\$`: dólar literal en cadenas normales.
- `$$"""..."""` (Kotlin 2.2.0+): en modo plantilla, `$` es literal y se interpola con `$$`.
- `StringBuilder.append()`: concatenación eficiente en bucle.

### Código fuente ([`Ejercicio2.13/src/Main.kt`](Ejercicio2.13/src/Main.kt))

```kotlin
// Plantillas de cadena avanzadas ($var, ${expresion}, $$ de Kotlin 2.2+)
// y construcción eficiente de cadenas en bucle con StringBuilder.

fun main() {
    val precio: Double = 29.99
    val rebaja: Double = 9.99

    // Interpolación simple y con expresión
    println("Precio: $precio")
    println("Ahorro: ${precio - rebaja}")

    // Dólar escapado en cadena normal
    println("Precio con \$: \$$precio")

    // Plantilla multilínea con prefijo $$ (Kotlin 2.2.0+):
    // en este modo, $ es literal y se interpola con $$
    val descripcion: String = $$"""
        |Rebajas: $$$rebaja
        |Habitual: $$$precio
        |Ahorro: $$${precio - rebaja}
        """.trimMargin()
    println(descripcion)

    // StringBuilder: más eficiente que concatenar con + dentro de un bucle
    val sb = StringBuilder()
    for (i in 1..5) {
        sb.append("V(${i * i}) ")
    }
    println(sb.toString().trim())
}
```

### Explicación paso a paso
1. **`$var` y `${expr}`:** interpolar una variable o cualquier expresión; la forma con llaves es necesaria cuando hay más texto pegado.
2. **Escapes del dólar:** en cadenas normales se usa `\$`; en el modo `$$"""` el `$` ya es literal y la interpolación requiere `$$`.
3. **`StringBuilder`:** concatenar con `+` dentro de un bucle crea una cadena nueva por vuelta; `append` reutiliza el mismo búfer.

---

## Ejercicio 2.14 · Tipo frente a clase: herencia, interfaces y Liskov

> [!NOTE]
> **Objetivo:** distinguir «tipo» de «clase» mediante herencia, interfaces y subtipos, aplicando el principio de sustitución de Liskov (la L de SOLID).

### Clases y métodos introducidos
- `open class` / `:`: herencia simple.
- `interface` + `override fun`: subtipo por contrato, sin herencia de implementación.
- Principio de Liskov: una función que acepta un supertipo admite cualquier subtipo.

### Código fuente ([`Ejercicio2.14/src/Main.kt`](Ejercicio2.14/src/Main.kt))

```kotlin
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
```

### Explicación paso a paso
1. **Clase vs tipo:** una clase define al menos dos tipos (la propia y su versión nullable); implementar una interfaz añade otro tipo.
2. **Liskov:** `describir(animal: Animal)` funciona con `Perro` y `Gato` porque ambos son subtipos de `Animal`.
3. **Asignación a `String?`:** `String` es subtipo de `String?`, por eso `texto` cabe en `nullable` sin conversión.

---

## Ejercicio 2.15 · Comprobación de tipo: is, !is y smart cast

> [!NOTE]
> **Objetivo:** usar `is` / `!is` y el smart cast (acceso directo a los miembros del tipo comprobado) dentro de `if` y `when`.

### Clases y métodos introducidos
- `is` / `!is`: comprobación de tipo en tiempo de ejecución.
- Smart cast: tras la comprobación, Kotlin trata la variable como el tipo comprobado sin cast explícito.
- `when` como expresión de tipo.

### Código fuente ([`Ejercicio2.15/src/Main.kt`](Ejercicio2.15/src/Main.kt))

```kotlin
// Comprobación de tipo con is / !is y smart cast (acceso directo a los
// miembros del tipo comprobado) dentro de if y when.

fun describir(obj: Any): String = when (obj) {
    is String -> "String de longitud ${obj.length}"   // smart cast
    is Int -> "Int incrementado: ${obj + 1}"
    is Boolean -> "Boolean: $obj"
    else -> "Tipo desconocido"
}

fun main() {
    val obj: Any = "Hola"

    if (obj is String) {
        println(obj.uppercase())       // sin cast explícito
    }

    if (obj !is Int) {
        println("obj no es un Int")
    }

    println(describir(42))
    println(describir(true))
    println(describir(3.14))
}
```

### Explicación paso a paso
1. **`is` dentro de `if`:** habilita el smart cast, así `obj.length` compila sin `as String`.
2. **`!is`:** niega la comprobación; útil para descartar tipos.
3. **Smart cast en `when`:** cada rama conoce el tipo y accede a sus miembros.

---

## Ejercicio 2.16 · Creación, copia y conversión de arrays

> [!NOTE]
> **Objetivo:** crear, copiar y convertir arrays con `arrayOf`, `Array(n){lambda}`, `arrayOfNulls`, `copyOf` (con y sin lambda) y `toIntArray`.

### Clases y métodos introducidos
- `arrayOf()`: array con los valores indicados.
- `Array(tamaño) { indice -> valor }`: inicialización por lambda.
- `arrayOfNulls<T>(n)`: array de tipo nullable relleno de `null`.
- `copyOf(n)` y `copyOf(n) { indice -> valor }` (Kotlin 2.2+).
- `toIntArray()`: conversión de `Array<Int>` boxed a `IntArray` primitivo.

### Código fuente ([`Ejercicio2.16/src/Main.kt`](Ejercicio2.16/src/Main.kt))

```kotlin
// Creación, copia y conversión de arrays:
// arrayOf, Array(n){lambda}, arrayOfNulls, copyOf (con y sin lambda) y toIntArray.

fun main() {
    // arrayOf(): array con los valores indicados
    val base: Array<String> = arrayOf("foo", "bar", "baz")

    // Array(tamaño) { índice -> valor }: inicialización por lambda
    val cuadrados: Array<Int> = Array(5) { i -> i * i }

    // arrayOfNulls(): array de un tipo nullable relleno de null
    val huecos: Array<Int?> = arrayOfNulls<Int?>(3)

    // copyOf(n): recorta (n menor) o rellena con null (n mayor)
    val truncado: Array<String> = base.copyOf(2)

    // copyOf(n) { indice -> valor }: rellena con lambda (Kotlin 2.2+)
    val ampliado: Array<String> = base.copyOf(5) { i -> "item $i" }

    // toIntArray(): conversión de Array<Int> (boxed) a IntArray (primitivo)
    val primitivo: IntArray = cuadrados.toIntArray()

    println(base.contentToString())
    println(cuadrados.contentToString())
    println(huecos.contentToString())
    println(truncado.contentToString())
    println(ampliado.contentToString())
    println(primitivo.contentToString())
}
```

### Explicación paso a paso
1. **`Array(n){}`:** genera cada celda con la lambda, sin bucles manuales.
2. **`copyOf(n)`:** si `n` es menor recorta; si es mayor rellena con `null` (aunque el tipo declarado no sea nullable, ver ejercicio 2.22).
3. **`toIntArray()`:** elimina el boxing cambiando a la variante primitiva.

---

## Ejercicio 2.17 · Rangos de coma flotante: .. y ..

> [!NOTE]
> **Objetivo:** usar rangos de coma flotante `ClosedFloatingPointRange` con `..` (cerrado) y `..<` (abierto por la derecha), y comprobar pertenencia con `in` / `!in`.

### Clases y métodos introducidos
- `..` sobre `Double`: produce un `ClosedFloatingPointRange<Double>` (ambos extremos incluidos).
- `..<` (Kotlin 1.9+): rango abierto por la derecha (`OpenEndRange`).
- `in` / `!in`: comprobación de pertenencia.

### Código fuente ([`Ejercicio2.17/src/Main.kt`](Ejercicio2.17/src/Main.kt))

```kotlin
// Rangos de coma flotante: ClosedFloatingPointRange con .. (cerrado) y
// ..< (abierto en el extremo derecho), y pertenencia con in / !in.

fun main() {
    val temperatura: Double = 22.5
    val rangoCalor: ClosedFloatingPointRange<Double> = 20.0..30.0
    val rangoAgua: OpenEndRange<Double> = 0.0..<100.0

    println("22.5 in 20.0..30.0   -> ${temperatura in rangoCalor}")
    println("30.0 in 20.0..30.0   -> ${30.0 in rangoCalor}")
    println("100.0 in 0.0..<100.0 -> ${100.0 in rangoAgua}")
    println("22.5 !in 20.0..30.0  -> ${temperatura !in rangoCalor}")

    // Los tipos de coma flotante no tienen clase de rango dedicada: se
    // recorren con una lista de valores, no con un step de progresión.
    val valores: List<Double> = listOf(0.0, 0.5, 1.0, 1.5)
    for (v in valores) {
        println("$v en [0.0, 1.0] -> ${v in 0.0..1.0}")
    }
}
```

### Explicación paso a paso
1. **`..` vs `..<`:** `20.0..30.0` incluye el 30.0; `0.0..<100.0` excluye el 100.0.
2. **Pertenencia:** `in` resuelve la comprobación sin comparar manualmente extremos.
3. **Sin progresión:** los rangos de coma flotante no son iterables con `step`; para recorrerlos se usa una colección de valores.

---

## Ejercicio 2.18 · Booleanos: cortocircuito y métodos infix and/or

> [!NOTE]
> **Objetivo:** comprobar por qué mezclar `Int` y `Boolean` es error de compilación, usar el cortocircuito de `&&` / `||` y los métodos infix `and` / `or` (sin cortocircuito).

### Clases y métodos introducidos
- `&&` / `||`: operadores con cortocircuito (no evalúan el lado derecho si no hace falta).
- `and` / `or`: funciones infix que evalúan siempre ambos operandos.
- Ausencia de conversión implícita de `Int` a `Boolean`.

### Código fuente ([`Ejercicio2.18/src/Main.kt`](Ejercicio2.18/src/Main.kt))

```kotlin
// Booleanos: por que mezclar Int y Boolean es error de compilacion,
// cortocircuito con && y ||, y metodos infix and/or sin cortocircuito.

fun main() {
    val condition: Int = 1
    // if (condition) { println("condition es true") }
    // ERROR DE COMPILACION: type mismatch - Int no puede convertirse a Boolean

    // Equivalente explicito y correcto:
    if (condition != 0) {
        println("condition no es cero")
    }

    // El cortocircuito protege el acceso a una referencia nula:
    val texto: String? = null
    val longitud: Int = if (texto != null && texto.length > 3) texto.length else 0
    println("longitud = $longitud")

    // || corta cuando el lado izquierdo ya es true:
    val claveOk: Boolean = false
    val esAdmin: Boolean = true
    if (esAdmin || pedirClave()) {
        println("acceso permitido")
    }

    // and / or son funciones infix: evaluan SIEMPRE los dos operandos
    val resultado: Boolean = claveOk and pedirClave()
    println("resultado = $resultado")
}

fun pedirClave(): Boolean {
    println("  (pidiendo clave...)")
    return false
}
```

### Explicación paso a paso
1. **`Int` no es `Boolean`:** Kotlin no convierte tipos numéricos a lógicos; la comprobación explícita es `condition != 0`.
2. **Cortocircuito:** `texto != null && texto.length > 3` solo accede a `.length` si `texto` no es nulo; `esAdmin || pedirClave()` evita llamar al método.
3. **`and` / `or` infix:** reciben el segundo operando ya evaluado, por eso `pedirClave()` se ejecuta siempre.

---

## Ejercicio 2.19 · Restricciones del compilador sobre tipos nullables

> [!NOTE]
> **Objetivo:** revisar las tres restricciones que el compilador aplica a un tipo nullable: no acceder a sus miembros, no asignarlo a un tipo no-nullable y no pasarlo donde se espera un no-nullable.

### Clases y métodos introducidos
- Acceso no seguro: prohibido sobre `String?`.
- `!!`: aserción de no-nulo (puede lanzar `NullPointerException`).
- `?.` (safe call) + `?:` (Elvis): alternativas seguras.

### Código fuente ([`Ejercicio2.19/src/Main.kt`](Ejercicio2.19/src/Main.kt))

```kotlin
// Las tres restricciones que el compilador aplica a un tipo nullable:
// 1) no permite acceder a sus miembros directamente
// 2) no permite asignarlo a un tipo no-nullable
// 3) no permite pasarlo a una funcion que espere un tipo no-nullable

fun longitudSegura(s: String): Int = s.length

fun main() {
    val nombre: String = "Ana"
    var apodo: String? = "Ani"

    println(nombre.length)

    // println(apodo.length)            // ERROR: acceso no seguro sobre nullable
    // val copia: String = apodo        // ERROR: tipos incompatibles
    // println(longitudSegura(apodo))   // ERROR: String? no vale donde se espera String

    // Formas de resolver las tres restricciones:
    println(longitudSegura(apodo!!))          // asercion no-nula
    println(apodo?.length ?: 0)               // safe call + Elvis
    println(longitudSegura(apodo ?: "Guest")) // Elvis como valor por defecto

    apodo = null
    println(apodo?.length ?: "es null")       // sin asercion: no lanza
}
```

### Explicación paso a paso
1. **Tres restricciones:** las tres líneas comentadas son errores de compilación; el compilador no permite «olvidar» el nulo.
2. **`!!`:** concentra el riesgo en un solo punto, con posible `NullPointerException`.
3. **`?.` + `?:`:** evita la excepción devolviendo un valor alternativo; preferible salvo que el no-nulo esté garantizado.

---

## Ejercicio 2.20 · Concatenación con + y comparación de cadenas

> [!NOTE]
> **Objetivo:** comprobar que la concatenación con `+` solo funciona con otros tipos cuando el primer operando es `String`, y comparar cadenas por contenido con `==`.

### Clases y métodos introducidos
- `String.plus(otro)`: sobrecarga que acepta `Any?` cuando el receptor es `String`.
- `Int.plus(String)`: no existe; `1 + "abc"` no compila.
- `==`: comparación estructural (contenido), no de referencia.

### Código fuente ([`Ejercicio2.20/src/Main.kt`](Ejercicio2.20/src/Main.kt))

```kotlin
// Concatenacion con '+': solo funciona con otros tipos si el PRIMER
// operando es String (Int.plus no acepta un String).

fun main() {
    val s1: String = "abc" + 1        // OK -> "abc1"
    val s2: String = "abc".plus(1)    // equivalente al anterior
    val s3: String = "abc" + true     // OK -> "abctrue"

    // val s4: String = 1 + "abc"     // ERROR DE COMPILACION: Int.plus no recibe String

    // Soluciones equivalentes para el caso invalido:
    val s5: String = "1" + "abc"      // "1abc"
    val s6: String = "abc${1}"        // plantilla -> "abc1"
    val s7: String = 1.toString() + "abc"   // "1abc"

    println(s1)
    println(s2)
    println(s3)
    println("$s5 / $s6 / $s7")

    // Suma numerica dentro de la expresion interpolada:
    val total: Int = 2 + 3
    println("total = ${total + 1}")   // total = 6

    // Comparacion segura de cadenas con '==' (compara contenido, no referencia)
    val a: String = "Baldomero"
    val b: String = "Baldomero"
    println(a == b)                    // true
}
```

### Explicación paso a paso
1. **Orden importa:** `"abc" + 1` usa `String.plus(Any?)`; `1 + "abc"` intenta `Int.plus(String)` y no existe.
2. **Alternativas:** convertir a `String` el número o usar plantilla `${1}`.
3. **`==` vs `===`:** `==` compara contenido (estructura); `===` compararía referencias.

---

## Ejercicio 2.21 · Literales numéricos: sufijos, separadores e inferencia

> [!NOTE]
> **Objetivo:** revisar literales numéricos (sufijos `L` / `f`, separador `_`, inferencia de `Int` frente a `Long`) y la ausencia de notación octal.

### Clases y métodos introducidos
- Sufijos `L` (`Long`) y `f` (`Float`).
- Separador de cifras `_`.
- Inferencia: un entero que no cabe en `Int` se infiere como `Long`.
- Conversiones explícitas `toDouble()` / `toByte()`.

### Código fuente ([`Ejercicio2.21/src/Main.kt`](Ejercicio2.21/src/Main.kt))

```kotlin
// Literales numericos: sufijos L / f, separador de cifras _, inferencia
// de Int frente a Long, y ausencia de notacion octal.

fun main() {
    val entero: Int = 1_000_000                  // 1000000
    val largo: Long = 1_000_000_000_000L          // sufijo L
    val inferido = 12345678912345                 // no cabe en Int -> se infiere Long
    val flotante: Float = 123.5f                  // sufijo f
    val doble: Double = 123.5                     // real sin sufijo -> Double
    val corto: Short = 345                        // sin sufijo: el literal toma el tipo declarado
    val pequeno: Byte = 100

    println("$entero · $largo · $inferido · $flotante · $doble · $corto · $pequeno")
    println("tipo inferido de 'inferido': ${inferido::class.simpleName}")

    // val octal: Int = 0777                      // ERROR: Kotlin no admite octal

    val hex: Int = 0xFF                           // 255
    val bin: Int = 0b1011                         // 11
    println("$hex · $bin")

    // Conversion explicita obligatoria: no hay conversion implicita
    val comoDouble: Double = entero.toDouble()
    val comoByte: Byte = corto.toByte()            // perdio precision: 345 -> 89
    println("$comoDouble · $comoByte")
}
```

### Explicación paso a paso
1. **Sufijos:** `L` fuerza `Long`, `f` fuerza `Float`; sin sufijo un real es `Double`.
2. **Inferencia:** `12345678912345` no cabe en `Int`, así que Kotlin elige `Long`.
3. **Sin octal:** no existe `0777`; se usan `0x` (hex) y `0b` (binario). Las conversiones numéricas son siempre explícitas y pueden perder precisión (`345.toByte()` → `89`).

---

## Ejercicio 2.22 · copyOf/copyOfNullable y huecos null

> [!NOTE]
> **Objetivo:** comprobar cómo `copyOf` recorta o amplía arrays, la diferencia con `copyOfNullable`, y por qué los huecos de ampliación valen `null` aunque el tipo no sea nullable.

### Clases y métodos introducidos
- `copyOf(n)`: recorta o amplía; los huecos nuevos son `null` a nivel de valor pese al tipo no-nullable.
- `copyOfNullable(n)`: variante cuyo tipo de retorno es nullable (`Array<T?>`).
- `contentToString()`: representación legible del array.

### Código fuente ([`Ejercicio2.22/src/Main.kt`](Ejercicio2.22/src/Main.kt))

```kotlin
// Arrays: copyOf recortando y ampliando, copyOfNullable, y por que los
// huecos de ampliacion acaban valiendo null aunque el tipo no lo sea.

fun main() {
    val original: Array<String> = arrayOf("foo", "bar", "baz")

    // Ampliar con copyOf: rellena los huecos, pero el tipo sigue siendo String
    val floja: Array<String> = original.copyOf(5)
    println(floja.contentToString())
    println("¿hueco 4 es null pese a String? ${floja[4] == null}")

    // copyOfNullable: el tipo de retorno es nullable (Array<String?>)
    val segura: Array<String?> = original.copyOfNullable(5)
    println(segura.contentToString())
    println("¿hueco 4 es null? ${segura[4] == null}")

    // Recortar
    val menor: Array<String> = original.copyOf(2)
    println(menor.contentToString())

    // Un array no cambia de tamaño: original conserva sus 3 posiciones
    println("size original = ${original.size}")
}
```

### Explicación paso a paso
1. **`copyOf(5)`:** amplía a 5 posiciones; las dos nuevas quedan a `null` aunque el tipo declarado sea `Array<String>` (brecha de seguridad de tipos de los arrays de la JVM).
2. **`copyOfNullable(5)`:** hace explícito que el resultado puede contener nulos (`Array<String?>`).
3. **Inmutabilidad de tamaño:** `copyOf` devuelve un array nuevo; el original mantiene su tamaño.


