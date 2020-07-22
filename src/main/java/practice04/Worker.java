package practice04;

public class Worker extends Person {
    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce() {
        return new Person(name, age).introduce()  + " I am a Worker. I have a job.";
    }
}
