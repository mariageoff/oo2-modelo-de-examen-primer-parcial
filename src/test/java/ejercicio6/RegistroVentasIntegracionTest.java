package test.java.ejercicio6;

import main.java.ejercicio6.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistroVentasIntegracionTest {

    @Test
    void usoDeEstrategiaDeInegracionParaRegistarVenta(){
        FakeIntegracion fake = new FakeIntegracion();
        SistemaVentas sistemaVentas = new SistemaVentas(fake);

        RegistroVenta venta = new RegistroVenta("PROD123", "2024-06-01");
        sistemaVentas.vender(venta);

        assertTrue(fake.fueLlamado);
    }
}
