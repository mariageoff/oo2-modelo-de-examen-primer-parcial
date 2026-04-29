package test.java.ejercicio2;

import main.java.ejercicio2.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClimaTest {

    @Test
    void climaEnTest() {
        Clima c = new Clima(new FakeProveedorClima());
        var tipoYNudos = c.climaEn(LocalDate.of(2026, 4,28));

        assertEquals("NUBLADO", tipoYNudos.tipo());
        assertEquals(26, tipoYNudos.nudos());
    }
}