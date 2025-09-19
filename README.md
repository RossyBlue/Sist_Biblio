# Library Management System (Java)

A **Library Management System** built in Java.  
This project was created to practice **Object-Oriented Programming (OOP)**, modular design, and event-driven logic for managing books, users, and loans in a library.

---

## Features

- **Book Management**: add, list, and update books.
- **User Management**: register students, teachers, and library staff.
- **Loan Process**: create and manage book loans.
- **Return Process**: handle book returns and availability.
- **Basic Validations**: ensure users and books exist, check availability.
- Organized design with separate classes:
  - `Biblioteca.java`
  - `Usuario.java` (and subclasses like `Estudiante`, `Docente`)
  - `Libro.java`
  - `Prestamo.java`
  - `Main.java`

---

## Project Structure

- `sist_bibliotecaUnab/` → main source code  
- `module-info.java` → Java module configuration  

---

## Requirements

- Java 17 or later
- Maven/Gradle for build automation (Optional)

---

## How to Run

### Option A: Compile & run manually
```bash
javac sist_bibliotecaUnab/*.java
java sist_bibliotecaUnab.Main
