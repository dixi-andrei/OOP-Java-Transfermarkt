package service;
import model.*;
import java.util.*;

public interface LeagueService {
    public void addClubToLeague(Club club,League league);
    public void removeClubFromLeague(Club club,League league);
    public double calculateValueOfLeague(League league);
    public List<Club> getLeagueClubs(League league);
    List<Club> getClubsSortedByValue(League league,boolean ascending);
}
