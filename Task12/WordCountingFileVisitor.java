package Task12;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.io.BufferedReader;
import java.nio.file.Files;

class WordCountingFileVisitor extends SimpleFileVisitor<Path> {
    private long totalWordCount = 0;

    public long getTotalWordCount() {
        return totalWordCount;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".txt")) {
            long wordCount = countWords(file);
            System.out.println("Файл: " + file + ", количество слов: " + wordCount);
            totalWordCount += wordCount;
        }
        return FileVisitResult.CONTINUE;
    }

    private static long countWords(Path filePath) throws IOException {
        long wordCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.out.println("Не удалось получить доступ к файлу: " + file + ", ошибка: " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
