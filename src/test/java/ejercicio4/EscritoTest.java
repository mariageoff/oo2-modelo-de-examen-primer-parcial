package test.java.ejercicio4;

import main.java.ejercicio4.modelo.*;
import main.java.ejercicio4.infraestructura.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscritoTest {

    @Test
    void generaContenidoConTodo() {
        EscritoPdf pdf = new PiePagina(
                new Cabecera(
                        new MarcaDeAgua(
                                new Escrito("texto")
                        )
                )
        );

        String esperado = "CABECERA\ntexto\n[MARCA DE AGUA]\nPIE DE PAGINA";

        assertEquals(esperado, pdf.contenido());
    }
}
