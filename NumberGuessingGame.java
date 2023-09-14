import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 5;
        int userScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ". Try to guess it!");

            for (int attempts = 1; attempts <= numberOfAttempts; attempts++) {
                System.out.print("Attempt " + attempts + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    userScore++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }

                if (attempts == numberOfAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thank you for playing! Your score: " + userScore);
                break;
            }
        }

        scanner.close();
    }
}
