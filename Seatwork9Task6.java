import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Seatwork9Task6 {

    public static void main(String[] args) {

        String filePath = "words.txt";
        ArrayList<String> words = new ArrayList<>();

        // Read words from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line.trim().toLowerCase());
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file.");
            return;
        }

        if (words.isEmpty()) {
            System.out.println("No words found.");
            return;
        }

        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));

        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> wordState = new ArrayList<>();
        ArrayList<Character> guessedLetters = new ArrayList<>();
        int wrongGuesses = 0;

        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("************************");
        System.out.println("Welcome to Java Hangman!");
        System.out.println("************************");

        while (wrongGuesses < 6) {

            System.out.println(getHangmanArt(wrongGuesses));

            System.out.print("Word: ");
            for (char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();

            System.out.println("Guessed letters: " + guessedLetters);

            System.out.print("Guess a letter: ");
            String input = scanner.next().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Enter a single letter only.");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that!");
                continue;
            }

            guessedLetters.add(guess);

            if (word.indexOf(guess) >= 0) {
                System.out.println("Correct!");

                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }

                if (!wordState.contains('_')) {
                    System.out.println("YOU WIN!");
                    System.out.println("The word was: " + word);
                    scanner.close();
                    return;
                }

            } else {
                wrongGuesses++;
                System.out.println("Wrong!");
            }
        }

        System.out.println(getHangmanArt(wrongGuesses));
        System.out.println("GAME OVER!");
        System.out.println("The word was: " + word);

        scanner.close();
    }

    // OLD STYLE SWITCH (Java 8 Compatible)
    static String getHangmanArt(int wrongGuesses) {

        switch (wrongGuesses) {

            case 0:
                return "\n\n\n";

            case 1:
                return "   o\n\n\n";

            case 2:
                return "   o\n   |\n\n";

            case 3:
                return "   o\n  /|\n\n";

            case 4:
                return "   o\n  /|\\\n\n";

            case 5:
                return "   o\n  /|\\\n  /\n";

            case 6:
                return "   o\n  /|\\\n  / \\\n";

            default:
                return "";
        }
    }
}
