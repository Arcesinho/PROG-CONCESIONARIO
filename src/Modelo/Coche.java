package Modelo;

public class Coche {

    private String marca;
    private String modelo;
    private String matricula;
    private int precio;
    private int ano;
    private double kilometros;

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

    //Setters

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
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
