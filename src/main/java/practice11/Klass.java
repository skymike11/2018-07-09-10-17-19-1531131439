package practice11;

import java.util.HashSet;
import java.util.Set;

public class Klass {
    private int number;

    private Student leader;

    private Set<Integer> classMember = new HashSet<>();

    private Teacher teacher;

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
            if (teacher != null)
                System.out.print(String.format("I am %s. I know %s become Leader of %s.\n", teacher.getName(), student.getName(), getDisplayName()));
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student) {
        classMember.add(student.getId());
        if (teacher != null)
            System.out.print(String.format("I am %s. I know %s has joined %s.\n", teacher.getName(), student.getName(), getDisplayName()));
    }

    public Student getLeader() {
        return leader;
    }

    public boolean isIn(int stuId) {
        return classMember.contains(stuId);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
