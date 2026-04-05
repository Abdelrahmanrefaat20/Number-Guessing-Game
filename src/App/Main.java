package App;
import java.util.Scanner;
import Game.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();
        while (true) {
            boolean won = false;
            Game game = new Game(1, 100);
            System.out.println("Welcome! Guess a number between 1 and 100. You have 10 attempts.");
            while (!game.isGameOver()) {
                int attemptNum = game.getAttempts() + 1;
                System.out.print("Attempt " + attemptNum + "/" + game.getMaxAttempts() + " — Enter your guess: ");

                String input = sc.next();

                if (!validator.isValidNumber(input)) {
                    System.out.println("Invalid input");
                    continue;
                }

                int guess = Integer.parseInt(input);

                if (!validator.inRange(1, 100, guess)) {
                    System.out.println("Out of range");
                    continue;
                }

                String result = game.checkGuess(guess);

                if (result.equals("Correct")) {
                    System.out.println("Correct! You guessed it in " + game.getAttempts() + " attempts.");
                    won = true;
                    break;
                }
                System.out.println(result + " " + game.getRemaining() + " attempts remaining.");
            }
            if (game.getRemaining() == 0 || !won ) {
                System.out.println("You lose. The number was: " + game.getNumber());
            }
            System.out.print("Play again? (yes/no): ");
            String again = sc.next();
            if (!again.equalsIgnoreCase("yes")) {
                break;
            }

        }
    }
}