package practice09;

import java.util.Set;

public class Klass {
    private int number;

    private Student leader;

    private Set<Integer> classMember;

    public Klass(int number) {
        this.number = number;
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
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public void appendMember(Student student) {
        classMember.add(student.getId());
    }

    public Student getLeader() {
        return leader;
    }
}
