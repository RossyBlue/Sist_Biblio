package sist_bibliotecaUnab;

public abstract class Usuario {
    protected String run;
    protected String nombreCompleto;
    protected Sexo genero;
    protected String carrera;
    protected String prestamo; // "0" o ISBN

    
    public enum Sexo {
        M,
        F;
    }
    public Usuario(String run, String nombreCompleto, Sexo genero, String carrera) {
    	if (!validarRUN(run)) {
    	    throw new IllegalArgumentException("EL RUN INGRESADO NO ES VALIDO");
    	}
        this.run = run;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.carrera = carrera;
        this.prestamo = "0";
    }

    public boolean estaDisponibleParaPrestamo() {
        return this.prestamo.equals("0");
    }

    public void liberarPrestamo() {
        this.prestamo = "0";
    }

    public boolean tienePrestamoDe(String isbn) {
        return this.prestamo.equals(isbn);
    }

    public abstract String getTipoUsuario();
    
    public String getRun() {
        return run;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    	    public boolean validarRUN(String run) {
    	        if (run == null || !run.contains("-")) return false;

    	        // Separar cuerpo y dígito verificador
    	        String[] partes = run.split("-");
    	        if (partes.length != 2) return false;

    	        try {
    	            int cuerpo = Integer.parseInt(partes[0]);
    	            char dv = partes[1].toUpperCase().charAt(0);

    	            return validarRUN(cuerpo, dv);
    	        } catch (NumberFormatException e) {
    	            return false; // Si el cuerpo no es un número
    	        }
    	    }

    	    private boolean validarRUN(int run, char dv) {
    	        int suma = 0;
    	        int multiplicador = 2;

    	        while (run > 0) {
    	            int digito = run % 10;
    	            suma += digito * multiplicador;
    	            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
    	            run /= 10;
    	        }

    	        int resto = 11 - (suma % 11);
    	        char digitoVerificador;

    	        if (resto == 11) {
    	            digitoVerificador = '0';
    	        } else if (resto == 10) {
    	            digitoVerificador = 'K';
    	        } else {
    	            digitoVerificador = (char) (resto + '0');
    	        }

    	        return dv == digitoVerificador;
    	    }
}

