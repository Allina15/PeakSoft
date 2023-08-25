package Student.Sservices;

import Student.Interfaces.StudentsInterface;
import Student.Model.Student;

import java.util.Arrays;

public class StudentService implements StudentsInterface {
    private MentorsService mentorsService;

    public StudentService(MentorsService mentorsService) {
        this.mentorsService = mentorsService;
    }

    public MentorsService getMentorsService() {
        return mentorsService;
    }

    public void setMentorsService(MentorsService mentorsService) {
        this.mentorsService = mentorsService;
    }

    @Override
    public Student[] []getAllStudents() {
        return new Student[][]{mentorsService.getGroupServise().getPeaksoft().getStudents()};
    }

    @Override
    public Student searchStudentByName(String name) {
        for (int i = 0; i < mentorsService.getGroupServise().getPeaksoft().getStudents().length; i++) {
                if (mentorsService.getGroupServise().getPeaksoft().getStudents()[i].getName().equalsIgnoreCase(name)) {
                    return mentorsService.getGroupServise().getPeaksoft().getStudents()[i];
                }
            }
        return null;
    }

    @Override
    public Student[] sortByStudentName(String ascDesc) {
        return new Student[0];
    }

    @Override
    public void deleteStudentById(int id) {
        boolean found = false;
    Student[]oldStudents = mentorsService.getGroupServise().getPeaksoft().getStudents();
    Student[]newStudents = Arrays.copyOf(oldStudents,oldStudents.length-1);
        for (int i = 0; i < oldStudents.length-1; i++) {
            if (!found && oldStudents[i].getId()!=id){
                newStudents[i]=oldStudents[i];
            }else {
                found=true;
                }
            if (found){
                newStudents[i]=oldStudents[i+1];
            }
            }
        mentorsService.getGroupServise().getPeaksoft().setStudents(newStudents);
        System.out.println(Arrays.toString(newStudents));
    }

    @Override
    public String createStudent(Student student) {
        Student[]oldStudents = mentorsService.getGroupServise().getPeaksoft().getStudents();
        for (int i = 0; i < oldStudents.length-1; i++) {
            if (oldStudents[i].getId()==student.getId()){
                return "this student have";
            }
            Student[]newStudents = Arrays.copyOf(oldStudents,oldStudents.length+1);
            newStudents[i]=oldStudents[i];
            newStudents[oldStudents.length]=student;
            mentorsService.getGroupServise().getPeaksoft().setStudents(newStudents);
            mentorsService.getGroupServise().getPeaksoft().getStudents()[i].setId(i);
            return "new students"+ Arrays.toString(mentorsService.getGroupServise().getPeaksoft().getStudents());
        }
        return "in peakSoft haven't this student";
    }

    @Override
    public Student updateById(int id, Student student) {
        Student[]oldStudents = mentorsService.getGroupServise().getPeaksoft().getStudents();
        for (int i = 0; i < oldStudents.length; i++) {
            if (oldStudents[i].getId()==id){
                oldStudents[i].setName(student.getName());
                oldStudents[i].setEmail(student.getEmail());
                oldStudents[i].setGender(student.getGender());
                return oldStudents[i];
            }
        }

        return null;
    }

    @Override
    public Student findById(int id) {
        Student[]oldStudents = mentorsService.getGroupServise().getPeaksoft().getStudents();
        for (int i = 0; i < oldStudents.length; i++) {
            if (oldStudents[i].getId()==id){
                return oldStudents[i];
            }
        }
        return null;
    }

}
