package main.java.ejercicio4.modelo;

public class PiePagina implements EscritoPdf {
    private EscritoPdf escrito;

    public PiePagina(EscritoPdf escrito){
        this.escrito = escrito;
    }

    @Override
    public String contenido() {
        return escrito.contenido() + "\nPIE DE PAGINA";
    }
}
