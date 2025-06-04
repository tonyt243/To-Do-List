public class Task {
    String description;
    String priority;
    boolean completed;

    public Task(String description, String priority) {
        this.description = description;
        this.priority = priority.toUpperCase();
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        String status = completed ? "[x]" : "[ ]";
        return status + " " + description + " (" + priority + ")";
    }
}
