// Dice Roller Program

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int noOfDice = 0, diceValue, sum = 0;

        System.out.print("Enter number of dice to roll: ");
        noOfDice = scanner.nextInt();

        if (noOfDice < 0) {
            System.out.println("You cannot roll negative number of dice");
        } else if (noOfDice == 0) {
            System.out.println("No dice rolled");
        } else {
            for (int i = 0; i < noOfDice; i++) {
                diceValue = random.nextInt(1, 7);
                System.out.println("You rolled: " + diceValue);
                sum += diceValue;
                Thread.sleep(1000);
            }

            System.out.println("Sum of all rolls: " + sum);
        }

        scanner.close();
    }
}
