package sist_bibliotecaUnab;

public class Estudiante extends Usuario {
    public Estudiante(String run, String nombreCompleto, Sexo genero, String carrera) {
        super(run, nombreCompleto, genero, carrera);
    }

    @Override
    public String getTipoUsuario() {
        return "Estudiante";
    }
}
