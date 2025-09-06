public class Task {
    String description;
    String priority;
    String date;
    boolean completed;

    public Task(String description, String priority, String date) {
        this.description = description;
        this.priority = priority.toUpperCase();
        this.date = date;
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
