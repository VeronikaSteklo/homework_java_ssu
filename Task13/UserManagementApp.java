package Task13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserManagementApp {
    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            users = UserManager.loadUsers();
            System.out.println("Список пользователей успешно загружен.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось загрузить список пользователей. Начинаем с пустого списка.");
        }

        while (true) {
            System.out.println("\nДобро пожаловать в систему управления пользователями!");
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить нового пользователя");
            System.out.println("2. Показать всех пользователей");
            System.out.println("3. Найти пользователя по имени");
            System.out.println("4. Удалить пользователя по имени");
            System.out.println("5. Сохранить список пользователей в файл");
            System.out.println("6. Загрузить список пользователей из файла");
            System.out.println("7. Выйти");

            System.out.print("Введите номер действия: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addUser(scanner);
                case 2 -> showUsers();
                case 3 -> findUser(scanner);
                case 4 -> deleteUser(scanner);
                case 5 -> saveUsersToFile();
                case 6 -> loadUsersFromFile();
                case 7 -> exitProgram();
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        if (!isValidEmail(email)) {
            System.out.println("Неверный формат email. Пользователь не добавлен.");
            return;
        }

        users.add(new User(name, age, email));
        System.out.println("Пользователь добавлен.");
    }

    private static void showUsers() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
            return;
        }

        System.out.println("Список пользователей:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i));
        }
    }

    private static void findUser(Scanner scanner) {
        System.out.print("Введите имя пользователя для поиска: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                System.out.println(user);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Пользователь с именем \"" + name + "\" не найден.");
        }
    }

    private static void deleteUser(Scanner scanner) {
        System.out.print("Введите имя пользователя для удаления: ");
        String name = scanner.nextLine();

        Iterator<User> iterator = users.iterator();
        boolean deleted = false;

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                deleted = true;
            }
        }

        if (deleted) {
            System.out.println("Пользователь \"" + name + "\" успешно удалён.");
        } else {
            System.out.println("Пользователь с именем \"" + name + "\" не найден.");
        }
    }

    private static void saveUsersToFile() {
        try {
            UserManager.saveUsers(users);
            System.out.println("Список успешно сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении списка: " + e.getMessage());
        }
    }

    private static void loadUsersFromFile() {
        try {
            users = UserManager.loadUsers();
            System.out.println("Список успешно загружен из файла.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке списка: " + e.getMessage());
        }
    }

    private static void exitProgram() {
        saveUsersToFile();
        System.out.println("Программа завершена. До свидания!");
        System.exit(0);
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-z]{2,}$";
        return Pattern.matches(emailRegex, email);
    }
}