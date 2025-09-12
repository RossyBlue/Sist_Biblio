package sist_bibliotecaUnab;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private String runUsuario;
    private String isbnLibro;
    private LocalDate fechaPrestamo;
    private int diasPrestamo;
    private LocalDate fechaDevolucion;
    private int multa;

    public Prestamo(String runUsuario, String isbnLibro, int diasPrestamo) {
        this.runUsuario = runUsuario;
        this.isbnLibro = isbnLibro;
        this.fechaPrestamo = LocalDate.now();
        this.diasPrestamo = diasPrestamo;
        this.fechaDevolucion = fechaPrestamo.plusDays(diasPrestamo);
        this.multa = calcularMulta();
    }

    public int calcularMulta() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(fechaDevolucion)) {
            long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, hoy);
            return (int) diasRetraso * 1000;
        }
        return 0;
    }
    public String getRunUsuario() {
        return runUsuario;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }


    // Getters y setters
}

