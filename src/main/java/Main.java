import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Welcome to the NUM83R5 Game ***");

        printDifficultiesDescriptions();

        System.out.println("==> Enter a number from 1 to 3 to select difficulty level:");
        int level = 1;

        try (Scanner levelScanner = new Scanner(System.in);) {
            level = levelScanner.nextInt();
            System.out.println("LEVEL:" + level);

            if (level != 1 && level != 2 && level != 3) {
                System.out.println("Number out of range, please retry using number 1, 2 or 3");
                System.exit(0);
            }
        } catch (Exception error) {
            System.out.println("\n*** Please enter a valid input, try again");
            System.out.println("###> Error & Stack Trace:");
            error.printStackTrace();
            System.exit(0);
        }

        System.out.println("LEVEL:" + level);
        playGame(level);

    };

    public static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(11);
    };

    public static void printDifficultiesDescriptions() {
        String[] difficultyDescriptions = {
                "1 - Easy: guess a number - program will tell you if it was higher or equal(you win) or lower (computer wins) than the program's number.",
                "2 - Medium: guess a number - program will tell you if it was strictly higher(you win) or lower or equal (computer wins) than the program's number.",
                "3 - Hard: guess a number - program will tell you if it was equal (you win) or not (you lose) to the program's number."
        };

        System.out.println("Here are the Difficulty Descriptions of the game...");

        for (int i = 0; i < 3; i++) {
            System.out.println(difficultyDescriptions[i]);
        }
    };

    public static void playGame(int level) {
        System.out.println("level = " + level);
        System.out.println("==> Please Enter a number from 0 to 10:");

        try (Scanner scanner = new Scanner(System.in);) {
            int userInput = scanner.nextInt();

            int systemNumber = generateRandomNumber();

            if (userInput < 0 || userInput > 10) {
                System.out.println("Number out of range, please retry using a number from 0 to 10");
            } else {
                switch (level) {
                    case 1:
                        if (userInput >= systemNumber) {
                            System.out.println("YOU WON!  you:" + userInput + " sys:" + systemNumber);
                        } else {
                            System.out.println("HOUSE WINS! you:" + userInput + " sys:" + systemNumber);
                        }
                        break;
                    case 2:
                        if (userInput > systemNumber) {
                            System.out.println("YOU WON!  you:" + userInput + " sys:" + systemNumber);
                        } else {
                            System.out.println("HOUSE WINS! you:" + userInput + " sys:" + systemNumber);
                        }
                        break;
                    case 3:
                        if (userInput == systemNumber) {
                            System.out.println("YOU WON!  you:" + userInput + " sys:" + systemNumber);
                        } else {
                            System.out.println("HOUSE WINS! you:" + userInput + " sys:" + systemNumber);
                        }
                        break;
                    default:
                        System.out.println("Easter Egg... how did you get here?");
                        break;
                }

            }

        } catch (Exception error) {
            System.out.println("\n*** Please enter a valid input, try again");
            System.out.println("###> Error & Stack Trace:");
            error.printStackTrace();
            System.exit(0);
        }
    };

}
