package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {
    //Le damos un atributo de código único para solventar errores de diferentes nombres al objeto.
    private Integer codigoMateria;
    private List<Materia> correlativas;

    public Materia(Integer codigoMateria) {
        this.codigoMateria = codigoMateria;
        this.correlativas = new ArrayList<>();
    }

    public Integer getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(Integer codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agregarCorrelativas(Materia ... correlativas){
        Collections.addAll(this.correlativas, correlativas);
    }
}
