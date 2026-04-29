Primera parte de la materia:

1. Dado el siguiente código:

public class Controlador {
    private Collection<Juez> jueces;
    
    public int calcularCausasTotales() {
        int cantidadCausas = 0;
        for (Juez juez : jueces) {
            for (Causa causa : juez.causas()) {
                cantidadCausas += 1;
            }
        }
        return cantidadCausas;
    }
}

public class Juez {
    private String nombre;
    private String apellido;
    private Collection<Causa> causasACargo;

    public void agregarCausa(Causa causa) {
        this.causasACargo.add(causa);
    }

}

Se pide:
Refactorice aplicando tell don’t ask.
Escriba un test que verifique que el método calcularCausasTotales() funcione.


2. La siguiente clase Clima tiene un método climaEn que recibe una fecha y retorna un record con el tipo de clima (un string que puede ser SOLEADO, NUBLADO, etc) y un entero que representa la velocidad del viento. Para ello se utiliza la librería open source WeatherOnline que consume un servicio web para recuperar esa información de la  nube/Web. Esta dependencia no nos permite testear en forma automatizada el método climaEn sin invocar realmente a la librería.

Se pide:
a. Refactorice la clase Clima aplicando inyección de dependencias y depender de abstracciones de forma que sea posible inyectar un fake que permita hacer el método testable en forma automatizada.
b. Modifique el Main para que siga funcionando de forma correcta, con la invocación al servicio del clima real.


public record ClimaValor(String tipo, Integer velocidadViento) {
}
interfaz ClimaOnline {
       String clima(fecha);
}

public Weather implements CLimaOnline {
	public String clima(fecha) {
	
}
}

public class Clima {
    	private ClimaOnline climaOnline;
public Clima(ClimaOnline online) {
   this.climaOnline = online;
}
	
    public ClimaValor climaEn(LocalDate fecha) {
        String clima = this.climaOnline.clima(fecha); //new WeatherOnline().getWeather(fecha);
        //clima = "SOLEADO|25"
        String[] tipoYNudos = clima.split("|");
        return new ClimaValor(tipoYNudos[0], Integer.valueOf(tipoYNudos[1]));
    }
}

public class Main {
    public static void main(String[] args) {
        var c = new Clima();
        var tipoYViento = c.climaEn(LocalDate.of(2024, 05, 10));
        System.out.println("Tipo: " + tipoYViento.tipo());
        System.out.printl	n("Velocidad: " + tipoYViento.tipo());
    }
}


Además, se pide escribir un test que verifique el funcionamiento de Clima.climaEn() forzando un valor de retorno del servicio de WeatherOnline de “NUBLADO|26” mediante el uso de un fake.


3. La siguiente clase Producto calcula el precio de un producto teniendo en cuenta impuestos, descuentos y envío. Luego se presenta un Main para mostrar cómo se utiliza.  Se pide:
a. Refactorizar para remover los IFs sobre los tipos de producto aplicando polimorfismo. Verificar de no romper el funcionamiento luego del refactor.
b. Modifique el main para que funcione de acuerdo al refactor realizado.

enum TipoProducto {
    LIBRO,
    ALIMENTO
}

class Producto {
    public CategoriaProducto tipo;
    public double precio;

    public Producto(TipoProducto tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public double precioFinal(double descuentoInicial) {
        double impuestos = 0;
        boolean envioGratis = false;
        double descuento = descuentoInicial;
        if (tipo == TipoProducto.LIBRO) {
            impuestos = 0.1;
            if (precio > 100) {
                envioGratis = true;
            }
        } else if (tipo == TipoProducto.ALIMENTO) {
            impuestos = 0.05;
            if (precio > 100) {
                descuento = descuento + 0.15;
            }
            if (precio > 200) {
                envioGratis = true;
            }
        } 
       
        double total = precio * (1 + impuestos) * (1 - descuento);
        if (envioGratis) {
            total -= 10;
        }

        return total;
    }
}


public class Main {
    public static void main(String[] args) {
        var p1 = new Producto(TipoProducto.LIBRO, 30);
        var p2 = new Producto(TipoProducto.ALIMENTO, 130);
        System.out.println(p1.precioFinal(10));
        System.out.println(p2.precioFinal(10));
    }
}




Segunda Parte de la materia:

1. Dado el siguiente Main donde se utiliza un conjunto de clases implementadas con el patrón de diseño Decorador:

EscritoPdf pdfEscrito = new PiePagina(new Cabecera(new Escrito("texto del escrito")));
pdfEscrito.generarPdf();

Este conjunto de objetos termina generando un String con “texto del escrito” agregándole además un header (cabecera) y un footer (pie de página). Luego se genera un PDF con ese contenido.

Dibuje el diagrama de clases que hace posible crear este Main y agregue una clase nueva al diagrama que permita agregar a EscritoPdf una marca de agua (la implementación en pseudocódigo). Escriba un Main donde se cree un EscritoPdf con marca de agua y con cabecera (pero sin footer).

2. La siguiente clase permite agregar a una query SQL la parte que permite obtener los primeros 20 resultados (paginación). Dado que el manejo de la paginación en Oracle es diferente a PostgreSQL, recibe dos valores booleanos indicando para qué motor de BD se está solicitando la query.

public class SqlPaginator {
    public String generar(String sql, bool pg, bool oracle) {
	if (pg) {
	  return sql + "LIMIT 20 OFFSET 0;"	  
	} else {
	  return sql + "OFFSET 0 ROWS FETCH NEXT 20 ROWS ONLY;"	  
	}
    }
}

Refactorice utilizando Template Method de modo que el código cliente quede:

String query = new PaginadorOracle().generar(sql);
o 
String query = new PaginadorPg().generar(sql);

3. La empresa BVN está implementando un sistema de venta de sus productos online. El sistema debe integrarse con un sistema externo hecho en Cobol. Con integrarse nos referimos a que las ventas deben ingresar al sistema en Cobol. Hay dos formas de integrarse: se puede generar un archivo de texto con la venta realizada, que luego será importado por el sistema en Cobol. La otra forma es utilizando un web service que provee el sistema en Cobol. El sistema de venta online debe permitir fácilmente utilizar una forma u otra de integración con el sistema en Cobol según diferentes momentos. 

La especificación del sistema en Cobol para las dos formas de integración es la siguiente:
    • Archivo de texto plano, con campos separados por "|", con el siguiente formato: codigo-producto|fecha-de-venta.
    • Web service con la siguiente forma: 
https://sistemacobol/nuevaVenta?cp=codigo-producto&fecha=fecha-de-venta

    a) Utilizando el patrón de diseño Strategy realice un diagrama de clases que permita realizar ventas de productos y realice la integración con el sistema en Cobol pudiendo cambiar entre una estrategia u otra, de forma sencilla. 

    b) Implemente en pseudocódigo el método que realiza la venta y la integración con el sistema Cobol. Proponga un programa principal que registre dos ventas, utilizando uno de los métodos de integración con el sistema en Cobol para una de las ventas y el otro método de integración para la otra venta.
