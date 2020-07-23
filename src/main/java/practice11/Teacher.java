package practice11;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static practice11.Constant.NOTIFY_MESSAGE_ASSIGN;
import static practice11.Constant.NOTIFY_MESSAGE_JOIN;

public class Teacher extends Person implements Obsever  {
    private List<Klass> classes = new LinkedList<Klass>();

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, List<Klass> klass) {
        super(id, name, age);
        for (int i = 0; i < klass.size(); i++) {
             Klass tempClass = klass.get(i);
             tempClass.addObsever(this);
             klass.set(i, tempClass);
        }
        this.classes = klass;
    }

    public List<Klass> getKlass() {
        return classes;
    }

    public String getTeachingClassDisplay() {
        return classes.stream().map(n -> String.valueOf(n.getNumber())).collect(Collectors.joining(", "));
    }

    public String introduceWith(Student student) {
        String result = " I am a Teacher. " + (isTeaching(student) ?
                String.format("I teach %s.", student.getName()) : String.format("I don't teach %s.", student.getName()));
        return super.introduce() + result;
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.", super.introduce(), classes.size() <= 0 ? "No Class" : "Class " + getTeachingClassDisplay());
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : classes) {
            if (klass.isIn(student.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(int state, Student student) {
        if (state == NOTIFY_MESSAGE_ASSIGN) {
            System.out.print(String.format("I am %s. I know %s become Leader of %s.\n", getName(), student.getName(), student.getKlass().getDisplayName()));
        } else if (state == NOTIFY_MESSAGE_JOIN ){
            System.out.print(String.format("I am %s. I know %s has joined %s.\n", getName(), student.getName(), student.getKlass().getDisplayName()));
        }
    }
}
