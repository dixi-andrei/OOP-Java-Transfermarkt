package model;

public class Player extends Person{

    private static int counter =0;
    private int id;
    private String position;
    private int shirtNumber;
    private double value;
    private Club club;

    public Player() {
    }

    public Player(String lastName, String firstName, int age, String nationality, String position, int shirtNumber, double value) {
        super(lastName, firstName, age, nationality);
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.value = value;
    }

    public Player(String lastName, String firstName, int age, String nationality, String position, int shirtNumber, double value, Club club) {
        super(lastName, firstName, age, nationality);
        this.club = club;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.value = value;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public double getValue() {
        return value;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public void setValue(double value) {
        this.value = value;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return super.toString() + ", Position: " + position + ", Value: " + value;
    }


}
