package practice09;

import static java.lang.String.format;

public class Student extends Person {

    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String stuIdentity = format("I am at %s.", klass.getDisplayName());
        ;
        if (klass.getLeader() != null && name.equals(klass.getLeader().getName())) {
            stuIdentity = format("I am Leader of %s.", klass.getDisplayName());
        }
        return format("%s I am a Student. ", super.introduce()) + stuIdentity;
    }

}
