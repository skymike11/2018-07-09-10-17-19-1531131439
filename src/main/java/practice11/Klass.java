package practice11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Klass {
    private int number;

    private Student leader;

    private Set<Integer> classMember = new HashSet<>();

    private Obsever obsever;

    private List<Obsever> obsevers;

    public Klass(int number) {
        this.number = number;
        obsevers = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void assignLeader(Student student) {
        if (classMember.contains(student.getId())) {
            this.leader = student;
            notifyObsever(0, student);
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        classMember.add(student.getId());
        notifyObsever(1, student);
    }

    public Student getLeader() {
        return leader;
    }

    public boolean isIn(int stuId) {
        return classMember.contains(stuId);
    }

    public void addObsever(Obsever obsever) {
        this.obsevers.add(obsever);
    }

    public void notifyObsever(int state, Student student) {
        for (Obsever obsever : obsevers) {
            obsever.update(state, student);
        }
    }

}
