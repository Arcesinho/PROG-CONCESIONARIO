package Controlador;

import Vista.Vista;
import Modelo.Clientes;
import Modelo.Coche;
import Modelo.Venta;
import Modelo.Vendedor;
import java.time.LocalDate;//Con esto podemos calcular la fecha
import java.util.ArrayList;

public class Controlador {

    //Atributos, que principalmente son listas

    private final ArrayList<Coche> inventario;
    private final ArrayList<Clientes> clientes;
    private final ArrayList<Vendedor> plantilla;
    private final ArrayList<Venta> ventas;
    private final Vista vista;
    private  int contadorVentas = 1;

    public Controlador() {
        this.inventario = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.plantilla = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.vista = new Vista();
        cargarDatosIniciales();
    }

    //Englobamos en una función el cargado de nuestros coches y clientes iniciales

    private void cargarDatosIniciales() {
        inventario.add(new Coche("Toyota", "Corolla", "1111AAA", 12000, 2018, 50000));
        inventario.add(new Coche("Ford", "Fiesta", "2222BBB", 8000, 2015, 80000));
        inventario.add(new Coche("Seat", "Ibiza", "3333CCC", 10000, 2019, 30000));


        clientes.add(new Clientes("12345678A", "Juan", 600111222L));
        clientes.add(new Clientes("87654321B", "Maria", 600333444L));

        plantilla.add(new Vendedor("Pepe", "11223344U"));
        plantilla.add(new Vendedor("Ana", "11223344T"));
    }

    //Función que corre nuestro programa, la cual solo acaba cuando salir es true

    public void run() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.menu();
            switch (opcion) {
                case 1: agregarCoche(); break;
                case 2: vista.mostrarTablaCoches(inventario); break;
                case 3: buscarCoches(); break;
                case 4: registrarCliente(); break;
                case 5: registrarVenta(); break;
                case 6: vista.mostrarTablaVentas(ventas); break;
                case 7: calcularEstadisticas(); break;
                case 8: salir = true; break;
                default: vista.mostrarError("Opción no válida.");
            }
        }
    }

    //Con nuestras funciones de pedir texto, string int y double vamos almacenando los valores

    private void agregarCoche() {
        String marca = vista.pedirTexto("Marca");
        String modelo = vista.pedirTexto("Modelo");
        String matricula = vista.pedirString("Matrícula");
        int precio = vista.leerInt("Precio");
        int ano = vista.leerInt("Año");
        double kms = vista.leerDouble("Kilómetros");

        inventario.add(new Coche(marca, modelo, matricula, precio, ano, kms));
        vista.mostrarMensaje("Coche guardado.");
    }

    //Primero comprobamos si ya existe ese cliente y si no existe pedimos los datos para su registro

    private void registrarCliente() {
        String dni = vista.pedirString("DNI");
        for (Clientes c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                vista.mostrarError("Ya existe ese DNI.");
                return;
            }
        }
        String nombre = vista.pedirTexto("Nombre");


        long telefono = vista.leerLong("Teléfono (solo números)");

        clientes.add(new Clientes(dni, nombre, telefono));
        vista.mostrarMensaje("Cliente guardado.");
    }

    //Vamos preguntando al usuario por los datos y comprobando si existen

    private void registrarVenta() {
        vista.mostrarMensaje("Vendedores disponibles: Pepe, Ana...");
        String nombreVend = vista.pedirTexto("¿Quién realiza la venta?");
        Vendedor vendedor = null;
        for (Vendedor v : plantilla) {
            if (v.getNombre().equalsIgnoreCase(nombreVend)) vendedor = v;
        }
        if (vendedor == null) {
            vista.mostrarError("Vendedor no encontrado.");
            return;
        }

        String dni = vista.pedirString("DNI Cliente");
        Clientes cliente = null;
        for (Clientes c : clientes) {
            if (c.getDni().equalsIgnoreCase(dni)) cliente = c;
        }
        if (cliente == null) {
            vista.mostrarError("Cliente no encontrado.");
            return;
        }

        String matricula = vista.pedirString("Matrícula Coche");
        Coche coche = null;
        for (Coche c : inventario) {
            if (c.getMatricula().equalsIgnoreCase(matricula)) coche = c;
        }
        if (coche == null) {
            vista.mostrarError("Coche no encontrado.");
            return;
        }

        Venta v = new Venta(contadorVentas, cliente, coche, vendedor, LocalDate.now(), coche.getPrecio());
        ventas.add(v);
        contadorVentas++;
        inventario.remove(coche);
        vista.mostrarMensaje("Venta registrada por " + vendedor.getNombre());
    }

    //Buscamos según la opción que nos ponga el resultado, pasamos la función para pasar el menú.

    private void buscarCoches() {

        int opcion = vista.menuBusqueda();

        ArrayList<Coche> resultado = new ArrayList<>();

        if (opcion == 1) {
            String marca = vista.pedirTexto("Marca");
            for (Coche c : inventario) {
                if (c.getMarca().equalsIgnoreCase(marca)) resultado.add(c);
            }
        } else if (opcion == 2) {
            int min = vista.leerInt("Precio Mín");
            int max = vista.leerInt("Precio Máx");
            for (Coche c : inventario) {
                if (c.getPrecio() >= min && c.getPrecio() <= max) resultado.add(c);
            }
        } else if (opcion == 3) {
            int ano = vista.leerInt("Año");
            for (Coche c : inventario) {
                if (c.getAno() == ano) resultado.add(c);
            }
        }
        vista.mostrarTablaCoches(resultado);
    }

    //Pedimos el nombre de un vendedor ya registrado y vemos si ha realizado alguna venta, si es así devolvemos los valores deseados

    private void calcularEstadisticas() {

        String nombre = vista.pedirTexto("Nombre del vendedor a consultar");
        Vendedor vendedorSeleccionado = null;
        for (Vendedor v : plantilla) {
            if (v.getNombre().equalsIgnoreCase(nombre)) vendedorSeleccionado = v;
        }

        if (vendedorSeleccionado == null) {
            vista.mostrarError("Ese vendedor no trabaja aquí.");
            return;
        }

        double suma = 0;
        int cantidad = 0;
        Coche masCaro = null;
        double precioMax = 0;

        for (Venta v : ventas) {
            if (v.getVendedor().getNombre().equalsIgnoreCase(nombre)) {
                cantidad++;
                suma = suma + v.getPrecioVenta();

                if (v.getPrecioVenta() > precioMax) {
                    precioMax = v.getPrecioVenta();
                    masCaro = v.getCoche();
                }
            }
        }

        double media = 0;
        if (cantidad > 0) {
            media = suma / cantidad;
        }

        vista.mostrarEstadisticas(vendedorSeleccionado.getNombre(), cantidad, suma, media, masCaro);
    }
}