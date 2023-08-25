package Student.Model;

import Student.Enum.Gender;

public class Student {
    private int id;
    private static int idd;
    private String name;
    private Gender gender;
    private String email;

    public Student(String name, Gender gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.id=idd++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
