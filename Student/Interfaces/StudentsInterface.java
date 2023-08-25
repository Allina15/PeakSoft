package Student.Interfaces;

import Student.Model.Student;

public interface StudentsInterface {
    Student[][] getAllStudents();
    Student searchStudentByName(String name);
    Student[]sortByStudentName(String ascDesc);
    void deleteStudentById(int id);
    String createStudent(Student student);
    Student updateById(int id, Student student);
    Student findById(int id);

}
