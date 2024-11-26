import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        // Ініціалізація випадкового числа та інших змінних
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1; // Число від 1 до 100
        Scanner scanner = new Scanner(System.in);
        int guess;
        int attempts = 0;
        int lowerBound = 1;
        int upperBound = 100;
        boolean guessedCorrectly = false;

        System.out.println("Гра 'Вгадай число'!");
        System.out.println("Комп'ютер загадав число від 1 до 100. Спробуйте його вгадати!");

        // Цикл гри
        while (!guessedCorrectly) {
            System.out.println("Число знаходиться в діапазоні від " + lowerBound + " до " + upperBound + ".");
            System.out.print("Введіть ваше число: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Вітаємо! Ви вгадали число " + targetNumber + " за " + attempts + " спроб.");
                guessedCorrectly = true;
            } else if (guess < targetNumber) {
                System.out.println("Загадане число більше!");
                lowerBound = Math.max(lowerBound, guess + 1);
                // Додаткове звуження верхньої межі
                upperBound = (upperBound + targetNumber) / 2;
            } else {
                System.out.println("Загадане число менше!");
                upperBound = Math.min(upperBound, guess - 1);
                // Додаткове звуження нижньої межі
                lowerBound = (lowerBound + targetNumber) / 2;
            }

            // Перевірка, чи діапазон залишився коректним
            if (lowerBound > upperBound) {
                System.out.println("Помилка! Діапазон звужений некоректно. Гра завершується.");
                break;
            }
        }

        scanner.close();
    }
}
