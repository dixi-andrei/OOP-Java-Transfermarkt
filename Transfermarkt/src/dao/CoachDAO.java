package dao;

import model.Coach;
import model.*;
import java.sql.*;
import java.util.*;

public class CoachDAO {
    private Connection connection;

    public CoachDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Coach coach) throws SQLException {
        String sql = "INSERT INTO Coach (lastName, firstName, age, nationality, experience, preferredFormation, club_id) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coach.getLastName());
            statement.setString(2, coach.getFirstName());
            statement.setInt(3, coach.getAge());
            statement.setString(4, coach.getNationality());
            statement.setInt(5, coach.getExperience());
            statement.setString(6, coach.getPreferredFormation());

            if (coach.getClub() != null) {
                statement.setInt(7, coach.getClub().getId());
            } else {
                statement.setNull(7, Types.INTEGER);
            }

            statement.executeUpdate();
        }
    }

    public List<Coach> getAll() throws SQLException {
        List<Coach> coaches = new ArrayList<>();
        String sql = "SELECT * FROM Coach";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Club club = getClubById(resultSet.getInt("club_id"));
                coaches.add(new Coach(
                        resultSet.getString("lastName"),
                        resultSet.getString("firstName"),
                        resultSet.getInt("age"),
                        resultSet.getString("nationality"),
                        resultSet.getInt("experience"),
                        resultSet.getString("preferredFormation"),
                        club
                ));
            }
        }
        return coaches;
    }

    public void update(Coach coach) throws SQLException {
        String sql = "UPDATE Coach SET lastName =?, firstName =?, age =?, nationality =?, experience =?, preferredFormation =?, club_id =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, coach.getLastName());
            statement.setString(2, coach.getFirstName());
            statement.setInt(3, coach.getAge());
            statement.setString(4, coach.getNationality());
            statement.setInt(5, coach.getExperience());
            statement.setString(6, coach.getPreferredFormation());
            statement.setInt(7, coach.getClub().getId());
            statement.setInt(8, coach.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Coach WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private Club getClubById(int clubId) throws SQLException {
        // Implementează logica pentru a obține clubul asociat unui antrenor
        // Acest exemplu este simplificat și trebuie adaptat la structura ta de date
        return null; // Să returneze clubul asociat sau null dacă nu există
    }
}

