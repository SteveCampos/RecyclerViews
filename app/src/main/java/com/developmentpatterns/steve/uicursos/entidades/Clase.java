package com.developmentpatterns.steve.uicursos.entidades;

/**
 * Created by Steve on 16/05/2016.
 */
public class Clase {

    private String claseName;
    //private long time;
    private String hora;

    public Clase(String claseName, String hora) {
        this.claseName = claseName;
        this.hora = hora;
    }

    public Clase() {
    }

    public String getClaseName() {
        return claseName;
    }

    public void setClaseName(String claseName) {
        this.claseName = claseName;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
