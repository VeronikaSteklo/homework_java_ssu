package Task24;

import java.sql.*;
import java.util.*;

public class Task24{
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            UserDAO userDAO = new UserDAOImpl(connection);
            UserService userService = new UserService(userDAO);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter command: ");
                String command = scanner.nextLine();
                String[] parts = command.split(";", 4);

                try {
                    switch (parts[0].toLowerCase()) {
                        case "add":
                            userService.registerUser(parts[1], parts[2]);
                            System.out.println("User added.");
                            break;
                        case "list":
                            List<User> users = userService.listAllUsers();
                            users.forEach(System.out::println);
                            break;
                        case "delete":
                            userService.deleteUser(Integer.parseInt(parts[1]));
                            System.out.println("User deleted.");
                            break;
                        case "update":
                            userService.updateUser(Integer.parseInt(parts[1]), parts[2], parts[3]);
                            System.out.println("User updated.");
                            break;
                        case "exit":
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Unknown command.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
