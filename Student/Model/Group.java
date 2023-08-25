package Student.Model;

import Student.Enum.GroupName;
import Student.Model.Student;

import java.util.Arrays;

public class Group {
    private int id;
    public static int idd;
    private GroupName name;
    private Student[]students;
    private int count;

    public Group(GroupName name, Student[] students, int count) {
        this.name = name;
        this.students = students;
        this.count = count;
        this.id = idd++;
    }

    public GroupName getName() {
        return name;
    }

    public void setName(GroupName name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group" +
                "name='" + name +
                ", students=" + Arrays.toString(students) +
                ", count=" + count;
    }
}
