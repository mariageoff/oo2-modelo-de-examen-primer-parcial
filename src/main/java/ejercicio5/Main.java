package main.java.ejercicio5;

public class Main {
    public static void main(String[] args) {
        SqlPaginador sqlPaginadorPg = new PaginadorPg();
        SqlPaginador sqlPaginadorOracle = new PaginadorOracle();

        String sqlBase = "SELECT * FROM empleados";

        String query1 = sqlPaginadorPg.generar(sqlBase);
        String query2 = sqlPaginadorOracle.generar(sqlBase);

        System.out.println("SQL para PostgreSQL:");
        System.out.println(query1);

        System.out.println("\nSQL para Oracle:");
        System.out.println(query2);
    }
}
