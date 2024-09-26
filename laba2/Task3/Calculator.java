package org.example;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculate calculate = new Calculate();

        while (true) {
            System.out.print("Введите первое число (или 'exit' для выхода): ");
            String input1 = scanner.next();

            if (input1.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы.");
                break;
            }

            try {
                double num1 = Double.parseDouble(input1);

                System.out.print("Введите оператор (+, -, *, /): ");
                char operator = scanner.next().charAt(0);

                System.out.print("Введите второе число: ");
                double num2 = Double.parseDouble(scanner.next());

                double result = 0;

                switch (operator) {
                    case '+':
                        result = calculate.add(num1, num2);
                        break;
                    case '-':
                        result = calculate.subtract(num1, num2);
                        break;
                    case '*':
                        result = calculate.multiply(num1, num2);
                        break;
                    case '/':
                        result = calculate.divide(num1, num2);
                        break;
                    default:
                        System.out.println("Неверный оператор.");
                        continue;
                }

                System.out.println("Результат: " + result + "\n");

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введите корректное число.");
            } catch (ArithmeticException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
