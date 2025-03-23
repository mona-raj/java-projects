// Slot Machine Program

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        double balance = 100;
        double betAmount = 0;
        char playAgain = 'Y';
        String[] symbols = {"❤️", "🍒", "🎁", "🥭", "💲", "🌞"};
        String[] result = new String[3];

        System.out.println("WELCOME TO SLOT MACHINE!!");
        System.out.printf("\nCurrent balance : %.2f\n", balance);

        while (balance > 0) {
            // Asking bet amount
            System.out.print("Place your bet amount: ");
            betAmount = scanner.nextDouble();
            scanner.nextLine();

            // Checking for bet amount
            if (betAmount <= 0) {
                System.out.println("Bet must be greater than zero");
                continue;
            } else if (betAmount > balance) {
                System.out.println("Insufficient balance");
                continue;
            } else {
                balance -= betAmount;
            }

            System.out.println("Spinning...");
            Thread.sleep(1000);

            // Generating slot machine result
            System.out.println("***********");
            for (int i = 0; i < 3; i++) {
                result[i] = symbols[random.nextInt(0,6)];
                System.out.print(result[i] + "  ");
                Thread.sleep(1000);
            }
            System.out.println();
            System.out.println("***********");

            // Declaring result
            if (!result[0].equals(result[1]) && !result[1].equals(result[2]) && !result[2].equals(result[0])) {
                System.out.println("Sorry, you lose this time");
            } else if (result[0].equals(result[1]) && result[1].equals(result[2])) {
                System.out.println("Congratulation! You won.");
                System.out.println("Credits won: 100");
                balance += 100;
            } else {
                System.out.println("Congratulation! You won.");
                System.out.println("Credits won: 50");
                balance += 50;
            }

            // Play again

                System.out.print("Do you want to play again? (Y/N) : ");
                playAgain = (scanner.nextLine().toUpperCase()).charAt(0);

            if (playAgain == 'N') {
                break;
            }
        }

        System.out.printf("\nGAME OVER\nBalance left : %.2f\n", balance);
        System.out.println("Thank you for playing");

        scanner.close();
    }
}
