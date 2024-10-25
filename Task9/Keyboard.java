package Task9;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Keyboard {
    private static int correctWords = 0;
    private static int totalCharacters = 0;
    private static int totalWords = 0;
    private static boolean timeUp = false;

    public static void main(String[] args) {
        List<String> words = getWords("C:\\Users\\veron\\IdeaProjects\\java_homework\\src\\main\\java\\Task9\\dictionary.txt");
        if (words.isEmpty()) {
            System.out.println("Словарь пуст или файл не найден.");
            return;
        }

        Random random = new Random();
        Scanner inputScanner = new Scanner(System.in);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("Время истекло!");
                timer.cancel();
            }
        }, 60000);

        System.out.println("Введите слова в течение минуты. Пишите быстро!");

        while (!timeUp) {
            String word = words.get(random.nextInt(words.size()));
            System.out.print("Введите слово: " + word + " -> ");
            String userInput = inputScanner.nextLine();

            if (timeUp) break;

            totalWords++;
            totalCharacters += userInput.length();

            if (userInput.equals(word)) {
                correctWords++;
            }
        }

        inputScanner.close();

        System.out.println("Результаты:");
        System.out.println("Количество слов всего: " + totalWords);
        System.out.println("Количество правильных слов: " + correctWords);
        System.out.println("Количество введенных символов: " + totalCharacters);
        double speed = (double) totalCharacters / 60;
        System.out.printf("Скорость (символов в секунду): %.2f\n", speed);
    }

    public static List<String> getWords(String path) {
        List<String> words = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine().trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + path);
        }
        return words;
    }
}
