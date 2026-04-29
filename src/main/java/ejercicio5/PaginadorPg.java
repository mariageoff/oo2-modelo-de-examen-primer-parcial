package main.java.ejercicio5;

public class PaginadorPg extends SqlPaginador {

    @Override
    protected String paginacion() {
        return "LIMIT 20 OFFSET 0;";
    }
}
