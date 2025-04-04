import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<String> wordsList = new ArrayList<>();

        String filePath = "src//words.txt";
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                wordsList.add(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Could not locate file");
        }
        catch (IOException e) {
            System.out.println("Error: Could not read file");
        }

        String word = wordsList.get(random.nextInt(0, wordsList.size()));

        ArrayList<Character> list = new ArrayList<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            list.add('_');
        }

        System.out.println("\n## HANGMAN GAME ##\n");

        while (wrongGuesses != 6) {
            System.out.println("\nWord: " + list);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            // refreshing the guessed word
            if (word.contains(Character.toString(guess))) {
                System.out.println("Correct guess");

                for (int i = 0; i < word.length(); i++) {
                    if (guess == word.charAt(i)) {
                        list.set(i, guess);
                    }
                }
            }
            else {
                wrongGuesses++;
                System.out.println("Incorrect guess");
                // rendering graphic
                renderGraphic(wrongGuesses);
            }

            // checking if guessed word is complete
            String guessedWord = "";
            for (int i = 0; i < word.length(); i++) {
                guessedWord = guessedWord.concat(list.get(i).toString());
            }
            if (guessedWord.equals(word)) {
                System.out.println("YOU WIN!!!");
                break;
            }
            // checking if user is out of guesses
            if (wrongGuesses >= 6) {
                System.out.println("YOU LOSE!!!");
                System.out.println("Wrong guesses: " + wrongGuesses);
            }
        }

        // display original word
        System.out.println("The original words was: " + word);
        scanner.close();
    }

    public static void renderGraphic(int wrongGuesses) {
        String graphic;
        switch (wrongGuesses) {
            case 1 -> graphic =  """
                    O
                """;
            case 2 -> graphic =  """
                    O
                    |
                """;
            case 3 -> graphic =  """
                    O
                   /|
                """;
            case 4 -> graphic =  """
                    O
                   /|\\
                """;
            case 5 -> graphic =  """
                    O
                   /|\\
                   /
                """;
            case 6 -> graphic =  """
                    O
                   /|\\
                   / \\
                """;
            default -> graphic = "";
        }
        System.out.println("\n" + graphic + "\n");
    }
}
