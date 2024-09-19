import java.util.Random;
import java.util.Scanner;
public class GuessTheNumberGame {
    public static void playGame(int maxAttempts, int maxRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(maxRange) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number between 1 and " + maxRange + ": ");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
                break;
            } else if (userGuess > randomNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Too low! Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all attempts. The correct number was: " + randomNumber);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");
        
        while (playAgain) {
            int maxAttempts = 5;
            int maxRange = 100;

            playGame(maxAttempts, maxRange);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("yes")) {
                score++;
            } else {
                playAgain = false;
            }
        }
        System.out.println("Thanks for playing! Your score: " + score + " round(s) won.");
    }
}
