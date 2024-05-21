package model;

public class Coach extends Person{

    private static int counter=0;

    private int id;
    private Club club;
    private int experience;
    private String preferredFormation;

    public Coach() {
    }

    public Coach(String lastName, String firstName, int age, String nationality, int experience, String preferredFormation) {
        super(lastName, firstName, age, nationality);
        this.experience = experience;
        this.preferredFormation = preferredFormation;
    }

    public Coach(String lastName, String firstName, int age, String nationality, Club club, int experience, String preferredFormation) {
        super(lastName, firstName, age, nationality);
        this.club = club;
        this.experience = experience;
        this.preferredFormation = preferredFormation;
    }

    public Coach(String lastName, String firstName, int age, String nationality, int experience, String preferredFormation, Club club) {
    }

    public Club getClub() {
        return club;
    }

    public int getExperience() {
        return experience;
    }

    public String getPreferredFormation() {
        return preferredFormation;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPreferredFormation(String preferredFormation) {
        this.preferredFormation = preferredFormation;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return super.toString() + ", PreferredFormation " + preferredFormation + ", Experience: " +experience + ", Club:" + club.getClubName();
    }
}
