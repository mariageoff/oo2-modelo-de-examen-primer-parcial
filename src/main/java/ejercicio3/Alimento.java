package main.java.ejercicio3;

public class Alimento extends Producto{

    public Alimento(Double precio) {
        super(precio);
    }

    @Override
    public double impuestos() {
        return 0.05;
    }

    @Override
    public double calcularDescuento(double descuento) {
        if(this.precio > 100){
            descuento += 0.15;
        }
        return descuento;
    }

    @Override
    public boolean tieneEnvioGratis() {
        return this.precio > 200;
    }
}
