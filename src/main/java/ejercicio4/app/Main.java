package main.java.ejercicio4.app;

import main.java.ejercicio4.infraestructura.*;
import main.java.ejercicio4.modelo.*;

public class Main {
    public static void main(String[] args) {
        EscritoPdf pdf = new PiePagina(
                new Cabecera(
                        new MarcaDeAgua(
                                new Escrito("texto del escrito"))));

        new GeneradorPdf().generar(pdf);
    }
}
