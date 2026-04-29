package main.java.ejercicio2;

import java.time.LocalDate;

@FunctionalInterface
public interface ClimaOnline {
    String clima(LocalDate fecha);
}
