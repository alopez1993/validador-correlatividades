package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion {
    private Alumno alumnoInscripto;
    private List<Materia> materiasInscriptas;

    public Inscripcion(Alumno alumnoInscripto, List<Materia> materiasInscriptas) {
        this.alumnoInscripto = alumnoInscripto;
        this.materiasInscriptas = new ArrayList<>(materiasInscriptas);

    }

    public Alumno getAlumnoInscripto() {
        return alumnoInscripto;
    }

    public void setAlumnoInscripto(Alumno alumnoInscripto) {
        this.alumnoInscripto = alumnoInscripto;
    }

    public List<Materia> getMateriasInscriptas() {
        return materiasInscriptas;
    }

    public void agregarMateriasInscriptas(Materia ... materiasInscriptas){
        Collections.addAll(this.materiasInscriptas, materiasInscriptas);
    }

    public boolean aprobada(){
        // Obtengo una lista de códigos de materia aprobadas
        List<Integer> codigosMateriasAprobadas = alumnoInscripto.getMateriasAprobadas().stream()
                .map(Materia::getCodigoMateria)
                .collect(Collectors.toList());

        return this.materiasInscriptas.stream()
                .allMatch(materia -> materia.getCorrelativas().stream().
                        allMatch(correlativa -> codigosMateriasAprobadas.
                                contains(correlativa.getCodigoMateria())));

    }

}

