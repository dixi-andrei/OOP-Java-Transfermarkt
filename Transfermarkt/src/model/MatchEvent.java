package model;

public class MatchEvent {
    private Player player;
    private int minute;
    private Match match;

    public MatchEvent() {
    }

    public MatchEvent(Player player, int minute, Match match) {
        this.player = player;
        this.minute = minute;
        this.match = match;
    }

    public Player getPlayer() {
        return player;
    }

    public int getMinute() {
        return minute;
    }

    public Match getMatch() {
        return match;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
