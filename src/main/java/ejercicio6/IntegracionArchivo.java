package main.java.ejercicio6;

public class IntegracionArchivo implements IntegracionCobol{

    @Override
    public void registrarVenta(RegistroVenta venta) {
        String contenido = venta.codigoProducto() + "|" + venta.fecha();
        //logica de guardado en archivo...
        System.out.println("Guardando en archivo: " + contenido);
    }
}
