package test.java.ejercicio1;

import main.java.ejercicio1.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControladorTest {

    @Test
    void calcularCausasTotales() {
        Juez juez1 = new Juez("Armando", "Mendoza");
        Juez juez2 = new Juez("Mario", "Calderon");

        juez1.agregarCausa(new Causa());
        juez1.agregarCausa(new Causa());
        juez1.agregarCausa(new Causa());

        juez2.agregarCausa(new Causa());
        juez2.agregarCausa(new Causa());

        Controlador ctrl = new Controlador(List.of(juez1, juez2));
        assertEquals(5, ctrl.calcularCausasTotales());
    }
}