# Acceso a Datos · Tema 1 · Boletín 3 · Parsers

Ejercicios del Boletín 3 del Tema 1 (Acceso a ficheros) de 2º DAM. Lectura de ficheros XML con **DOM** y de ficheros JSON con **org.json**.

## Requisitos

- Java 17 o superior
- Gradle (incluido con `gradlew`)
- Librería `org.json:json:20250517` (ya declarada en `build.gradle.kts`)

## Estructura

```
Recursos/                          Datasets del boletín
src/main/java/com/luciuss4/tema01/
├── Ejercicio1.java ... Ejercicio8.java
├── Empleado.java                  Clase del ejercicio 2
├── Alumno.java, Nota.java         Clases del ejercicio 6
└── Pelicula.java                  Clase del ejercicio 8
```

## Ejercicios

### Bloque DOM XML

| Ejercicio | Dataset | Descripción |
|---|---|---|
| 1 | `empleados.xml` | Listado del id, nombre y salario de cada empleado |
| 2 | `empleados.xml` | Mapeo a objetos `Empleado` y salario medio por departamento |
| 3 | `biblioteca.xml` | Títulos de los libros y número de libros por género |
| 4 | `pedidos.xml` | Items del pedido indicado por el usuario y comprobación del total |

### Bloque JSON

| Ejercicio | Dataset | Descripción |
|---|---|---|
| 5 | `alumnos.json` | Nombre y fecha de nacimiento de los alumnos |
| 6 | `alumnos.json` | Mapeo a objetos `Alumno` y `Nota`, nota más alta y mejor media |
| 7 | `inventario.json` | Ubicación del producto indicado por el usuario |
| 8 | `peliculas.json` | Películas ordenadas por puntuación media y géneros distintos |

## Ejecución

Abrir el proyecto en IntelliJ IDEA y ejecutar la clase del ejercicio. Los datasets se leen desde la carpeta `Recursos`, en la raíz del proyecto.
