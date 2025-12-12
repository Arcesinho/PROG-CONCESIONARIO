package Vista;

import Modelo.Coche;
import Modelo.Venta;
import java.util.ArrayList;
import java.util.Scanner;

public class Vista {

    public static final int MIN_OP = 1;
    public static final int MAX_OP = 3;
    Scanner sc = new Scanner(System.in);

    public int menu() {
        System.out.println("\n   _______");
        System.out.println("  //  ||\\ \\");
        System.out.println(" _//__||_\\ \\___");
        System.out.println(" )  _     _    \\");
        System.out.println(" |_/ \\___/ \\___|");
        System.out.println("___\\_/___\\_/____");

        System.out.println("\n╔═════════════════════════════╗");
        System.out.println("║   CONCESIONARIO RAMÍREZ   ║");
        System.out.println("╠═════════════════════════════╣");
        System.out.println("║ 1. Añadir coche             ║");
        System.out.println("║ 2. Ver coches               ║");
        System.out.println("║ 3. Buscar coches (Filtros)  ║");
        System.out.println("║ 4. Nuevo cliente            ║");
        System.out.println("║ 5. Nueva venta              ║");
        System.out.println("║ 6. Listar ventas            ║");
        System.out.println("║ 7. Estadísticas Vendedor    ║");
        System.out.println("║ 8. Salir                    ║");
        System.out.println("╚═════════════════════════════╝");

        return leerInt("Seleccione opción");
    }

    //Aquí uso un do while que me parece mas comodo pero se puede con un while o con excepciones

    public int menuBusqueda() {
        int opcion;
        do {
            System.out.println("\n--- FILTROS DE BÚSQUEDA ---");
            System.out.println("1. Por Marca");
            System.out.println("2. Por Rango de Precio");
            System.out.println("3. Por Año");

            // Leemos la opción
            opcion = leerInt("Elige una opción");

            // Si no es correcta, avisamos y el bucle while se repite
            if (opcion < MIN_OP || opcion > Vista.MAX_OP) {
                System.out.println("!Opción incorrecta¡. Por favor, elige 1, 2 o 3.");
            }
        } while (opcion < MIN_OP || opcion > MAX_OP);

        return opcion;
    }

    // MÉTODOS DE LECTURA Y ESCRITURA

    public String pedirString(String mensaje) {
        System.out.print(">> " + mensaje + ": ");
        return sc.nextLine();
    }

    //EN ESTA FUNCIÓN INTRODUCIMOS hasNextDouble y NextInt ya que no se podrá introducir ni entero ni double (no tipo numerico)

    public String pedirTexto(String mensaje) {
        System.out.print(">> " + mensaje + ": ");
        while (sc.hasNextInt() || sc.hasNextDouble()) {
            System.out.println("Error: '" + sc.next() + "' no es válido. Tiene que ser texto.");
            sc.nextLine();
            System.out.print(">> " + mensaje + ": ");
        }
        return sc.nextLine();
    }

    public int leerInt(String mensaje) {

        System.out.print(">> " + mensaje + ": ");
        while (!sc.hasNextInt()) {
            System.out.println("Error: Eso no es un número válido.");
            sc.next();
            System.out.print(">> " + mensaje + ": ");
        }
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }

    public long leerLong(String mensaje) {

        System.out.print(">> " + mensaje + ": ");
        while (!sc.hasNextLong()) {
            System.out.println("Error: Introduce un número válido (sin letras).");
            sc.next();
            System.out.print(">> " + mensaje + ": ");
        }
        long n = sc.nextLong();
        sc.nextLine();
        return n;
    }

    public double leerDouble(String mensaje) {

        System.out.print(">> " + mensaje + ": ");
        while (!sc.hasNextDouble()) {
            System.out.println("Error: Introduce un número decimal.");
            sc.next();
            System.out.print(">> " + mensaje + ": ");
        }
        double n = sc.nextDouble();
        sc.nextLine();
        return n;
    }

    // SALIDAS NECESARIAS MENSAJES DE ERROR Y MENSAJES NORMALES
    // En estos utilizamos el isEmpty para comprobar si la lista está vacía ya que no tendríamos nada que mostrar

    public void mostrarMensaje(String mensaje) {
        System.out.println("ℹ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.err.println("⚠ " + mensaje);
    }

    public void mostrarTablaCoches(ArrayList<Coche> coches) {
        if (coches.isEmpty()) {
            System.out.println("(Lista vacía)");
            return;
        }
        System.out.println("\nMATRICULA | MARCA      | MODELO     | AÑO  | PRECIO");
        System.out.println("-----------------------------------------------------");
        for (Coche c : coches) {
            System.out.println(c.getMatricula() + "   | " + c.getMarca() + "     | " +
                    c.getModelo() + "     | " + c.getAno() + " | " + c.getPrecio() + "€");
        }
        System.out.println("-----------------------------------------------------");
    }

    public void mostrarTablaVentas(ArrayList<Venta> ventas) {
        if (ventas.isEmpty()) {
            System.out.println("(No hay ventas)");
            return;
        }
        System.out.println("\n=== HISTORIAL VENTAS ===");
        for (Venta v : ventas) {
            System.out.println(v.getInfo());
        }
    }

    public void mostrarEstadisticas(String nombreVendedor, int total, double suma, double media, Coche masCaro) {
        System.out.println("\n╔════ ESTADÍSTICAS: " + nombreVendedor.toUpperCase() + " ════╗");
        System.out.println("║ Ventas Realizadas: " + total);
        System.out.println("║ Total Recaudado:   " + suma + " €");
        System.out.println("║ Precio Medio:      " + media + " €");
        System.out.println("╠══════════════════════════════════╣");
        if (masCaro != null) {
            System.out.println("║ MEJOR VENTA: " + masCaro.getMarca() + " (" + masCaro.getPrecio() + "€)");
        } else {
            System.out.println("║ (Sin ventas registradas)");
        }
        System.out.println("╚══════════════════════════════════╝");
    }
}