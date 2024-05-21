package dao;

import model.League;
import java.sql.*;
import java.util.*;
public class LeagueDAO {
    private Connection connection;

    public LeagueDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(League league) throws SQLException {
        String sql = "INSERT INTO League (leagueName, country, foundedYear, numberOfClubs) VALUES (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, league.getLeagueName());
            statement.setString(2, league.getLeagueCountry());
            statement.setInt(3, league.getFoundedYear());
            statement.setInt(4, league.getNumberOfClubs());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating league failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    league.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating league failed, no ID obtained.");
                }
            }
        }
    }

    public League getById(int id) throws SQLException {
        String sql = "SELECT * FROM League WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new League(resultSet.getString("leagueName"), resultSet.getString("country"), resultSet.getInt("foundedYear"), resultSet.getInt("numberOfClubs"));
                }
            }
        }
        return null;
    }

    public List<League> getAll() throws SQLException {
        List<League> leagues = new ArrayList<>();
        String sql = "SELECT * FROM League";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                leagues.add(new League(resultSet.getString("leagueName"), resultSet.getString("country"), resultSet.getInt("foundedYear"), resultSet.getInt("numberOfClubs")));
            }
        }
        return leagues;
    }

    public void update(League league) throws SQLException {
        String sql = "UPDATE League SET leagueName =?, country =?, foundedYear =?, numberOfClubs =? WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, league.getLeagueName());
            statement.setString(2, league.getLeagueCountry());
            statement.setInt(3, league.getFoundedYear());
            statement.setInt(4, league.getNumberOfClubs());
            statement.setInt(5, league.getId());
            statement.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM League WHERE id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
