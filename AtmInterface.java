import java.util.Scanner;

public class AtmInterface {
    private double balance;
    private String accountNumber;
    private String pin;

    public AtmInterface(String accountNumber, String pin, double Balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = Balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Balance: $" + balance);
    }

    public boolean authenticate(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public static void main(String[] args) {
        AtmInterface atm = new AtmInterface("UNI1J72165", "2512", 1000.0);
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter your account number: ");
        String enteredAccountNumber = sc.next();

        System.out.print("Enter your PIN: ");
        String enteredPin = sc.next();

        if (atm.authenticate(enteredPin) && enteredAccountNumber.equals(atm.accountNumber)) {
            int choice;
            do {
                System.out.println("ATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Select an option (1/2/3/4): ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawalAmount = sc.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Authentication failed.");
        }

    
    }
}

