package service;
import model.Club;
import model.League;
import service.LeagueService;
import java.util.*;

public class LeagueServiceImpl implements LeagueService{

    @Override
    public void addClubToLeague(Club club, League league) {
        if(!league.getClubs().contains(club)&&league.getNumberOfClubs()<=league.getMaxNumberOfClubs()){
            league.addClub(club);
            System.out.println("The club " + club.getClubName() + " has been successfully added to the league.");
        }else{
            System.out.println("The club " + club.getClubName() + " was already part of the league!");

        }
    }

    @Override
    public void removeClubFromLeague(Club club, League league) {
        if(!league.getClubs().contains(club)){
            System.out.println("The club " + club.getClubName() + " was not part of the league!");
        }else{
            league.removeClub(club);
            System.out.println("The club " + club.getClubName() + " has been successfully removed from the league.");
        }
    }

    @Override
    public double calculateValueOfLeague(League league) {
        double sum = 0.0;
        for(Club club : league.getClubs()){
            sum += club.getTeamValue();
        }
        league.setLeagueValue(sum);
        return sum;
    }

    @Override
    public List<Club> getLeagueClubs(League league) {
        List<Club> clubs = league.getClubs();
        System.out.println(league.toString());
        for(Club club :clubs){
            System.out.println(club.toString());
        }
        return clubs;
    }

    @Override
    public List<Club> getClubsSortedByValue(League league, boolean ascending) {
        List<Club> clubs = league.getClubs();

        if(ascending){
            clubs.sort(Comparator.comparingDouble(Club::getTeamValue));
        }else{
            clubs.sort(Comparator.comparingDouble(Club::getTeamValue).reversed());
        }

        return clubs;
    }
}
