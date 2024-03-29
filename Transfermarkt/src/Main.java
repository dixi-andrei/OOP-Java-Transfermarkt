import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {

        ClubService clubService = new ClubServiceImpl();
        LeagueService leagueService = new LeagueServiceImpl();

        League league1 = new League("Superliga","Romania",1900,16);
        Club club1 = new Club("FC-Rapid",1923,new Stadium("Giulesti","Bucuresti",14000),new Coach("Cristiano","Bergodi",50,"Italia",20,"4-2-3-1"),league1);
        Club club2 = new Club("Universitatea Craiova",1948,new Stadium("Ion Oblemenco","Craiova",30000),new Coach("Sorin","Cartu",60,"Romania",30,"5-4-1"),league1);

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


    }
}