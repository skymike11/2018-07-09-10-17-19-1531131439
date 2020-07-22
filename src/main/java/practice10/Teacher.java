package practice10;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {
    private List<Klass> classes = new LinkedList<Klass>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> klass) {
        super(id, name, age);
        this.classes = klass;
    }

    public List<Klass> getKlass() {
        return classes;
    }

    public String getTeachingClassDisplay() {
        return classes.stream().map(n -> String.valueOf(n.getNumber())).collect(Collectors.joining(" ,"));
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.", super.introduce(), classes.size() <=0 ? "No Class" : getTeachingClassDisplay());
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public boolean isTeaching (Student student) {
        for (Klass klass : classes) {
            if (klass.isIn(String.valueOf(student.getId()))) {
                return true;
            }
        }
        return false;
    }
}
