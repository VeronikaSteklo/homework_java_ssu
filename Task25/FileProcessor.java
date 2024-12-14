package Task25;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

class FileProcessor {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10 MB
    private final FileDAO fileDAO = new FileDAO();

    public void processFiles(String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Указанный путь не существует.");
            return;
        }

        if (file.isFile()) {
            handleFile(file);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    if (f.isFile() && f.length() <= MAX_FILE_SIZE) {
                        handleFile(f);
                    }
                }
            }
        } else {
            System.out.println("Неверный путь: " + path);
        }
    }

    private void handleFile(File file) {
        try {
            System.out.println("Сохранение файла: " + file.getName());
            fileDAO.saveFile(file);
            System.out.println("Файл сохранён.");
        } catch (SQLException | IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }
}
