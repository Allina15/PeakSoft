package Student.Model;


import java.util.Arrays;
import Student.Model.Student;
import Student.Model.Mentor;
import Student.Model.Group;

public class Peaksoft {
    private String name;
    private String address;
    private Mentor[]mentors;
    private Student[] students;
    private Group[]groups;

    public Peaksoft(String name, String address, Mentor[] mentors, Student[][]MyStudents, Group[]groups) {
        this.name = name;
        this.address = address;
        this.mentors = mentors;
        this.groups = groups;
        students = new Student[MyStudents.length * MyStudents[0].length];
        int index = 0;
        for (int i = 0; i < MyStudents.length; i++) {
            for (int j = 0; j < MyStudents[i].length; j++) {
                students[index] = MyStudents[i][j];
                index++;
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Mentor[] getMentors() {
        return mentors;
    }

    public void setMentors(Mentor[] mentors) {
        this.mentors = mentors;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Peaksoft" +
                "name='" + name +
                ", address='" + address +
                ", mentors=" + Arrays.toString(mentors) +
                ", students=" + Arrays.toString(students) +
                ", groups="+ Arrays.toString(groups);

    }
}
