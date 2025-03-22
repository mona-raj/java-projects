// Rock paper scissors game

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        String[] choices = {"rock", "paper", "scissors"};
        String userMove, computerGuess;
        String playGame = "yes";

        while(playGame.equals("yes")) {
            System.out.println("ROCK PAPER SCISSORS!");
            System.out.print("Enter your move(rock, paper, scissors) : ");
            userMove = scanner.nextLine().toLowerCase();

            if (!userMove.equals("rock") && !userMove.equals("paper") && !userMove.equals("scissors")) {
                System.out.println("Invalid choice");
                continue;
            } else {
                Thread.sleep(1000); // Wait to create suspense

                computerGuess = choices[random.nextInt(0, 3)];
                System.out.println("Computer's move: " + computerGuess);

                checkGame(userMove, computerGuess);
            }

            System.out.print("Do you want to play again(yes/no) : ");
            playGame = scanner.next().toLowerCase();
            scanner.nextLine();

            if(!playGame.equals("yes") && !playGame.equals("no")) {
                System.out.println("Invalid choice");
            }
        }

        System.out.println("Thanks for playing");

        scanner.close();
    }
    public static void checkGame(String userMove, String computerGuess) {
        if (computerGuess.equals(userMove)) {
            System.out.println("Its a tie!");
        } else if ((userMove.equals("rock") && computerGuess.equals("scissors")) ||
                ((userMove.equals("paper") && computerGuess.equals("rock"))) ||
                ((userMove.equals("scissors") && computerGuess.equals("paper")))) {
            System.out.println("You win! 😄");
        } else {
            System.out.println("You lose! 😔");
        }
    }
}
