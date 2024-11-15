package Task11;
import java.util.TreeSet;

public class StudentManager {
    private TreeSet<String> students = new TreeSet<>();

    public void addStudent(String name) {
        if (students.contains(name)) {
            System.out.println("Ошибка: такой студент уже существует.");
        } else {
            students.add(name);
            System.out.println("Студент добавлен.");
        }
    }

    public void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println("Студент удален.");
        } else {
            System.out.println("Ошибка: студент не найден.");
        }
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
        } else {
            System.out.println("Список студентов:");
            students.forEach(System.out::println);
        }
    }

    public void findStudent(String name) {
        if (students.contains(name)) {
            System.out.println("Студент найден: " + name);
        } else {
            System.out.println("Студент не найден.");
        }
    }

    public void showStudentsInRange(String from, String to) {
        TreeSet<String> range = (TreeSet<String>) students.subSet(from, true, to, true);
        if (range.isEmpty()) {
            System.out.println("Студенты в указанном диапазоне не найдены.");
        } else {
            System.out.println("Список студентов в диапазоне от " + from + " до " + to + ":");
            range.forEach(System.out::println);
        }
    }
}