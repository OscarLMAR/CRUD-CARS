package com.mycompany.CarCenterAplication.dao;

import com.mycompany.CarCenterAplication.domine.Car;
import com.mycompany.CarCenterAplication.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

    private static final String GET_CARS = "select * from carros";

    private static final String CREATE_CAR = "insert into carros (marca, modelo, "
            + "anho, color, transmision)\n" + "values(?, ?, ?, ?, ?);";

    private static final String GET_CAR_BY_ID = "select * from carros WHERE id = ?";

    private static final String UPDATE_CAR = "update carros set marca = ?, modelo = ?,"
            + " anho = ?, color = ?, transmision = ? where id = ?";

    private static final String DELETE_CAR = "delete from carros where Id = ?";

    public List<Car> obtenerCarros() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Car> Cars = new ArrayList<>();

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CARS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMarca(resultSet.getString("marca"));
                car.setModelo(resultSet.getString("modelo"));
                car.setAnho(resultSet.getString("anho"));
                car.setColor(resultSet.getString("color"));
                car.setTransmision(resultSet.getString("transmision"));
                Cars.add(car);

            }
            return Cars;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();

            }

        }

    }

    public void crearCarro(Car car) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_CAR);
            preparedStatement.setString(1, car.getMarca());
            preparedStatement.setString(2, car.getModelo());
            preparedStatement.setString(3, car.getAnho());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setString(5, car.getTransmision());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();

            }

        }

    }

    public Car obtenerCarro(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Car car = null;
        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(GET_CAR_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setMarca(resultSet.getString("marca"));
                car.setModelo(resultSet.getString("modelo"));
                car.setAnho(resultSet.getString("anho"));
                car.setTransmision(resultSet.getString("transmision"));
            }
            return car;
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {

                resultSet.close();
            }
        }

    }

    public void actualizarCarro(int id, Car car) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_CAR);
            preparedStatement.setString(1, car.getMarca());
            preparedStatement.setString(2, car.getModelo());
            preparedStatement.setString(3, car.getAnho());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setString(5, car.getTransmision());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } finally {

            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void eliminarCarro(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(DELETE_CAR);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
 


