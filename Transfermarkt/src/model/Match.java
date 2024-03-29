package model;
import java.util.*;
public class Match {
    private Club homeClub;
    private Club awayClub;
    private int homeTeamScore;
    private int awayTeamScore;
    private Stadium stadium;
    private Map<Goal,Assist> goalAssist = new HashMap<Goal,Assist>();
    public Match() {
    }

    public Match(Club homeClub, Club awayClub, int homeTeamScore, int awayTeamScore, Stadium stadium) {
        this.homeClub = homeClub;
        this.awayClub = awayClub;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.stadium = stadium;
        this.goalAssist = new HashMap<>();
    }

    public void addGoalAssistPair(Goal goal, Assist assist) {
        goalAssist.put(goal, assist);
    }
    public Map<Goal, Assist> getGoalAssistMap() {
        return goalAssist;
    }

    public Club getHomeClub() {
        return homeClub;
    }

    public Club getAwayClub() {
        return awayClub;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setHomeClub(Club homeClub) {
        this.homeClub = homeClub;
    }

    public void setAwayClub(Club awayClub) {
        this.awayClub = awayClub;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
