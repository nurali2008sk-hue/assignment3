package repository;

import model.*;
import utils.DatabaseConnection;
import exception.DatabaseOperationException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {

    public void create(Vehicle vehicle) {
        String sql = "INSERT INTO vehicles(model, price_per_day, type) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, vehicle.getModel());
            ps.setDouble(2, vehicle.getPricePerDay());
            ps.setString(3, vehicle.getType());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseOperationException("Failed to create vehicle");
        }
    }

    public List<Vehicle> getAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String type = rs.getString("type");

                Vehicle v;
                if (type.equals("CAR")) {
                    v = new Car(
                            rs.getInt("id"),
                            rs.getString("model"),
                            rs.getDouble("price_per_day")
                    );
                } else {
                    v = new Truck(
                            rs.getInt("id"),
                            rs.getString("model"),
                            rs.getDouble("price_per_day")
                    );
                }

                vehicles.add(v);
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Failed to get vehicles");
        }

        return vehicles;
    }
}
