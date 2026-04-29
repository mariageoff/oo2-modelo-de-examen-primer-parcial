package main.java.ejercicio1;

import java.util.List;

public class Main {
    public static void main(String[] args){

        Juez juez1 = new Juez("Armando", "Mendoza");
        Juez juez2 = new Juez("Mario", "Calderon");

        juez1.agregarCausa(new Causa());
        juez1.agregarCausa(new Causa());
        juez1.agregarCausa(new Causa());

        juez2.agregarCausa(new Causa());
        juez2.agregarCausa(new Causa());

        List<Juez> jueces = List.of(juez1, juez2);
        Controlador controlador = new Controlador(jueces);
        System.out.println(controlador.calcularCausasTotales());
    }
}
