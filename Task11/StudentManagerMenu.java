package Task11;
import java.util.Scanner;

public class StudentManagerMenu {
    private StudentManager manager = new StudentManager();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    manager.showAllStudents();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    showStudentsInRange();
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Найти студента");
        System.out.println("5. Показать студентов в диапазоне");
        System.out.println("6. Выйти");
        System.out.print("Выберите опцию: ");
    }

    private int getChoice() {
        return scanner.nextInt();
    }

    private void addStudent() {
        System.out.print("Введите студента: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        manager.addStudent(name);
    }

    private void removeStudent() {
        System.out.print("Введите студента для удаления: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        manager.removeStudent(name);
    }

    private void findStudent() {
        System.out.print("Введите студента для поиска: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        manager.findStudent(name);
    }

    private void showStudentsInRange() {
        System.out.print("Введите первого студента из диапазона: ");
        scanner.nextLine();
        String from = scanner.nextLine();
        System.out.print("Введите второго студента из диапазона: ");
        String to = scanner.nextLine();
        manager.showStudentsInRange(from, to);
    }
}