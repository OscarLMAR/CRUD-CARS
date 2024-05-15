

package com.mycompany.CarCenterAplication.presentation;

import com.mycompany.CarCenterAplication.controller.CarController;
import com.mycompany.CarCenterAplication.domine.Car;
import java.sql.SQLException;
import java.util.List;


public class CarCenterAplication {
    
    public static void obtenerCarros(CarController carController){
        try {
            List<Car> cars = carController.obtenerCarros();
            if(cars.isEmpty()){
                System.out.println("No hay carros");
            } else {
                cars.forEach(car -> {
                    System.out.println("Id:" + car.getId());
                    System.out.println("Marca:" + car.getMarca());
                    System.out.println("Modelo:" + car.getModelo());
                    System.out.println("Anho:" + car.getAnho());
                    System.out.println("Color" + car.getColor());
                    System.out.println("Trasnmision" + car.getTransmision());
                    System.out.println("----------------------------------");
                });
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        CarController carController = new CarController();
        obtenerCarros(carController);
    }
}
