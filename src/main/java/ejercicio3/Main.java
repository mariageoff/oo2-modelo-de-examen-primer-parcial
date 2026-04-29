package main.java.ejercicio3;

public class Main {
    public static void main(String[] args) {
        var p1 = new Libro(30.0);
        var p2 = new Alimento(130.0);
        System.out.println(p1.precioFinal(0.10));
        System.out.println(p2.precioFinal(0.10));
    }
}
