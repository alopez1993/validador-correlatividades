package domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

public class testInscsripcion {
    private Alumno alumno;
    private Materia paradigmas;
    private Materia discreta;
    private Materia dds;
    private Materia analisisSistemas;
    private Materia algoritmos;
    private Materia sistemas;

    @Before
    public void setUp() {
        // Creo las materias
        dds = new Materia(300);
        paradigmas = new Materia(203);
        analisisSistemas = new Materia(200);
        algoritmos = new Materia(101);
        discreta = new Materia(102);
        sistemas = new Materia(100);

        // Agrego correlativas
        dds.agregarCorrelativas(paradigmas, analisisSistemas);
        paradigmas.agregarCorrelativas(algoritmos);
        analisisSistemas.agregarCorrelativas(algoritmos, sistemas);

        //Creo el alumno
        alumno = new Alumno("1668766");

        //Agrego materias aprobadas por alumno
        alumno.agregarMateriasAprobadas(algoritmos, sistemas);
    }

    @Test
    public void testInscripcionSinCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(alumno, Collections.singletonList(discreta)); // discreta no tiene correlativas
        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionUnaCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(alumno, Collections.singletonList(paradigmas)); // paradigmas tiene una sola correlativa
        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionDosCorrelativas() {
        Inscripcion inscripcion = new Inscripcion(alumno, Collections.singletonList(analisisSistemas)); // analisisSistemas tiene dos correlativas
        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void testInscripcionFalse() {
        Inscripcion inscripcion = new Inscripcion(alumno, Collections.singletonList(dds)); // analisisSistemas tiene dos correlativas
        Assert.assertFalse(inscripcion.aprobada());
    }



}
