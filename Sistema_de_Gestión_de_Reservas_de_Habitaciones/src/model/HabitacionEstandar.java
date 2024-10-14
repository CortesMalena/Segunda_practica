/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class HabitacionEstandar extends Habitacion {
    private boolean limpiezaIncluida;
    private double costoLimpieza;

    public HabitacionEstandar(String codHabitacion, double precioPorNoche, boolean limpiezaIncluida, double costoLimpieza) {
        super(codHabitacion, precioPorNoche);
        this.limpiezaIncluida = limpiezaIncluida;
        setCostoLimpieza(costoLimpieza);
    }

    public boolean isLimpiezaIncluida() {
        return limpiezaIncluida;
    }

    public void setLimpiezaIncluida(boolean limpiezaIncluida) {
        this.limpiezaIncluida = limpiezaIncluida;
    }

    public double getCostoLimpieza() {
        return costoLimpieza;
    }

    public void setCostoLimpieza(double costoLimpieza) throws IllegalArgumentException {
        if (costoLimpieza < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo");
        }
        this.costoLimpieza = costoLimpieza;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HabitacionEstandar{");
        sb.append("codHabitacion=").append(codHabitacion);
        sb.append(", ocupada=").append(ocupada);
        sb.append(", precioPorNoche=").append(precioPorNoche);
        sb.append(", limpiezaIncluida=").append(limpiezaIncluida);
        sb.append(", costoLimpieza=").append(costoLimpieza);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    @Override
    public double calcularPrecioEstadia(int dias){
        if ( dias < 1 ) {
            throw new IllegalArgumentException("No puede tener una estadia de menos de 1 dia");
        }
        
        double costo = precioPorNoche * dias;
        
        if (limpiezaIncluida) {
            costo += costoLimpieza;
        }
        
        return costo;
    }
}
