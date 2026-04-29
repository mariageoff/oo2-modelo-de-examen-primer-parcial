package main.java.ejercicio3;

public class Libro extends Producto {

    public Libro(Double precio) {
        super(precio);
    }

    @Override
    public double impuestos() {
        return 0.1;
    }

    @Override
    public double calcularDescuento(double descuento) {
        return descuento;
    }

    @Override
    public boolean tieneEnvioGratis() {
        return this.precio > 100;
    }
}
