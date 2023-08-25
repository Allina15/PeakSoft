package Student.Sservices;

import Student.Interfaces.MentorsInterface;
import Student.Model.Mentor;

import java.util.Arrays;

public class MentorsService implements MentorsInterface {
    private GroupServise groupServise;

    public MentorsService(GroupServise groupServise) {
        this.groupServise = groupServise;
    }

    public GroupServise getGroupServise() {
        return groupServise;
    }

    public void setGroupServise(GroupServise groupServise) {
        this.groupServise = groupServise;
    }

    @Override
    public Mentor[] getAllMentors() {
        return groupServise.getPeaksoft().getMentors();
    }

    @Override
    public Mentor getMentorByEmail(String email) {
        for (int i = 0; i < groupServise.getPeaksoft().getMentors().length; i++) {
            if (groupServise.getPeaksoft().getMentors()[i].getEmail().equalsIgnoreCase(email)) {
                return groupServise.getPeaksoft().getMentors()[i];
            }
        }
        return null;
    }

    @Override
    public void deleteMentorById(int id) {
        boolean trueIliNeTrue = false;
        Mentor[] oldMentors = Arrays.copyOf(groupServise.getPeaksoft().getMentors(), groupServise.getPeaksoft().getMentors().length);
        Mentor[] mentors = new Mentor[oldMentors.length - 1];
        for (int i = 0; i < oldMentors.length - 1; i++) {
            if (!trueIliNeTrue && oldMentors[i].getId() != id) {
                mentors[i] = oldMentors[i];
            } else {
                trueIliNeTrue = true;
            }
            if (trueIliNeTrue) {
                mentors[i] = oldMentors[i + 1];
            }
        }
        groupServise.getPeaksoft().setMentors(mentors);
        for (int j = 0; j < groupServise.getPeaksoft().getMentors().length; j++) {
            groupServise.getPeaksoft().getMentors()[j].setId(j);
        }
        System.out.println("Mentor was delete");
    }

    @Override
    public String createMentor(Mentor mentor) {
        Mentor[] newMentors;
        newMentors = Arrays.copyOf(groupServise.getPeaksoft().getMentors(), groupServise.getPeaksoft().getMentors().length + 1);
        newMentors[newMentors.length - 1] = mentor;
        groupServise.getPeaksoft().setMentors(newMentors);
        return "Mentor Added";
    }

    @Override
    public Mentor updateById(int id, Mentor mentor) {
        for (int i = 0; i <groupServise.getPeaksoft().getMentors().length ; i++) {
            if (groupServise.getPeaksoft().getMentors()[i].getId()==id){
                groupServise.getPeaksoft().getMentors()[i].setName(mentor.getName());
                groupServise.getPeaksoft().getMentors()[i].setEmail(mentor.getEmail());
                groupServise.getPeaksoft().getMentors()[i].setGender(mentor.getGender());
                groupServise.getPeaksoft().getMentors()[i].setGroup(mentor.getGroup());
                return groupServise.getPeaksoft().getMentors()[i];
            }
        }
        return null;
    }

    @Override
    public Mentor findById(int id) {
        for (int i = 0; i < groupServise.getPeaksoft().getMentors().length; i++) {
            if (groupServise.getPeaksoft().getMentors()[i].getId() == id) {
                return groupServise.getPeaksoft().getMentors()[i];
            }
        }
        return null;
    }
}
