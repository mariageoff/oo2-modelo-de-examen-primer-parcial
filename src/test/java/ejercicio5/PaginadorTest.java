package test.java.ejercicio5;

import main.java.ejercicio5.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PaginadorTest {

    @Test
    void paginadorOracleTest(){
        SqlPaginador sqlPagOracle = new PaginadorOracle();
        String sqlBase = "SELECT * FROM empleados";

        String query = sqlPagOracle.generar(sqlBase);
        String expected = "SELECT * FROM empleados OFFSET 0 ROWS FETCH NEXT 20 ROWS ONLY;";

        assertEquals(expected, query);
    }

    @Test
    void paginadorPgTest(){
        SqlPaginador sqlPagPg = new PaginadorPg();
        String sqlBase = "SELECT * FROM empleados";

        String query = sqlPagPg.generar(sqlBase);
        String expected = "SELECT * FROM empleados LIMIT 20 OFFSET 0;";

        assertEquals(expected, query);
    }
}
