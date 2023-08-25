package Student;

import Student.Enum.Gender;
import Student.Enum.GroupName;
import Student.Model.Group;
import Student.Model.Mentor;
import Student.Model.Peaksoft;
import Student.Model.Student;
import Student.Sservices.GroupServise;
import Student.Sservices.MentorsService;
import Student.Sservices.StudentService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Alina", Gender.FEMALE, "alina1@");
        Student student2 = new Student("Farida", Gender.FEMALE, "Fari@");
        Student[] students1 = {student1, student2};
        Student student3 = new Student("kandy", Gender.MALE, "Kandy@");
        Student student4 = new Student("Zalkar", Gender.MALE, "Zakofs@");
        Student[] students2 = {student3, student4};
        Student student5 = new Student("Zhandar", Gender.MALE, "Zhandar@");
        Student student6 = new Student("Nurles", Gender.MALE, "Nurles@");
        Student[] students3 = {student5, student6};
        Student student7 = new Student("Bilal", Gender.MALE, "Bili@");
        Student student8 = new Student("Elnura", Gender.MALE, "Elya@");
        Student[] students4 = {student7, student8};

        Group group1 = new Group(GroupName.JAVA11, students1, students1.length);
        Group group2 = new Group(GroupName.JS11, students2, students2.length);
        Group group3 = new Group(GroupName.JAVA10, students3, students3.length);
        Group group4 = new Group(GroupName.JS10, students4, students4.length);
        Group[] groups = {group1, group2, group3, group4};

        Student[][] students = new Student[][]{students1, students2, students3};

        Mentor mentor1 = new Mentor("Ainazik", Gender.FEMALE, "Aii@", group1);
        Mentor mentor2 = new Mentor("Nurisa", Gender.FEMALE, "NN@", group2);
        Mentor mentor3 = new Mentor("ULan", Gender.MALE, "ulan@", group3);
        Mentor[] mentors = {mentor1, mentor2};
        Peaksoft peaksoft = new Peaksoft("Peaksoft", "Grajdanskaya 119", mentors, students, groups);

        GroupServise groupServise = new GroupServise(peaksoft);
        MentorsService mentorsService = new MentorsService(groupServise);
        StudentService studentService = new StudentService(mentorsService);
        Scanner scanner = new Scanner(System.in);

            System.out.println("Выберите одно из них:\n1.Mentor\n2.Group\n3.Students");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("1.Get Mentor by Email \n2.Delete mentor by id\n3.Get all mentors\n4.Update mentor by id\n5.Find mentor by id\n6.Create mentor");
                        int num1 = scanner.nextInt();
                        switch (num1) {
                            case 1:
                                System.out.println("Enter to email ");
                                System.out.println(mentorsService.getMentorByEmail(scanner.next()));
                                break;
                            case 2:
                                System.out.println("Enter to id ");
                                mentorsService.deleteMentorById(scanner.nextInt());
                                break;
                            case 3:
                                System.out.println(Arrays.toString(mentorsService.getAllMentors()));
                                break;
                            case 4:
                                System.out.println("Enter to id");
                                System.out.println(mentorsService.updateById(scanner.nextInt(), mentor3));
                                break;
                            case 5:
                                System.out.println("Enter to id");
                                System.out.println(mentorsService.findById(scanner.nextInt()));
                                break;
                            case 6:
                                System.out.println(mentorsService.createMentor(mentor3));
                                break;
                        }
                    }
                case 2:
                    while (true) {
                        System.out.println("1.Get group\n2.Delete group by id\n3.Create group\n4.Get all groups\n5.Update by id\n6.Find by id");
                        int num2 = scanner.nextInt();
                        switch (num2) {
                            case 1:
                                System.out.println("Enter to id");
                                System.out.println(groupServise.getGroup(scanner.nextInt()));
                                break;
                            case 2:
                                System.out.println("Enter to id");
                                groupServise.deleteGroupById(scanner.nextInt());
                                break;
                            case 3:
                                System.out.println(groupServise.createGroup(group4));
                                break;
                            case 4:
                                System.out.println(Arrays.toString(groupServise.getAllGroups()));
                                break;
                            case 5:
                                System.out.println("Enter to id");
                                System.out.println(groupServise.updateById(scanner.nextInt(), group4));
                                break;
                            case 6:
                                System.out.println("Enter to id");
                                System.out.println(groupServise.findById(scanner.nextInt()));
                        }
                    }
                case 3:
                    while (true) {
                        System.out.println("1.Get all students\n2.search student by name\n3.Delete student by id\n4.Create student\n5.Update by id\n6.Find by id");
                        int num3 = scanner.nextInt();
                        switch (num3) {
                            case 1:
                                System.out.println(Arrays.deepToString(studentService.getAllStudents()));
                                break;
                            case 2:
                                System.out.println("Enter to name");
                                System.out.println(studentService.searchStudentByName(scanner.next()));
                                break;
                            case 3:
                                System.out.println("Enter to id");
                                studentService.deleteStudentById(scanner.nextInt());
                                break;
                            case 4:
                                System.out.println(studentService.createStudent(student8));
                                break;
                            case 5:
                                System.out.println("Enter to id");
                                System.out.println(studentService.updateById(scanner.nextInt(), student7));
                                break;
                            case 6:
                                System.out.println("Enter the id");
                                System.out.println(studentService.findById(scanner.nextInt()));
                                break;
                        }
                    }
            }
    }
}