package main.java.ejercicio1;

import java.util.ArrayList;
import java.util.Collection;

public class Juez {
    private final String nombre;
    private final String apellido;
    private final Collection<Causa> causasACargo;

    public Juez(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        this.causasACargo = new ArrayList<>();
    }

    public int cantidadDeCausas(){
        return this.causasACargo.size();
    }

    public void agregarCausa(Causa causa) {
        this.causasACargo.add(causa);
    }
}
