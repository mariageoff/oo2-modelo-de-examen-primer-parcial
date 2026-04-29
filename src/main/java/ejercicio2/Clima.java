package main.java.ejercicio2;

import java.time.LocalDate;

public class Clima {
    private final ClimaOnline climaOnline;

    public Clima(ClimaOnline climaOnline){
        this.climaOnline = climaOnline;
    }

    public ClimaValor climaEn(LocalDate fecha){
        String c = this.climaOnline.clima(fecha);
        String[] tipoYNudos = c.split("\\|");
        return new ClimaValor(tipoYNudos[0], Integer.valueOf(tipoYNudos[1]));
    }
}
