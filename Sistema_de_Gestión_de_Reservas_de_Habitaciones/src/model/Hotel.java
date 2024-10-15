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

    @Override
    public String toString() { 
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel{");
        sb.append("nombreHotel=").append(nombreHotel);
        for (Habitacion habitacion : habitaciones) {
            sb.append("\n");
            sb.append(habitacion.toString());
        }
        
        return sb.toString();
    }
    
    //mostrar dias reservados 
    
    public void agregarHabitacion (String codHabitacion, double precioPorNoche, boolean limpiezaIncluida, double costoLimpieza) throws HabitacionException {
        
        validarAgregarHabitacion(codHabitacion);
        
        Habitacion habitacion = new HabitacionEstandar(codHabitacion, precioPorNoche, limpiezaIncluida, costoLimpieza);
        habitaciones.add(habitacion);
    }
    
    public void agregarHabitacion (String codHabitacion, double precioPorNoche, boolean incluyeDesayuno, double tarifaDesayuno, int numeroNochesMinimas) throws HabitacionException {
        
        validarAgregarHabitacion(codHabitacion);
        
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
    
    public Habitacion validarHabitacion(String codigoHabitacion, boolean debeEstarOcupada) throws OcupacionException, HabitacionException {
        Habitacion habitacion = buscarHabitacion(codigoHabitacion);
        
        if (habitacion == null) {
            throw new HabitacionException("La habitacion con el codigo " + codigoHabitacion + " no existe");
        }
        
        if (debeEstarOcupada && !habitacion.isOcupada()) {
            throw new OcupacionException("La habitacion " + codigoHabitacion + " esta desocupada");
        } else if (!debeEstarOcupada && habitacion.isOcupada()) {
            throw new OcupacionException("La habitacion " + codigoHabitacion + " ya esta ocupada");
        }  
        return habitacion;
    }
    
    public void validarAgregarHabitacion(String codigoHabitacion) throws HabitacionException {
        if (buscarHabitacion(codigoHabitacion) != null ) {
            throw new HabitacionException("La habitacion con el codigo " + codigoHabitacion + " ya existe");
        }
    }
    
    public boolean reservarHabitacion (String codigoHabitacion, int dias) throws OcupacionException, HabitacionException {
        
        Habitacion habitacion = validarHabitacion(codigoHabitacion, false);
        
        if (habitacion instanceof HabitacionDeluxe && dias < ((HabitacionDeluxe) habitacion).getNumeroNochesMinimas()) {
            throw new OcupacionException("No se puede reservar " + dias + " dias, es menos del minimo");
        }
        
        habitacion.setOcupada(true);
        
        //podria crear un hashmap con los dias de reserva
        
        return true;
    }
    
    public boolean liberarHabitacion (String codigoHabitacion) throws OcupacionException, HabitacionException {
        
        Habitacion habitacion = validarHabitacion(codigoHabitacion, true);
        
        habitacion.setOcupada(false);
        
        return true;
    }
    
    public double calcularCostoEstadia(String codigoHabitacion, int dias) throws OcupacionException, HabitacionException {
    
        Habitacion habitacion = validarHabitacion(codigoHabitacion, true);
        
        double costo_total = habitacion.calcularPrecioEstadia(dias);
        
        return costo_total;
    }
}
