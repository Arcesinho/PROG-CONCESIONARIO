package Vista;

import java.util.Scanner;

public class Vista {

    Scanner sc = new Scanner(System.in);

    public int menu(){

        System.out.println("_______\n" +
                "       //  ||\\ \\\n" +
                " _____//___||_\\ \\___\n" +
                " )  _          _    \\\n" +
                " |_/ \\________/ \\___|\n" +
                "___\\_/________\\_/_____\n");

        System.out.println("-----------------------------");
        System.out.println("¡Bienvenido al concesionario!");
        System.out.println("-----------------------------");
        System.out.println("¿Qué desea hacer?");
        System.out.println("-----------------------------");
        System.out.println("1: Añadir coches al concesionario.");
        System.out.println("2: Mostrar los coches disponibles.");
        System.out.println("3: Buscar coches.");
        System.out.println("4: Registrar un nuevo cliente.");
        System.out.println("5: Registrar una venta, indica cliente(dni) y coche (matricula).");
        System.out.println("6: Listar ventas.");
        System.out.println("-----------------------------");

        int opcion = -1;

        while (true) {

            System.out.println("¿Que opción quieres escoger?");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion >= 1 && opcion<=7 ){
                break;
            }

            System.err.println("Introduce un opción válida: ");
        }

        return opcion - 1;

    }



}
