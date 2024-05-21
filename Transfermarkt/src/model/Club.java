package model;

import java.util.ArrayList;
import java.util.List;
public class Club {

    private static int counter=0;

    private int id;
    private String clubName;
    private int foundedYear;
    private Stadium stadium;
    private Coach coach;
    private League league;
    private double teamValue = 0.0;
    private int numberOfPlayers =0;
    private List<Player> players;

    public Club() {
    }

    public Club(String name, int foundedYear, Stadium stadium, Coach coach, League league) {
        this.clubName = name;
        this.foundedYear = foundedYear;
        this.stadium = stadium;
        this.coach = coach;
        this.league = league;
        this.players = new ArrayList<>();
    }

    public Club(String clubName, int foundedYear, Stadium stadiumId, League leagueId, double teamValue, int numberOfPlayers) {
    }

    public Club(int id, String clubName, int foundedYear, Stadium stadium, League league, double teamValue, int numberOfPlayers) {
    }

    public void addPlayer(Player player){
        players.add(player);
        numberOfPlayers++;
    }

    public void removePlayer(Player player){
        players.remove(player);
        numberOfPlayers--;
    }

    public String getClubName() {
        return clubName;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public Coach getCoach() {
        return coach;
    }

    public League getLeague() {
        return league;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public double getTeamValue() {
        return teamValue;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public void setTeamValue(double teamValue) {
        this.teamValue = teamValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Club name: " + clubName + ", Club value: " + teamValue;
    }
}
