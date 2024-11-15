package Task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HangmanGame {
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        List<String> all_words = getWords("C:\\Users\\veron\\IdeaProjects\\java_homework\\src\\main\\java\\Task10\\dictionary.txt");
        if (all_words.isEmpty()) {
            System.out.println("Словарь пуст или файл не найден.");
            return;
        }
        Collections.shuffle(all_words);
        List<String> words = new ArrayList<>();
        for (String word : all_words){
            if (word.length() > 3 && word.length() <= 10){
                words.add(word);
            }
        }

        Scanner scanner = new Scanner(System.in);
        int index = 0;

        while (true) {
            String wordToGuess = words.get(index);
            List<Character> guessedWord = new ArrayList<>();
            Set<Character> guessedLetters = new HashSet<>();

            for (int i = 0; i < wordToGuess.length(); i++) {
                guessedWord.add('_');
            }

            int attemptsLeft = MAX_ATTEMPTS;
            boolean wordGuessed = false;

            System.out.println("Добро пожаловать в игру 'Виселица'!");

            while (attemptsLeft > 0 && !wordGuessed) {
                System.out.print("Загаданное слово: ");
                for (char c : guessedWord) {
                    System.out.print(c + " ");
                }
                System.out.println();

                System.out.print("Введите букву: ");
                char guessedLetter = scanner.nextLine().toLowerCase().charAt(0);

                if (guessedLetters.contains(guessedLetter)) {
                    System.out.println("Вы уже пробовали эту букву!");
                    continue;
                }

                guessedLetters.add(guessedLetter);

                if (wordToGuess.indexOf(guessedLetter) >= 0) {
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (wordToGuess.charAt(i) == guessedLetter) {
                            guessedWord.set(i, guessedLetter);
                        }
                    }
                } else {
                    attemptsLeft--;
                    System.out.println("Неверно! Осталось попыток: " + attemptsLeft);
                }

                if (!guessedWord.contains('_')) {
                    wordGuessed = true;
                }
            }

            if (wordGuessed) {
                System.out.println("Поздравляем! Вы угадали слово: " + wordToGuess);
            } else {
                System.out.println("Вы проиграли! Загаданное слово было: " + wordToGuess);
            }

            index++;

            System.out.print("Хотите сыграть снова? (да/нет): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("да")) {
                break;
            }

            if (index == words.size()){
                System.out.println("Вы угадали все слова!");
                break;
            }
        }
        scanner.close();
        System.out.println("Спасибо за игру!");
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
