package sist_bibliotecaUnab;

public class Docente extends Usuario {
    private String profesion;
    private boolean tieneMagister;
    private boolean tieneDoctorado;

    public Docente(String run, String nombreCompleto, Sexo genero, String carrera,
                   String profesion, boolean tieneMagister, boolean tieneDoctorado) {
        super(run, nombreCompleto, genero, carrera);
        this.profesion = profesion;
        this.tieneMagister = tieneMagister;
        this.tieneDoctorado = tieneDoctorado;
    }

    @Override
    public String getTipoUsuario() {
        return "Docente";
    }

    // Getters y setters
}
