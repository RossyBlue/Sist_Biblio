package sist_bibliotecaUnab;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    // ------------------ LIBROS ------------------

    public void agregarLibro(Libro libro) {
    	if(buscarLibro(libro.getIsbn()) != null)
    	{
    		throw new IllegalArgumentException("EL ISBN YA EXISTE, NO SE PUEDE AGREGAR EL LIBRO");
    	}
        libros.add(libro);
    }

    public void eliminarLibro(String isbn) {
        libros.removeIf(l -> l.getIsbn().equals(isbn));
    }

    public Libro buscarLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                return l;
            }
        }
        return null;
    }

    // ------------------ USUARIOS ------------------

    public void agregarUsuario(Usuario usuario) {
          	
    	if(buscarUsuario(usuario.getRun()) != null)
    	{
    		throw new IllegalArgumentException("EL RUN INGRESADO YA EXISTE, NO ES POSIBLE INGRESAR");
    	}
    	usuarios.add(usuario);
    }

    public void eliminarUsuario(String run) {
        usuarios.removeIf(u -> u.getRun().equals(run));
    }

    public Usuario buscarUsuario(String run) {
        for (Usuario u : usuarios) {
            if (u.getRun().equals(run)) {
                return u;
            }
        }
        return null;
    }

    // ------------------ PRÉSTAMOS ------------------

    public void realizarPrestamo(String run, String isbn, int dias) {
        Libro libro = buscarLibro(isbn);
        Usuario usuario = buscarUsuario(run);

        if (libro == null || usuario == null) {
            System.out.println("Libro o usuario no encontrado.");
            return;
        }

        if (!libro.estaDisponible()) {
            System.out.println("No hay ejemplares disponibles.");
            return;
        }

        if (!usuario.estaDisponibleParaPrestamo()) {
            System.out.println("Usuario ya tiene un préstamo.");
            return;
        }

        if ((usuario instanceof Estudiante && dias > 10) || (usuario instanceof Docente && dias > 20)) {
            System.out.println("Días de préstamo exceden el máximo permitido.");
            return;
        }

        usuario.setPrestamo(isbn);
        libro.setCantidadDisponible(libro.getCantidadDisponible() - 1);
        Prestamo p = new Prestamo(run, isbn, dias);
        prestamos.add(p);

        System.out.println("Préstamo realizado exitosamente.");
    }

    public void devolverLibro(String run, String isbn) {
        Libro libro = buscarLibro(isbn);
        Usuario usuario = buscarUsuario(run);

        if (libro == null || usuario == null) {
            System.out.println("Libro o usuario no encontrado.");
            return;
        }

        if (!usuario.tienePrestamoDe(isbn)) {
            System.out.println("El usuario no tiene este libro prestado.");
            return;
        }

        usuario.liberarPrestamo();
        libro.setCantidadDisponible(libro.getCantidadDisponible() + 1);

        Prestamo prestamo = null;
        for (Prestamo p : prestamos) {
            if (p.getRunUsuario().equals(run) && p.getIsbnLibro().equals(isbn)) {
                prestamo = p;
                break;
            }
        }

        if (prestamo != null) {
            int multa = prestamo.calcularMulta();
            if (multa > 0) {
                System.out.println("Multa por atraso: $" + multa);
            } else {
                System.out.println("Libro devuelto a tiempo.");
            }
            prestamos.remove(prestamo);
        }

        System.out.println("Devolución registrada correctamente.");
    }
}
