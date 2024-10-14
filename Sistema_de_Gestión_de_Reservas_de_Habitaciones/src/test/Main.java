/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import model.HabitacionException;
import model.Hotel;
import model.OcupacionException;

/**
 *
 * @author User
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Hotel hotel = new Hotel("Madison");
            
            System.out.println("1-1");
            
            hotel.agregarHabitacion("10001", 80.0, false, 0.0);
            
            System.out.println("1-2");
            
            hotel.agregarHabitacion("10002", 90.0, true, 15.0);
            System.out.println(hotel.buscarHabitacion("10002"));
            
            System.out.println("1-3");
            
            hotel.reservarHabitacion("10001"); // reservo sino salta la excepcion de que no esta ocupada
            System.out.println(hotel.calcularCostoEstadia("10001",3));
            
            System.out.println("1-4");
            
            hotel.reservarHabitacion("10002"); // reservo sino salta la excepcion de que no esta ocupada
            System.out.println(hotel.calcularCostoEstadia("10002",4));
            
            System.out.println("2-1");
            
            //hotel.agregarHabitacion("2001", 200.0, false, 25.0, 2); debe ser 5
            hotel.agregarHabitacion("20001", 200.0, true, 25.0, 4);
            
            System.out.println("2-2");
            
            hotel.agregarHabitacion("20002", 250.0, false, 30.0, 1);
            System.out.println(hotel.buscarHabitacion("20002"));
            
            System.out.println("2-3");
            
            hotel.reservarHabitacion("20001"); // reservo sino salta la excepcion de que no esta ocupada
            System.out.println(hotel.calcularCostoEstadia("20001", 8));
            
            System.out.println("2-4");
            
            System.out.println(hotel.calcularCostoEstadia("20001", 5));
            
            System.out.println("2-5");
            
            System.out.println(hotel.calcularCostoEstadia("20001", 3));
            
            System.out.println("3-1");
            
            //reservada anteriormente 
            System.out.println(hotel.buscarHabitacion("10002"));
            hotel.liberarHabitacion("10002");
            System.out.println(hotel.buscarHabitacion("10002"));
            
            System.out.println("3-2");
            
            //hotel.reservarHabitacion("10001");
            
            System.out.println("3-3");
            
            hotel.agregarHabitacion("20003", 200.0, true, 10.0, 4);
            hotel.reservarHabitacion("20003");
            System.out.println(hotel.calcularCostoEstadia("20003", 5));
            
            System.out.println("3-4");
            
            hotel.agregarHabitacion("20003", 200.0, true, 10.0, 4);
            hotel.reservarHabitacion("20003");
            System.out.println(hotel.calcularCostoEstadia("20003", 5));
            
        } catch (HabitacionException e){
            System.out.println("Error " + e.getMessage());
        } catch (OcupacionException e){
            System.out.println("Error " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
}
