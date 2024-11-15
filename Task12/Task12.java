package Task12;

import java.io.IOException;
import java.nio.file.*;

public class Task12 {
    public static void main(String[] args) {
        Path startDir = Paths.get("C:\\Users\\veron\\OneDrive\\Рабочий стол\\работы универ"); // Укажите путь к вашей директории
        WordCountingFileVisitor visitor = new WordCountingFileVisitor();

        try {
            Files.walkFileTree(startDir, visitor);
            System.out.println("Общее количество слов во всех .txt файлах: " + visitor.getTotalWordCount());
        } catch (IOException e) {
            System.out.println("Произошла ошибка при обработке файлов: " + e.getMessage());
        }
    }
}

