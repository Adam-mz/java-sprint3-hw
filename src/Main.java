import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Создаем объект TaskManager
        TaskManager taskManager = new TaskManager();

        // Создаем несколько объектов Task
        Task task1 = new Task("Task 1", "Description 1", 1, Status.NEW);
        Task task2 = new Task("Task 2", "Description 2", 2, Status.NEW);

        // Добавляем задачи в TaskManager
        taskManager.createTask(task1);
        taskManager.createTask(task2);

        // Проверяем, что задачи добавлены
        ArrayList<Task> allTasks = taskManager.getAllTasks();
        System.out.println("All tasks:");
        for (Task task : allTasks) {
            System.out.println(task.getTitle());
        }

        // Обновляем статусы задач и выводим список задач
        task1.setStatus(Status.IN_PROGRESS);
        task2.setStatus(Status.DONE);
        taskManager.updateTask(task1);
        taskManager.updateTask(task2);
        System.out.println("All tasks after status update:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task.getTitle() + ": " + task.getStatus());
        }

        // Создаем объекты эпиков и подзадач
        Epic epic1 = new Epic("Epic 1", "Description 1", 1, Status.NEW);
        Subtask subtask1 = new Subtask("Subtask 1", "Description 1", 11, Status.NEW, 1);
        Subtask subtask2 = new Subtask("Subtask 2", "Description 2", 12, Status.NEW, 1);

        // Добавляем эпик и подзадачи в TaskManager
        taskManager.createEpic(epic1);
        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);

        // Добавляем подзадачи к эпику
        epic1.addSubtask(subtask1);
        epic1.addSubtask(subtask2);

        // Проверяем, что эпик и подзадачи добавлены
        ArrayList<Epic> allEpics = taskManager.getAllEpics();
        System.out.println("All epics:");
        for (Epic epic : allEpics) {
            System.out.println(epic.getTitle());
            for (Subtask subtask : epic.getSubtasks()) {
                System.out.println("- " + subtask.getTitle());
            }
        }

        // Обновляем статус подзадач и выводим список подзадач
        subtask1.setStatus(Status.IN_PROGRESS);
        subtask2.setStatus(Status.DONE);
        taskManager.updateSubtask(subtask1);
        taskManager.updateSubtask(subtask2);
        System.out.println("All subtasks after status update:");
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask.getTitle() + ": " + subtask.getStatus());
        }

        // Удаляем одну из подзадач и проверяем статус эпика
        taskManager.deleteSubtaskById(11);
        System.out.println("Epic status after subtask deletion: " + epic1.getStatus());

        // Удаляем эпик и задачи и проверяем, что все удалено
        taskManager.deleteEpicById(1);
        taskManager.deleteAllTasks();
        System.out.println("All tasks: " + taskManager.getAllTasks());
        System.out.println("All epics: " + taskManager.getAllEpics());
        System.out.println("All subtasks: " + taskManager.getAllSubtasks());
    }


}