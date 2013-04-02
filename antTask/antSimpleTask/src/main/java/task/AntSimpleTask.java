package task;

public class AntSimpleTask{
    private int count;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void execute() {
        System.out.println("This is an ant simple task");
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }
}

