package model;

public class Person {
    private String lastName;
    private String firstName;
    private int age;
    private String nationality;


    public Person() {
    }

    public Person(String lastName, String firstName, int age, String nationality) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.nationality = nationality;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", Age: " + age + ", Nationality: " + nationality;
    }
}
