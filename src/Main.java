import controller.CarRentalController;
import exception.DatabaseOperationException;
import model.Customer;
import model.Vehicle;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CarRentalController controller = new CarRentalController();
        controller.start();

    }



    }




