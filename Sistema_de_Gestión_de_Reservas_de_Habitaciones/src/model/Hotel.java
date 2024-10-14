/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Hotel {
    private String nombreHotel;
    private List<Habitacion> habitaciones;

    public Hotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        this.habitaciones = new ArrayList<Habitacion>();
    }
    
    public void agregarHabitacion (String codHabitacion, double precioPorNoche, boolean limpiezaIncluida, double costoLimpieza) throws HabitacionException {
        
        if (buscarHabitacion(codHabitacion) != null ) {
            throw new HabitacionException("La habitacion con el codigo " + codHabitacion + " ya existe");
        }
        
        Habitacion habitacion = new HabitacionEstandar(codHabitacion, precioPorNoche, limpiezaIncluida, costoLimpieza);
        habitaciones.add(habitacion);
    }
    
    public void agregarHabitacion (String codHabitacion, double precioPorNoche, boolean incluyeDesayuno, double tarifaDesayuno, int numeroNochesMinimas) throws HabitacionException {
        
        if (buscarHabitacion(codHabitacion) != null ) {
            throw new HabitacionException("La habitacion con el codigo " + codHabitacion + " ya existe");
        }
        
        Habitacion habitacion = new HabitacionDeluxe(codHabitacion, precioPorNoche, incluyeDesayuno, tarifaDesayuno, numeroNochesMinimas);
        habitaciones.add(habitacion);
    }
    
    public Habitacion buscarHabitacion(String codigoHabitacion) {
        Habitacion retorno = null;
        
        for (Habitacion h: habitaciones) {
            if (codigoHabitacion.equals(h.getCodHabitacion())) {
                retorno = h;
                break;
            }  
        }
        
        return retorno;
    }
    
    public boolean reservarHabitacion (String codigoHabitacion) throws OcupacionException, HabitacionException {
        
        Habitacion habitacion = buscarHabitacion(codigoHabitacion);
        
        if (habitacion == null) {
            throw new HabitacionException("La habitacion con el codigo " + codigoHabitacion + " no existe");
        }
        
        if (habitacion.isOcupada()) {
            throw new OcupacionException("La habitacion " + codigoHabitacion + " ya esta ocupada");
        }
        
        habitacion.setOcupada(true);
        
        //podria llamar a calcular el costo de la estadia?
        
        return true;
    }
    
    public boolean liberarHabitacion (String codigoHabitacion) throws OcupacionException, HabitacionException {
        
        Habitacion habitacion = buscarHabitacion(codigoHabitacion);
        
        if (habitacion == null) {
            throw new HabitacionException("La habitacion con el codigo " + codigoHabitacion + " no existe");
        }
        
        if (!habitacion.isOcupada()) {
            throw new OcupacionException("La habitacion " + codigoHabitacion + " esta desocupada");
        }
        
        habitacion.setOcupada(false);
        
        return true;
    }
    
    public double calcularCostoEstadia(String codigoHabitacion, int dias) throws OcupacionException, HabitacionException {
    
        Habitacion habitacion = buscarHabitacion(codigoHabitacion);
        
        if (habitacion == null) {
            throw new HabitacionException("La habitacion con el codigo " + codigoHabitacion + " no existe");
        }
        
        if (!habitacion.isOcupada()) {
            throw new OcupacionException("La habitacion " + codigoHabitacion + " esta desocupada");
        }
        
        double costo_total = habitacion.calcularPrecioEstadia(dias);
        
        return costo_total;
    }
}
