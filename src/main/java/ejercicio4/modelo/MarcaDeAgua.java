package main.java.ejercicio4.modelo;

public class MarcaDeAgua implements EscritoPdf {
    private EscritoPdf escrito;

    public MarcaDeAgua(EscritoPdf escrito){
        this.escrito = escrito;
    }

    @Override
    public String contenido() {
        return escrito.contenido() + "\n[MARCA DE AGUA]";
    }
}
