import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Number  Game!");
		
        System.out.println("Enter the maximum number for the range: ");
        int upperBound = sc.nextInt();

        int numberGuess = (int) (Math.random() * upperBound) + 1;

        int numberTries = 0;
        boolean Guessed = false;

        System.out.println("I have selected a number between 1 and " + upperBound);

        while (!Guessed) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            numberTries++;

            if (userGuess == numberGuess) {
                Guessed = true;
            } else if (userGuess < numberGuess) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        System.out.println("Congratulations! You guessed the number in " + numberTries + " tries.");
    }
}