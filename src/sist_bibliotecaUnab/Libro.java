package sist_bibliotecaUnab;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private int cantidadTotal; //CANTIDAD EN BIBLIOTECA
    private int cantidadDisponible;
    private String imagen;

    public Libro(String isbn, String titulo, String autor, int cantidadTotal, int cantidadDisponible, String imagen) {
        if (cantidadTotal <= 0 || cantidadDisponible < 0 || cantidadDisponible > cantidadTotal) {
            throw new IllegalArgumentException("Cantidades inválidas");
        }
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponible = cantidadDisponible;
        this.imagen = imagen;
    }

    public boolean estaDisponible() {
        return cantidadDisponible > 0;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }


    // Getters, setters...
}

