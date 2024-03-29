package model;

public class Transfer {
    private Player player;
    private Club fromClub;
    private Club toClub;
    private double transferFee;

    public Transfer() {
    }

    public Transfer(Player player, Club fromClub, Club toClub, double transferFee) {
        this.player = player;
        this.fromClub = fromClub;
        this.toClub = toClub;
        this.transferFee = transferFee;
    }

    public Player getPlayer() {
        return player;
    }

    public Club getFromClub() {
        return fromClub;
    }

    public Club getToClub() {
        return toClub;
    }

    public double getTransferFee() {
        return transferFee;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setFromClub(Club fromClub) {
        this.fromClub = fromClub;
    }

    public void setToClub(Club toClub) {
        this.toClub = toClub;
    }

    public void setTransferFee(double transferFee) {
        this.transferFee = transferFee;
    }
}
