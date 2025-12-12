package Modelo;

public class Coche {

    //Sé que se puede eliminar los kilometros e inclinarlos en el constructor pero quizás en un futuro se necesitaría

    private final String marca;
    private final String modelo;
    private final String matricula;
    private final int precio;
    private final int ano;
    private final double kilometros;

    //Getters


    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPrecio() {
        return precio;
    }

    public int getAno() {
        return ano;
    }

    public double getKilometros() {
        return kilometros;
    }

    public Coche(String marca, String modelo, String matricula, int precio, int ano, double kilometros) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
        this.ano = ano;
        this.kilometros = kilometros;
    }
}
