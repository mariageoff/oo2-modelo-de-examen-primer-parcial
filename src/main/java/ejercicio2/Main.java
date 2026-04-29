package main.java.ejercicio2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Clima c = new Clima(new Weather());
        var tipoYNudos = c.climaEn(LocalDate.of(2024, 5, 10));
        System.out.println("Tipo: " + tipoYNudos.tipo());
        System.out.println("Velocidad: " + tipoYNudos.nudos());
    }
}
