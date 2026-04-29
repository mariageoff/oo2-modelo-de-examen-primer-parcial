package main.java.ejercicio3;

public abstract class Producto {
    public double precio;

    public Producto(Double precio){
        this.precio = precio;
    }

    public abstract double impuestos();

    public abstract double calcularDescuento(double descuentoInicial);

    public abstract boolean tieneEnvioGratis();

    public double precioFinal(double descuentoInicial) {
        double total = precio * (1 + impuestos()) * (1 - calcularDescuento(descuentoInicial));
        if (tieneEnvioGratis()) {
            total -= 10;
        }
        return total;
    }
}
