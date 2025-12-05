package Vista;

import java.util.Scanner;

public class Vista {

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

        int op = -1;

        while (true) {

            System.out.println("¿Que opción quieres escoger?");
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        }

    }



}
