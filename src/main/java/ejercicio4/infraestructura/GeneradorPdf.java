package main.java.ejercicio4.infraestructura;

import main.java.ejercicio4.modelo.EscritoPdf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeneradorPdf {
    private final Path PATH = Path.of("src/main/resources/escrito.txt");

    public void generar(EscritoPdf escrito){
        String contenido = escrito.contenido();
        try{
            Files.writeString(PATH, contenido);
        } catch (IOException e) {
            throw new RuntimeException("Error al generar el archivo",e);
        }
    }
}
