/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public abstract class Habitacion {
    protected String codHabitacion;
    protected boolean ocupada;
    protected double precioPorNoche;

    public Habitacion(String codHabitacion, double precioPorNoche) {
        setCodHabitacion(codHabitacion); //preguntar si es necesario poner setters y getters en todos
        this.ocupada = false;
        setPrecioPorNoche(precioPorNoche);
    }

    public String getCodHabitacion() {
        return codHabitacion;
    }

    public void setCodHabitacion(String codHabitacion) throws IllegalArgumentException {
        if (codHabitacion.length()!= 5) {
            throw new IllegalArgumentException("Los caracteres ser exactamente 5");
        }
        this.codHabitacion = codHabitacion;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        if (precioPorNoche < 1) {
            throw new IllegalArgumentException("el precio por noche debe ser mayor a 1");
        }
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion{");
        sb.append("codHabitacion=").append(codHabitacion);
        sb.append(", ocupada=").append(ocupada);
        sb.append(", precioPorNoche=").append(precioPorNoche);
        sb.append('}');
        return sb.toString();
    }
    
    
    public abstract double calcularPrecioEstadia(int dias) throws IllegalArgumentException;
}
