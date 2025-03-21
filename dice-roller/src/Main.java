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
                printDice(diceValue);
                System.out.println("You rolled: " + diceValue);
                System.out.println();
                sum += diceValue;
                Thread.sleep(1000);
            }

            System.out.println("Sum of all rolls: " + sum);
        }

        scanner.close();
    }
    static void printDice(int diceValue) {
        String dice1 = """
                ---------
                |       |
                |   ●   |
                |       |
                ---------""";
        String dice2 = """
                ---------
                |     ● |
                |       |
                | ●     |
                ---------""";
        String dice3 = """
                ---------
                |     ● |
                |   ●   |
                | ●     |
                ---------""";
        String dice4 = """
                ---------
                | ●   ● |
                |       |
                | ●   ● |
                ---------""";
        String dice5 = """
                ---------
                | ●   ● |
                |   ●   |
                | ●   ● |
                ---------""";
        String dice6 = """
                ---------
                | ●   ● |
                | ●   ● |
                | ●   ● |
                ---------""";

        switch (diceValue) {
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
        }
    }

}
