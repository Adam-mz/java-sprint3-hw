public class Main {
    public static void main(String[] args) {
        // создаем менеджер задач
        TaskManager manager = new TaskManager();

        // создаем задачу
        Task task1 = new Task("Купить продукты", "Молоко, хлеб, яйца", 1, Status.NEW);
        manager.createTask(task1);

        // создаем эпик с 2 подзадачами
        Epic epic1 = new Epic("Построить дом", "Купить землю, нанять архитектора и строительную бригаду", 2, Status.NEW);
        Subtask subtask1 = new Subtask("Купить землю", "Найти подходящий участок земли и купить его", 3, Status.IN_PROGRESS, 2);
        Subtask subtask2 = new Subtask("Нанять архитектора и строительную бригаду", "Найти хорошего архитектора и нанять команду для строительства", 4, Status.NEW, 2);
        epic1.addSubtask(subtask1);
        epic1.addSubtask(subtask2);
        manager.createEpic(epic1);

        // создаем эпик с 1 подзадачей
        Epic epic2 = new Epic("Запланировать отпуск", "Выбрать направление и забронировать билеты и отель", 5, Status.NEW);
        Subtask subtask3 = new Subtask("Забронировать билеты и отель", "Найти хорошую сделку на билеты и забронировать отель", 6, Status.DONE, 5);
        epic2.addSubtask(subtask3);
        manager.createEpic(epic2);

        // выводим все задачи
        System.out.println("Все задачи:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println();

        // выводим все эпики со списком связанных подзадач
        System.out.println("Все эпики:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
            System.out.println("Подзадачи:");
            for (Subtask subtask : epic.getSubtasks()) {
                System.out.println(subtask);
            }
            System.out.println();
        }

        // изменяем статусы задач, подзадач и эпиков
        task1.setStatus(Status.IN_PROGRESS);
        subtask1.setStatus(Status.DONE);
        subtask2.setStatus(Status.IN_PROGRESS);
        epic1.setStatus(Status.IN_PROGRESS);
        epic2.setStatus(Status.DONE);

        // выводим все задачи после изменения статусов
        System.out.println("Все задачи после изменения статусов:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println();

        // выводим все эпики со списком связанных подзадач после изменения статусов
        System.out.println("Все эпики после изменения статусов:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
            System.out.println("Подзадачи:");
            for (Subtask subtask : epic.getSubtasks()) {
                System.out.println(subtask);
            }
            System.out.println();
        }

        // удаляем задачу по id
        manager.deleteTaskById(1);

        // удаляем эпик по id
        manager.deleteEpicById(2);

        // выводим все задачи после удаления
        System.out.println("Все задачи после удаления:");
        for (Task task : manager.getAllTasks()) {
            System.out.println(task);
        }
        System.out.println();

        // выводим все эпики со списком связанных подзадач после удаления
        System.out.println("Все эпики после удаления:");
        for (Epic epic : manager.getAllEpics()) {
            System.out.println(epic);
            System.out.println("Подзадачи:");
            for (Subtask subtask : epic.getSubtasks()) {
                System.out.println(subtask);
            }
            System.out.println();
        }
    }
}