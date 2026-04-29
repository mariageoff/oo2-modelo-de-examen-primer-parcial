package test.java.ejercicio6;

import main.java.ejercicio6.*;

public class FakeIntegracion implements IntegracionCobol {
    public boolean fueLlamado = false;

    @Override
    public void registrarVenta(RegistroVenta registroVenta) {
        fueLlamado = true;
    }
}
