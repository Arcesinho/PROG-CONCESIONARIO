package Modelo;

public class Clientes {

    //Lo mismo que comenté en coches pero con el teléfono

    private final String dni;
    private final String nombre;
    private final long telefono;

    public Clientes(String dni, String nombre, long telefono) {

        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }

    public long getTelefono() {
        return telefono;
    }


}