package Task25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class FileDAO {
    private static final String INSERT_FILE_SQL = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";
    private static final String LIST_FILES_SQL = "SELECT id, file_name FROM files";
    private static final String GET_FILE_SQL = "SELECT file_name, file_binary FROM files WHERE id = ?";

    public void saveFile(File file) throws SQLException, IOException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_FILE_SQL)) {

            statement.setString(1, file.getName());

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                statement.setBytes(2, fileBytes);
            }

            statement.executeUpdate();
        }
    }

    public void listFiles() throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(LIST_FILES_SQL);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("ID | File Name");
            System.out.println("----------------");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fileName = resultSet.getString("file_name");
                System.out.println(id + " | " + fileName);
            }
        }
    }

    public void saveFileLocally(int fileId, String outputDir) throws SQLException, IOException {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_FILE_SQL)) {

            statement.setInt(1, fileId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String fileName = resultSet.getString("file_name");
                    byte[] fileBytes = resultSet.getBytes("file_binary");

                    File outputFile = new File(outputDir + File.separator + fileName);
                    try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                        fos.write(fileBytes);
                    }

                    System.out.println("Файл сохранён: " + outputFile.getAbsolutePath());
                } else {
                    System.out.println("Файл с ID " + fileId + " не найден.");
                }
            }
        }
    }
}
