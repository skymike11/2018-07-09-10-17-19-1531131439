package practice07;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }


    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduceWith(Student student) {
        String result = " I am a Teacher. " + (student.getKlass().getNumber() == klass.getNumber() ?
                String.format("I teach %s.", student.getName()) : String.format("I don't teach %s.", student.getName()));
        return super.introduce() + result;
    }

    @Override
    public String introduce() {
        return String.format("%s I am a Teacher. I teach %s.", super.introduce(), klass == null ? "No Class" : klass.getDisplayName());
    }

}