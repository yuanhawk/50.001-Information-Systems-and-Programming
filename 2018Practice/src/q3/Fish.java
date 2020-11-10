package q3;

public class Fish implements Observer  {

    private String id;
    private Subject subject = null;

    public Fish(String id, Subject subject) {
        this.id = id;
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update(int t) {
        System.out.println("Fish " + id + " receives temperature alert: " + t);
    }
}

