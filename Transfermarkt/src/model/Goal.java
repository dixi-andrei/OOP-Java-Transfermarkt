package model;

public class Goal extends MatchEvent {
    private String type;

    public Goal(Player player, int minute, Match match, String type) {
        super(player, minute, match);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
