package Student.Interfaces;

import Student.Model.Mentor;
import Student.Model.Student;

public interface MentorsInterface {
    Mentor[]getAllMentors();
    Mentor getMentorByEmail(String email);
    void deleteMentorById(int id);
    String createMentor(Mentor mentor);
    Mentor updateById(int id, Mentor mentor);
    Mentor findById(int id);
}
