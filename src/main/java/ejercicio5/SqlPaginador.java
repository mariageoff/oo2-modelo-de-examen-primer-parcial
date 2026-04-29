package main.java.ejercicio5;

public abstract class SqlPaginador {

    public final String generar(String sql){
        return sql + " " + paginacion();
    }

    protected abstract String paginacion();
}
