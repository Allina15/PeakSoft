package Student.Interfaces;

import Student.Model.Group;
import Student.Model.Mentor;
import Student.Model.Student;

public interface GroupInterface {
    Group[]getAllGroups();
    Group getGroup(int id);
    void deleteGroupById(int id);
    String createGroup(Group group);
    Group updateById(int id, Group group);
    Group findById(int id);
}
