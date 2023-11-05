import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Создаем несколько задач
        Task task1 = new Task("Task 1", "Description 1", 1, Status.NEW);
        Task task2 = new Task("Task 2", "Description 2", 2, Status.IN_PROGRESS);
        Task task3 = new Task("Task 3", "Description 3", 3, Status.DONE);

        // Добавляем задачи в менеджер задач
        manager.createTask(task1);
        manager.createTask(task2);
        manager.createTask(task3);

        // Получаем все задачи
        ArrayList<Task> allTasks = manager.getAllTasks();
        System.out.println("All tasks: " + allTasks);

        // Получаем задачу по id
        Task taskById = manager.getTaskById(1);
        System.out.println("Task by id: " + taskById);

        // Обновляем задачу
        task1.setStatus(Status.IN_PROGRESS);
        manager.updateTask(task1);
        System.out.println("Updated task: " + manager.getTaskById(1));

        // Создаем эпик с несколькими подзадачами
        Epic epic1 = new Epic("Epic 1", "Description 1", 1, Status.NEW);
        Subtask subtask1 = new Subtask("Subtask 1", "Description 1", 1, Status.NEW, 1);
        Subtask subtask2 = new Subtask("Subtask 2", "Description 2", 2, Status.NEW, 1);
        epic1.addSubtask(subtask1);
        epic1.addSubtask(subtask2);
        manager.createEpic(epic1);

        // Получаем все эпики
        ArrayList<Epic> allEpics = manager.getAllEpics();
        System.out.println("All epics: " + allEpics);

        // Получаем все подзадачи для эпика
        ArrayList<Subtask> subtasksByEpicId = manager.getSubtasksByEpicId(1);
        System.out.println("Subtasks by epic id: " + subtasksByEpicId);

        // Обновляем подзадачу
        subtask1.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);
        System.out.println("Subtask 1 updated: " + manager.getSubtaskById(1));

        // Удаляем задачу, эпик и подзадачу по id
        manager.deleteTaskById(2);
        manager.deleteEpicById(1);
        manager.deleteSubtaskById(2);

        // Получаем все задачи, эпики и подзадачи после удаления
        System.out.println("All tasks after delete: " + manager.getAllTasks());
        System.out.println("All epics after delete: " + manager.getAllEpics());
        System.out.println("All subtasks after delete: " + manager.getAllSubtasks());

        // Удаляем все задачи, эпики и подзадачи
        manager.deleteAllTasks();
        manager.deleteAllEpics();
        manager.deleteAllSubtasks();
        System.out.println("All tasks after delete all: " + manager.getAllTasks());
        System.out.println("All epics after delete all: " + manager.getAllEpics());
        System.out.println("All subtasks after delete all: " + manager.getAllSubtasks());
    }


}