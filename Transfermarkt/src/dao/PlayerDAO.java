package dao;

import model.Player;
import model.Club;
import java.sql.*;
import java.util.*;

public class PlayerDAO {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Player player) throws SQLException {
        String sql = "INSERT INTO Player (lastName, firstName, age, nationality, position, shirtNumber, value, club_id) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, player.getLastName());
            statement.setString(2, player.getFirstName());
            statement.setInt(3, player.getAge());
            statement.setString(4, player.getNationality());
            statement.setString(5, player.getPosition());
            statement.setInt(6, player.getShirtNumber());
            statement.setDouble(7, player.getValue());
            statement.setInt(8, player.getClub().getId());
            statement.executeUpdate();
        }
    }

    public Player getById(int id) throws SQLException {
        String sql = "SELECT * FROM Player WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int playerId = resultSet.getInt("id");
                    String lastName = resultSet.getString("lastName");
                    String firstName = resultSet.getString("firstName");
                    int age = resultSet.getInt("age");
                    String nationality = resultSet.getString("nationality");
                    String position = resultSet.getString("position");
                    int shirtNumber = resultSet.getInt("shirtNumber");
                    double value = resultSet.getDouble("value");
                    int clubId = resultSet.getInt("club_id");

                    Club club = getClubById(clubId);
                    return new Player(lastName, firstName, age, nationality, position, shirtNumber, value, club);
                }
            }
        }
        return null;
    }

    public List<Player> getAll() throws SQLException {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM Player";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int playerId = resultSet.getInt("id");
                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                int age = resultSet.getInt("age");
                String nationality = resultSet.getString("nationality");
                String position = resultSet.getString("position");
                int shirtNumber = resultSet.getInt("shirtNumber");
                double value = resultSet.getDouble("value");
                int clubId = resultSet.getInt("club_id");

                Club club = getClubById(clubId);
                players.add(new Player( lastName, firstName, age, nationality, position, shirtNumber, value, club));
            }
        }
        return players;
    }

    public void update(Player player) throws SQLException {
        String sql = "UPDATE Player SET lastName =?, firstName =?, age =?, nationality =?, position =?, shirtNumber =?, value =?, club_id =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, player.getLastName());
            statement.setString(2, player.getFirstName());
            statement.setInt(3, player.getAge());
            statement.setString(4, player.getNationality());
            statement.setString(5, player.getPosition());
            statement.setInt(6, player.getShirtNumber());
            statement.setDouble(7, player.getValue());
            statement.setInt(8, player.getClub().getId());
            statement.setInt(9, player.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Player WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private Club getClubById(int clubId) throws SQLException {
        // Implementează logica pentru a obține clubul asociat unui jucător
        // Acest exemplu este simplificat și trebuie adaptat la structura ta de date
        return null; // Să returneze clubul asociat sau null dacă nu există
    }
}
