import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void display() {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amt to withdraw: ");
                    double withdrawAmt = sc.nextDouble();
                    withdraw(withdrawAmt);
                    break;
                case 2:
                    System.out.print("Enter amt to deposit: ");
                    double depositAmt = sc.nextDouble();
                    deposit(depositAmt);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    flag = true;
                    System.out.println("Thank you for using the ATM. bye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again!!!");
            }
        }

        sc.close();
    }

    public void withdraw(double amt) {
        if (amt > 0 && bankAccount.getBalance() >= amt) {
            bankAccount.withdraw(amt);
            System.out.println("Withdrawal successful. New balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid amt.");
        }
    }

    public void deposit(double amt) {
        if (amt > 0) {
            bankAccount.deposit(amt);
            System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Invalid amt.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);
        ATM atm = new ATM(account);
        atm.display();
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if (amt > 0) {
            balance += amt;
        }
    }

    public void withdraw(double amt) {
        if (amt > 0 && balance >= amt) {
            balance -= amt;
        }
    }
}
