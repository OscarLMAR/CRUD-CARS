package com.mycompany.CarCenterAplication.controller;

import com.mycompany.CarCenterAplication.dao.CarDao;
import com.mycompany.CarCenterAplication.domine.Car;
import java.sql.SQLException;
import java.util.List;

public class CarController {

    private CarDao carDao;

    public CarController() {
        carDao = new CarDao();

    }

    public List<Car> obtenerCarros() throws SQLException {
        return carDao.obtenerCarros();
    }

    public void crearCarro(Car car) throws SQLException {
        carDao.crearCarro(car);
    }

    public Car obtenerCar(int id) throws SQLException {
        return carDao.obtenerCarro(id);
    }

    public void actualizarCarro(int id, Car car) throws SQLException {
        carDao.actualizarCarro(id, car);
    }

    public void eliminarCarro(int id) throws SQLException {
        carDao.eliminarCarro(id);
    }
}
