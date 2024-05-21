package dao;

import model.Stadium;
import java.sql.*;
import java.util.*;
public class StadiumDAO {
    private Connection connection;

    public StadiumDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Stadium stadium) throws SQLException {
        String sql = "INSERT INTO Stadium (stadiumName, stadiumTown, capacity) VALUES (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, stadium.getStadiumName());
            statement.setString(2, stadium.getStadiumTown());
            statement.setInt(3, stadium.getCapacity());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating stadium failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    stadium.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating stadium failed, no ID obtained.");
                }
            }
        }
    }


    public Stadium getById(int id) throws SQLException {
        String sql = "SELECT * FROM Stadium WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Stadium(resultSet.getString("stadiumName"), resultSet.getString("stadiumTown"), resultSet.getInt("capacity"));
                }
            }
        }
        return null;
    }

    public List<Stadium> getAll() throws SQLException {
        List<Stadium> stadiums = new ArrayList<>();
        String sql = "SELECT * FROM Stadium";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                stadiums.add(new Stadium(resultSet.getString("stadiumName"), resultSet.getString("stadiumTown"), resultSet.getInt("capacity")));
            }
        }
        return stadiums;
    }

    public void update(Stadium stadium) throws SQLException {
        String sql = "UPDATE Stadium SET stadiumName =?, stadiumTown =?, capacity =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, stadium.getStadiumName());
            statement.setString(2, stadium.getStadiumTown());
            statement.setInt(3, stadium.getCapacity());
            statement.setInt(4, stadium.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Stadium WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
