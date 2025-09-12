package sist_bibliotecaUnab;

import sist_bibliotecaUnab.Usuario.Sexo;

public class Main {
    public static void main(String[] args) {
        Biblioteca sistema = new Biblioteca();

        // --------- AGREGAR LIBROS ----------
        Libro libro1 = new Libro("ISBN001", "Programación Java", "Juan Pérez", 5, 5, "imagen1.jpg");
        Libro libro2 = new Libro("ISBN002", "POO Avanzado", "Ana López", 3, 3, "imagen2.jpg");

        sistema.agregarLibro(libro1);
        sistema.agregarLibro(libro2);

        // --------- AGREGAR USUARIOS ----------
        Estudiante estudiante = new Estudiante("8857628-4", "María Soto", Sexo.F, "Ingeniería");
        Docente docente = new Docente("8024702-8", "Carlos Reyes", Sexo.M, "Informática", "Ingeniero", true, false);
        
        sistema.agregarUsuario(estudiante);
        sistema.agregarUsuario(docente);

        // --------- PRÉSTAMO VÁLIDO (estudiante) ----------
        sistema.realizarPrestamo("8857628-4", "ISBN001", 7);

        // --------- INTENTA PRÉSTAMO CON MISMO USUARIO (no debería poder) ----------
        sistema.realizarPrestamo("8857628-4", "ISBN002", 5);  // No debe dejar

        // --------- PRÉSTAMO VÁLIDO (docente) ----------
        sistema.realizarPrestamo("8024702-8", "ISBN002", 15);

        // --------- DEVOLUCIÓN (estudiante) ----------
        sistema.devolverLibro("8857628-4", "ISBN001");

        // --------- NUEVO PRÉSTAMO tras devolución ----------
        sistema.realizarPrestamo("8857628-4", "ISBN002", 10);  // Ahora sí debe dejar
    }
}

