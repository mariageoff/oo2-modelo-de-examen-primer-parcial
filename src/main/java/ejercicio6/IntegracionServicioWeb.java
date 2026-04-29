package main.java.ejercicio6;

public class IntegracionServicioWeb implements IntegracionCobol{

    @Override
    public void registrarVenta(RegistroVenta venta) {
        String url = "https://sistemacobol/nuevaVenta?cp="
                + venta.codigoProducto()
                + "&fecha=" + venta.fecha();
        //logica de llamada al servicio web...
        System.out.println("Llamando a: " + url);
    }
}
