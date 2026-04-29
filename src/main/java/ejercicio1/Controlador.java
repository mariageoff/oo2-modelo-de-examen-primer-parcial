package main.java.ejercicio1;

import java.util.Collection;

public class Controlador {
    private final Collection<Juez> jueces;

    public Controlador(Collection<Juez> jueces){
        this.jueces = jueces;
    }

    public int calcularCausasTotales() {
        int causasTotales = 0;
        for (Juez juez : jueces) {
            causasTotales += juez.cantidadDeCausas();
        }
        return causasTotales;
    }
}
