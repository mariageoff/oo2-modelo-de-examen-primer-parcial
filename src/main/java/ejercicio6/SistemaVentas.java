package main.java.ejercicio6;

public class SistemaVentas {
    private IntegracionCobol integracion;

    public SistemaVentas(IntegracionCobol integracion){
        this.integracion = integracion;
    }

    public void vender(RegistroVenta registroVenta){
        //logica de venta...
        integracion.registrarVenta(registroVenta);
    }
}
