import dao.*;
import database.DatabaseConnection;
import model.*;
import service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ClubService clubService = new ClubServiceImpl();
        LeagueService leagueService = new LeagueServiceImpl();

        Stadium stadium1 = new Stadium("Giulesti","Bucuresti",14000);
        Stadium stadium2 = new Stadium("Ion Oblemenco","Craiova",30000);

        Coach coach1 = new Coach("Cristiano","Bergodi",50,"Italia",20,"4-2-3-1");
        Coach coach2 = new Coach("Sorin","Cartu",60,"Romania",30,"5-4-1");

        League league1 = new League("Superliga","Romania",1900,16);
        Club club1 = new Club("FC-Rapid",1923,stadium1,coach1,league1);
        Club club2 = new Club("Universitatea Craiova",1948,stadium2,coach2,league1);

        Player player1 = new Player("Albion", "Rhamani", 23, "Kosovo", "CF",9,8.0,club1);
        Player player2 = new Player("Borisav", "Burmaz", 22, "Serbia", "CF",21,3.0,club1);
        Player player3 = new Player("Cristian", "Sapunaru", 39, "Romania", "CB",23,0.5,club1);
        Player player4 = new Player("Alexandru", "Mitrita", 29, "Romania", "LW",28,5.0,club2);
        Player player5 = new Player("Vladimir", "Screciu", 24, "Romania", "CDM",11,3.0,club2);

        clubService.addPlayerToClub(player1,club1);
        clubService.addPlayerToClub(player2,club1);
        clubService.addPlayerToClub(player3,club1);

        clubService.addPlayerToClub(player4,club2);
        clubService.addPlayerToClub(player5,club2);

        leagueService.addClubToLeague(club1,league1);
        leagueService.addClubToLeague(club2,league1);

        clubService.getClubPlayersSortedByValue(club1,true);
        clubService.calculateClubValue(club1);
        clubService.calculateClubValue(club2);
        System.out.println();
        clubService.getClubPlayers(club1);

        leagueService.getClubsSortedByValue(league1,false);
        leagueService.calculateValueOfLeague(league1);
        System.out.println();
        leagueService.getLeagueClubs(league1);

        System.out.println();
        clubService.removePlayerFromClub(new Player(),club1);
        leagueService.removeClubFromLeague(club2,league1);


        Connection connection = null;
        try {

            connection = DatabaseConnection.getConnection();
            System.out.println("Conexiunea la baza de date PostgreSQL a fost realizata cu succes.");

            StadiumDAO stadiumDAO = new StadiumDAO(connection);
            LeagueDAO leagueDAO = new LeagueDAO(connection);
            ClubDAO clubDAO = new ClubDAO(connection);
            CoachDAO coachDAO = new CoachDAO(connection);
            PlayerDAO playerDAO = new PlayerDAO(connection);

            stadiumDAO.create(stadium1);
            stadiumDAO.create(stadium2);

            leagueDAO.create(league1);

            clubDAO.create(club1);
            clubDAO.create(club2);

            coachDAO.create(coach1);
            coachDAO.create(coach2);

            playerDAO.create(player1);
            playerDAO.create(player2);
            playerDAO.create(player3);
            playerDAO.create(player4);
            playerDAO.create(player5);

        } catch (SQLException e) {
            System.out.println("Conexiunea la baza de date PostgreSQL a esuat!");
            e.printStackTrace();
        } finally {

            DatabaseConnection.closeConnection(connection);
        }



  }
    public void deleteAllRows(String tableName) throws SQLException {
        String deleteQuery = "DELETE FROM " + tableName;
        Connection connection = DatabaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}

