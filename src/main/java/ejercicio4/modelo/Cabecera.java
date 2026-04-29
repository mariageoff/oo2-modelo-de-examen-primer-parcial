package main.java.ejercicio4.modelo;

public class Cabecera implements EscritoPdf {
    private EscritoPdf escrito;

    public Cabecera(EscritoPdf escrito){
        this.escrito = escrito;
    }

    @Override
    public String contenido() {
        return "CABECERA\n" + escrito.contenido();
    }
}
