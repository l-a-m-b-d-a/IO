package objectfile;

import java.io.*;

public class Group implements Serializable {
    private int numberGroup;
    private transient int idGroup; // this field dont serialize but u can write WriteObject and ReadObject for there fields
    private transient double averageBall;


    public Group(int numberGroup, int idGroup, double averageBall) {
        this.numberGroup = numberGroup;
        this.idGroup = idGroup;
        this.averageBall = averageBall;
    }
// if we need use transient
//    @Serial
//    private void writeObject(ObjectOutputStream oos) throws IOException {
//        oos.defaultWriteObject();
//        oos.writeInt(idGroup);
//    }
//
//    @Serial
//    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        ois.defaultReadObject();
//        idGroup = ois.readInt();
//    }

    @Override
    public String toString() {
        return "Group{" +
                "numberGroup=" + numberGroup +
                ", idGroup=" + idGroup +
                ", averageBall=" + averageBall +
                '}';
    }
}
