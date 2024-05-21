package model;

public class Stadium {
    private String stadiumName;

    private int id;

    private static int counter =0;
    private String stadiumTown;
    private int capacity;

    public Stadium(String stadiumName, String stadiumTown, int capacity) {
        this.stadiumName = stadiumName;
        this.stadiumTown = stadiumTown;
        this.capacity = capacity;
    }

    public Stadium() {
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getStadiumTown() {
        return stadiumTown;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public void setStadiumTown(String stadiumTown) {
        this.stadiumTown = stadiumTown;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "stadiumName='" + stadiumName + '\'' +
                ", id=" + id +
                ", stadiumTown='" + stadiumTown + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
