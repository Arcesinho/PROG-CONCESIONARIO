package Modelo;
import java.time.LocalDate;


/**
 * En este caso, en el modelo venta incorporamos la fecha, el vendedor,
 * de la clase vendedor, para registrar cual
 * de ellos realiza una venta
 */
public class Venta {
    private final int id;
    private final Clientes cliente;
    private final Coche coche;
    private final Vendedor vendedor; //
    private final LocalDate fecha;
    private final double precioVenta;


    public Coche getCoche() { return coche; }
    public double getPrecioVenta() { return precioVenta; }
    public Vendedor getVendedor() { return vendedor; }

    public Venta(int id, Clientes cliente, Coche coche, Vendedor vendedor, LocalDate fecha, double precioVenta) {
        this.id = id;
        this.cliente = cliente;
        this.coche = coche;
        this.vendedor = vendedor;
        this.fecha = fecha;
        this.precioVenta = precioVenta;
    }

    public String getInfo() {
        // Añadimos el vendedor a la info
        return "Venta " + id + " | " + fecha + " | Vendedor: " + vendedor.getNombre() +
                " | Cliente: " + cliente.getNombre() +
                " | Coche: " + coche.getMarca() + " | " + precioVenta + "€";
    }
}