public class Task {
    String description;
    String priority;

    public Task(String description, String priority) {
        this.description = description;
        this.priority = priority.toUpperCase();
    }

    @Override
    public String toString() {
        return description + " (" + priority + ")";
    }
}