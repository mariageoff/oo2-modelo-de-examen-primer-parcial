package main.java.ejercicio4.modelo;

public class Escrito implements EscritoPdf {
    private String texto;

    public Escrito(String texto){
        this.texto = texto;
    }

    @Override
    public String contenido() {
        return texto;
    }
}
