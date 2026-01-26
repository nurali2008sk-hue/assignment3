package repository;

import utils.DatabaseConnection;
import exception.DatabaseOperationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalRepository {

    public void create(int customerId, int vehicleId, int days) {
        String sql =
                "INSERT INTO rentals(customer_id, vehicle_id, rental_days) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ps.setInt(2, vehicleId);
            ps.setInt(3, days);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseOperationException("Failed to create rental");
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM rentals WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseOperationException("Failed to delete rental");
        }
    }
}
