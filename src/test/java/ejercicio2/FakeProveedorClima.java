package test.java.ejercicio2;

import main.java.ejercicio2.ClimaOnline;

import java.time.LocalDate;

public class FakeProveedorClima implements ClimaOnline {
    @Override
    public String clima(LocalDate fecha) {
        return "NUBLADO|26";
    }
}
