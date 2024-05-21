package dao;

import model.Club;
import model.*;
import java.sql.*;
import java.util.*;
public class ClubDAO {
    private Connection connection;

    public ClubDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Club club) throws SQLException {
        String sql = "INSERT INTO club (clubName, foundedYear, stadium_id, league_id, teamValue, numberOfPlayers) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, club.getClubName());
            statement.setInt(2, club.getFoundedYear());
            statement.setInt(3, club.getStadium().getId()); // Presupunând că ai o metodă getStadium() în model.Club
            statement.setInt(4, club.getLeague().getId()); // Presupunând că ai o metodă getLeague() în model.Club
            statement.setDouble(5, club.getTeamValue());
            statement.setInt(6, club.getNumberOfPlayers());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating club failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    club.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating club failed, no ID obtained.");
                }
            }
        }
    }

    public Club getById(int id) throws SQLException {
        String sql = "SELECT * FROM club WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Club(
                            resultSet.getString("clubName"),
                            resultSet.getInt("foundedYear"),
                            getStadiumById(resultSet.getInt("stadium_id")),
                            getLeagueById(resultSet.getInt("league_id")),
                            resultSet.getDouble("teamValue"),
                            resultSet.getInt("numberOfPlayers")
                    );
                }
            }
        }
        return null;
    }

    public List<Club> getAll() throws SQLException {
        List<Club> clubs = new ArrayList<>();
        String sql = "SELECT * FROM club";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                clubs.add(new Club(
                        resultSet.getString("clubName"),
                        resultSet.getInt("foundedYear"),
                        getStadiumById(resultSet.getInt("stadium_id")),
                        getLeagueById(resultSet.getInt("league_id")),
                        resultSet.getDouble("teamValue"),
                        resultSet.getInt("numberOfPlayers")
                ));
            }
        }
        return clubs;
    }

    public void update(Club club) throws SQLException {
        String sql = "UPDATE club SET clubName =?, foundedYear =?, stadium_id =?, league_id =?, teamValue =?, numberOfPlayers =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, club.getClubName());
            statement.setInt(2, club.getFoundedYear());
            statement.setInt(3, club.getStadium().getId());
            statement.setInt(4, club.getLeague().getId());
            statement.setDouble(5, club.getTeamValue());
            statement.setInt(6, club.getNumberOfPlayers());
            statement.setInt(7, club.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM club WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private Stadium getStadiumById(int stadiumId) throws SQLException {
        // Implementează logica pentru a obține stadionul asociat unui club
        // Acest exemplu este simplificat și trebuie adaptat la structura ta de date
        return null; // Să returneze stadionul asociat sau null dacă nu există
    }

    private League getLeagueById(int leagueId) throws SQLException {
        // Implementează logica pentru a obține liga asociată unui club
        // Acest exemplu este simplificat și trebuie adaptat la structura ta de date
        return null; // Să returneze liga asociată sau null dacă nu există
    }
}
