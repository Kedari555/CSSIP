import java.util.Scanner;

public class ATM {
    private double balance;
    private int userId;
    private int userPin;

    public ATM(int userId, int userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int inputUserId, inputUserPin;
        System.out.println("Enter your user ID:");
        inputUserId = scanner.nextInt();
        System.out.println("Enter your PIN:");
        inputUserPin = scanner.nextInt();

        if (validateUser(inputUserId, inputUserPin)) {
            while (true) {
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.println("Choose an option:");
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter amount to withdraw:");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit:");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            }
        } else {
            System.out.println("Invalid user ID or PIN.");
        }
    }

    private boolean validateUser(int userId, int userPin) {
        return this.userId == userId && this.userPin == userPin;
    }

    private void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    private void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1234, 1234, 1000.0);
        atm.start();
    }
}