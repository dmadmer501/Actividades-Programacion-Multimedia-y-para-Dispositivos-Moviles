# Actividades · Programación Multimedia y para Dispositivos Móviles

Repositorio de ejercicios de la asignatura **Programación Multimedia y para Dispositivos Móviles**, resueltos en **Kotlin** con IntelliJ IDEA.

Cada tema vive en su propia carpeta e incluye un `README.md` con el índice, los enunciados, el código fuente y la explicación paso a paso de cada ejercicio.

---

## Temas

| Tema | Carpeta | Ejercicios | Documentación |
| --- | --- | --- | --- |
| Tema 1 · Introducción a Kotlin | [`Tema1-Kotlin/`](Tema1-Kotlin/) | 1.1 | [README](Tema1-Kotlin/README.md) |
| Tema 2 · Jerarquía de Tipos | [`Tema2-Jerarquia-de-Tipos/`](Tema2-Jerarquia-de-Tipos/) | 2.1 – 2.22 | [README](Tema2-Jerarquia-de-Tipos/README.md) |
| Tema 3 · Funciones en Kotlin | [`Tema3-Funciones/`](Tema3-Funciones/) | 3.1 – 3.11 | [README](Tema3-Funciones/README.md) |

---

## Estructura

```
.
├── README.md                        # este índice general
├── Tema1-Kotlin/
│   ├── README.md                    # teoría + ejercicios 1.1
│   └── Ejercicio1.1/                # proyecto Kotlin (src/Main.kt)
├── Tema2-Jerarquia-de-Tipos/
│   ├── README.md                    # teoría + ejercicios 2.1–2.22
│   ├── Ejercicio2.1/
│   └── ...
└── Tema3-Funciones/
    ├── README.md                    # teoría + ejercicios 3.1–3.11
    ├── Ejercicio3.1/
    └── ...
```

Cada carpeta `EjercicioX.Y/` es un proyecto Kotlin independiente con su `src/Main.kt`, su `.iml` y, cuando aplica, su carpeta `.idea/`.

---

## Cómo ejecutar un ejercicio

1. Abrir la carpeta `EjercicioX.Y/` como proyecto en IntelliJ IDEA.
2. Ejecutar `src/Main.kt` (botón ▶ junto a `fun main()`).

Desde terminal, con el compilador de Kotlin instalado:

```bash
kotlinc Tema2-Jerarquia-de-Tipos/Ejercicio2.1/src/Main.kt -include-runtime -d /tmp/ej.jar
java -jar /tmp/ej.jar
```

---

## Notas

- Los `README.md` de cada tema conservan su sección **Origen** con el tema y los apuntes relacionados.
- Las entradas **2.11 – 2.22** se documentaron a partir del código fuente (no del boletín original), por lo que su apartado se rotula como **Objetivo** en lugar de **Enunciado**.
- Los apuntes de teoría están en `Documentos/Notas/Programacion_multimedia_y_dispositivos_moviles_notas/` (fuera de este repositorio).
