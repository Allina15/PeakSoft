package Student.Sservices;

import Student.Interfaces.GroupInterface;
import Student.Model.Group;
import Student.Model.Peaksoft;

import java.util.Arrays;

public class GroupServise implements GroupInterface {
    private Peaksoft peaksoft;

    public GroupServise(Peaksoft peaksoft) {
        this.peaksoft = peaksoft;
    }

    public Peaksoft getPeaksoft() {
        return peaksoft;
    }

    public void setPeaksoft(Peaksoft peaksoft) {
        this.peaksoft = peaksoft;
    }

    @Override
    public Group[] getAllGroups() {
        return peaksoft.getGroups();
    }
    @Override
    public Group getGroup(int id) {
        for (int i = 0; i < peaksoft.getGroups().length; i++) {
            if (peaksoft.getGroups()[i].getId()==id){
                return peaksoft.getGroups()[i];
            }
        }
        return null;
    }
    @Override
    public void deleteGroupById(int id) {
        boolean aa = false;
        Group [] newGroup = new Group[peaksoft.getGroups().length-1];
        for (int i = 0; i < peaksoft.getGroups().length-1; i++) {
            if (!aa && peaksoft.getGroups()[i].getId()!=id){
             newGroup[i]=peaksoft.getGroups()[i];
            }
            else {
                aa=true;
            }
            if (aa){
                newGroup[i]=peaksoft.getGroups()[i+1];
            }
        }
        peaksoft.setGroups(newGroup);
        for (int j = 0; j < peaksoft.getGroups().length; j++) {
            peaksoft.getGroups()[j].setId(j);
            Group.idd=j+1;
        }
        System.out.println("Group is deleted");
    }

    @Override
    public String createGroup(Group group) {
        Group [] newGroup;
        newGroup=Arrays.copyOf(peaksoft.getGroups(),peaksoft.getGroups().length+1);
        for (int i = 0; i < peaksoft.getGroups().length; i++) {
            if (peaksoft.getGroups()[i].getName().equals(group.getName())) {
                newGroup[i]=peaksoft.getGroups()[i];
                newGroup[newGroup.length-1]=group;
                peaksoft.setGroups(newGroup);
                return Arrays.toString(peaksoft.getGroups());
            }
        }
                return "Takaya gruppa uje est";
    }

    @Override
    public Group updateById(int id, Group group) {
        for (int i = 0; i < peaksoft.getGroups().length; i++) {
            if (peaksoft.getGroups()[i].getId()==id){
                peaksoft.getGroups()[i].setName(group.getName());
                peaksoft.getGroups()[i].setStudents(group.getStudents());
                peaksoft.getGroups()[i].setCount(group.getCount());
                return peaksoft.getGroups()[i];
            }
        }
        return null;
    }

    @Override
    public Group findById(int id) {
        for (int i = 0; i < peaksoft.getGroups().length; i++) {
            if (peaksoft.getGroups()[i].getId()==id){
                return peaksoft.getGroups()[i];
            }
        }
        return null;
    }
}
