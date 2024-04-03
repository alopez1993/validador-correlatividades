package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Alumno {
   private String legajo;
   private List<Materia> materiasAprobadas;

    public Alumno(String legajo) {
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getLegajo() {
        return legajo;
    }

    public void agregarMateriasAprobadas(Materia ... materiasAprobadas) {
        Collections.addAll(this.materiasAprobadas, materiasAprobadas);
    }

    public List<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }


}
