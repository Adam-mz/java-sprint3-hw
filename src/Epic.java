import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks;

    public Epic(String title, String description, int id, Status status) {
        super(title, description, id, status);
        subtasks = new ArrayList<>();
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }
    public void deleteSubtask(Subtask subtask) {
        subtasks.remove(subtask);
    }
}
