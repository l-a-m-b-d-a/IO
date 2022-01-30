package objectfile;

import java.io.*;

public class Student extends Human implements Serializable {
    private Group group;

    public Student(int age, String name, String surname, Group group) {
        super(age, name, surname);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" + "name: " + this.getName()
                + " \tsurname: " + this.getSurname()
                + "\tage: " + this.getAge() +
                " group=" + group +
                '}';
    }
}
