package Student.Model;

import Student.Enum.Gender;

public class Mentor {
    private int id;
    public static int idd;
    private String name;
    private Gender gender;
    private String email;
    Group group;

    public Mentor(String name, Gender gender, String email, Group group) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Mentor" +
                ", id=" + id+
                ", name='" + name +
                ", gender='" + gender +
                ", email='" + email +
                ", group=" + group;
    }
}
