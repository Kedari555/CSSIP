import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM and Number Guessing Game!");

        while (true) {
            System.out.println("1. ATM\n2. Number Guessing Game\n3. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    atm(scanner);
                    break;
                case 2:
                    numberGuessingGame(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void atm(Scanner scanner) {
        double balance = 1000.0;

        while (true) {
            System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Back");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0 && withdrawalAmount <= balance) {
                        balance -= withdrawalAmount;
                        System.out.println("Withdrawal successful. New balance: $" + balance);
                    } else {
                        System.out.println("Insufficient funds or invalid amount.");
                    }
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        System.out.println("Deposit successful. New balance: $" + balance);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 3:
                    System.out.println("Current balance: $" + balance);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void numberGuessingGame(Scanner scanner) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        while (true) {
            System.out.print("Guess a number between 1 and 100: ");
            int userGuess = scanner.nextInt();

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            } else if (userGuess < secretNumber) {
                System.out.println("Your guess is too low. Try again!");
            } else {
                System.out.println("Your guess is too high. Try again!");
            }
        }
    }
}