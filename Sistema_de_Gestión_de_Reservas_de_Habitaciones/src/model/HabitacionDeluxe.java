/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class HabitacionDeluxe extends Habitacion {
    private boolean incluyeDesayuno;
    private double tarifaDesayuno;
    private int numeroNochesMinimas;

    public HabitacionDeluxe(String codHabitacion, double precioPorNoche, boolean incluyeDesayuno, double tarifaDesayuno, int numeroNochesMinimas) {
        super(codHabitacion, precioPorNoche);
        this.incluyeDesayuno = incluyeDesayuno;
        setTarifaDesayuno(tarifaDesayuno);
        setNumeroNochesMinimas(numeroNochesMinimas);
    }

    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    public double getTarifaDesayuno() {
        return tarifaDesayuno;
    }

    public void setTarifaDesayuno(double tarifaDesayuno) throws IllegalArgumentException {
        if ( tarifaDesayuno < 0 ) {
            throw new IllegalArgumentException("La tarifa del desayuno no puede ser negativa");
        }
        this.tarifaDesayuno = tarifaDesayuno;
    }

    public int getNumeroNochesMinimas() {
        return numeroNochesMinimas;
    }

    public void setNumeroNochesMinimas(int numeroNochesMinimas) throws IllegalArgumentException {
        if ( numeroNochesMinimas < 1 || numeroNochesMinimas > 7) {
            throw new IllegalArgumentException("El numero de noches minimas debe ser al menos 1 y menor a 7");
        }
        this.numeroNochesMinimas = numeroNochesMinimas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HabitacionDeluxe{");
        sb.append("codHabitacion=").append(codHabitacion);
        sb.append(", ocupada=").append(ocupada);
        sb.append(", precioPorNoche=").append(precioPorNoche);
        sb.append(", incluyeDesayuno=").append(incluyeDesayuno);
        sb.append(", tarifaDesayuno=").append(tarifaDesayuno);
        sb.append(", numeroNochesMinimas=").append(numeroNochesMinimas);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    @Override
    public double calcularPrecioEstadia(int dias){
        if ( dias < 1 ) {
            throw new IllegalArgumentException("No puede tener una estadia de menos de 1 dia");
        }
        
        double costo = precioPorNoche * dias;
        
        if (dias > 7) {
            costo -= (costo * (0.10));      
        } else if (dias < numeroNochesMinimas) {
            costo += (costo * (0.20));
        }
            
        if (incluyeDesayuno) {
            double costoDesayuno = tarifaDesayuno * dias;
            costo += costoDesayuno;
        }  

        return costo;
    }

    
    
    
}
