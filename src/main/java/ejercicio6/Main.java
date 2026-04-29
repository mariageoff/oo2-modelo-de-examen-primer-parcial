package main.java.ejercicio6;

public class Main {
    public static void main(String[] args) {
        RegistroVenta venta1 = new RegistroVenta("PROD001", "2024-06-01");
        RegistroVenta venta2 = new RegistroVenta("PROD002", "2024-06-01");

        SistemaVentas sistemaArchivo = new SistemaVentas(new IntegracionArchivo());
        sistemaArchivo.vender(venta1);

        SistemaVentas sistemaWeb = new SistemaVentas(new IntegracionServicioWeb());
        sistemaWeb.vender(venta2);
    }
}
