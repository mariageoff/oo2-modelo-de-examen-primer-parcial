package main.java.ejercicio5;

public class PaginadorOracle extends SqlPaginador {

    @Override
    protected String paginacion() {
        return "OFFSET 0 ROWS FETCH NEXT 20 ROWS ONLY;";
    }
}
