package objectfile;

import java.io.Serializable;

public class Group implements Serializable {
    private int numberGroup;
    private transient int idGroup; // this field dont serialize but u can write WriteObject and ReadObject for there fields
    private transient double averageBall;


    public Group(int numberGroup, int idGroup, double averageBall) {
        this.numberGroup = numberGroup;
        this.idGroup = idGroup;
        this.averageBall = averageBall;
    }

    @Override
    public String toString() {
        return "Group{" +
                "numberGroup=" + numberGroup +
                ", idGroup=" + idGroup +
                ", averageBall=" + averageBall +
                '}';
    }
}
