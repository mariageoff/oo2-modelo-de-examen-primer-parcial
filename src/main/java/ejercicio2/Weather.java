package main.java.ejercicio2;

import java.time.LocalDate;

public class Weather implements ClimaOnline{
    @Override
    public String clima(LocalDate fecha) {
        return "LLUVIA|20";
        //return new WeatherOnline().getWeather(fecha);
    }
}
