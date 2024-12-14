package Task25;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileProcessor processor = new FileProcessor();
        FileDAO fileDAO = new FileDAO();

        while (true) {
            System.out.println("Введите команду (process/list/saveLocal/exit):");
            String command = scanner.nextLine().trim();

            switch (command.toLowerCase()) {
                case "process":
                    System.out.print("Введите путь к файлу или папке: ");
                    String path = scanner.nextLine();
                    processor.processFiles(path);
                    break;

                case "list":
                    try {
                        fileDAO.listFiles();
                    } catch (SQLException e) {
                        System.err.println("Ошибка при получении списка файлов: " + e.getMessage());
                    }
                    break;

                case "savelocal":
                    System.out.print("Введите ID файла для сохранения: ");
                    int fileId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите директорию для сохранения: ");
                    String outputDir = scanner.nextLine();
                    try {
                        fileDAO.saveFileLocally(fileId, outputDir);
                    } catch (SQLException | IOException e) {
                        System.err.println("Ошибка при сохранении файла локально: " + e.getMessage());
                    }
                    break;

                case "exit":
                    System.out.println("Выход из приложения.");
                    return;

                default:
                    System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }
    }
}
