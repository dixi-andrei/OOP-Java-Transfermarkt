package model;
import java.util.ArrayList;
import java.util.List;
public class League {
    private String leagueName;
    private String leagueCountry;
    private int foundedYear;
    private int numberOfClubs = 0;
    private int maxNumberOfClubs;

    private double leagueValue;
    private List<Club> clubs;

    public League() {
    }

    public League(String leagueName, String leagueCountry, int foundedYear, int maxNumberOfClubs) {
        this.leagueName = leagueName;
        this.leagueCountry = leagueCountry;
        this.foundedYear = foundedYear;
        this.maxNumberOfClubs = maxNumberOfClubs;
        this.clubs = new ArrayList<>(maxNumberOfClubs);
    }

    public void addClub(Club club){
        clubs.add(club);
        this.numberOfClubs++;
    }
    public void removeClub(Club club){
        clubs.remove(club);
        this.numberOfClubs--;
    }

    public int getMaxNumberOfClubs() {
        return maxNumberOfClubs;
    }

    public List<Club> getClubs() {
        return clubs;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getLeagueCountry() {
        return leagueCountry;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public int getNumberOfClubs() {
        return numberOfClubs;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setLeagueCountry(String leagueCountry) {
        this.leagueCountry = leagueCountry;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public void setLeagueValue(double leagueValue) {
        this.leagueValue = leagueValue;
    }

    @Override
    public String toString(){
        return "League name: " + leagueName + ", League value: " +leagueValue;
    }
}
