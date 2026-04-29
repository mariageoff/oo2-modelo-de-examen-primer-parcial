package test.java.ejercicio3;

import main.java.ejercicio3.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void impuestosTest() {
            Producto libro = new Libro(30.0);
            Producto alimento = new Alimento(130.0);

            assertEquals(0.1, libro.impuestos(), 0.001);
            assertEquals(0.05, alimento.impuestos(), 0.001);
    }

    @Test
    void calcularDescuentoTest() {
            Producto libro = new Libro(30.0);
            Producto alimento = new Alimento(130.0);

            assertEquals(0.1, libro.calcularDescuento(0.10), 0.001);
            assertEquals(0.25, alimento.calcularDescuento(0.10), 0.001);
    }

    @Test
    void tieneEnvioGratisTest() {
            Producto libro = new Libro(30.0);
            Producto alimento = new Alimento(210.0);

            assertFalse(libro.tieneEnvioGratis());
            assertTrue(alimento.tieneEnvioGratis());
    }

    @Test
    void precioFinalTest() {
            Producto libro = new Libro(30.0);
            Producto alimento = new Alimento(130.0);

            assertEquals(29.7, libro.precioFinal(0.10), 0.001);
            assertEquals(102.375, alimento.precioFinal(0.10), 0.001);
    }
}