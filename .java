import java.util.Scanner;

public class BankingApplication {

    // Account class (to store one account information)
    static class Account {
        int accNo;
        String name;
        double balance;
        String email;
        String phone;

        // constructor
        Account(int accNo, String name, double balance, String email, String phone) {
            this.accNo = accNo;
            this.name = name;
            this.balance = balance;
            this.email = email;
            this.phone = phone;
        }

        // add money
        void deposit(double amt) {
            if (amt > 0) {
                balance += amt;
                System.out.println("Money added. New balance = " + balance);
            } else {
                System.out.println("Amount must be positive.");
            }
        }

        // withdraw money
        void withdraw(double amt) {
            if (amt > 0 && amt <= balance) {
                balance -= amt;
                System.out.println("Money taken. New balance = " + balance);
            } else if (amt > balance) {
                System.out.println("Not enough balance.");
            } else {
                System.out.println("Amount must be positive.");
            }
        }

        // show account info
        void showDetails() {
            System.out.println("\n--- Account Info ---");
            System.out.println("Account No: " + accNo);
            System.out.println("Name: " + name);
            System.out.println("Balance: " + balance);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phone);
            System.out.println("--------------------");
        }

        // change email and phone
        void updateContact(String newEmail, String newPhone) {
            email = newEmail;
            phone = newPhone;
            System.out.println("Contact updated.");
        }
    }

    // array to store many accounts
    static Account[] accounts = new Account[100];
    static int accCount = 0;
    static int nextAccNo = 1001; // first account number
    static Scanner sc = new Scanner(System.in);

    // make a new account
    static void createAccount() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter starting money: ");
        double money = sc.nextDouble();
        sc.nextLine(); // clear buffer

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        accounts[accCount] = new Account(nextAccNo, name, money, email, phone);
        System.out.println("Account created with number: " + nextAccNo);

        accCount++;
        nextAccNo++;
    }

    // add money to account
    static void depositMoney() {
        System.out.print("Enter account no: ");
        int no = sc.nextInt();
        System.out.print("Enter money to add: ");
        double amt = sc.nextDouble();

        Account a = findAccount(no);
        if (a != null) {
            a.deposit(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    // take money from account
    static void withdrawMoney() {
        System.out.print("Enter account no: ");
        int no = sc.nextInt();
        System.out.print("Enter money to take: ");
        double amt = sc.nextDouble();

        Account a = findAccount(no);
        if (a != null) {
            a.withdraw(amt);
        } else {
            System.out.println("Account not found.");
        }
    }

    // show details
    static void showAccount() {
        System.out.print("Enter account no: ");
        int no = sc.nextInt();

        Account a = findAccount(no);
        if (a != null) {
            a.showDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    // update email and phone
    static void updateContact() {
        System.out.print("Enter account no: ");
        int no = sc.nextInt();
        sc.nextLine(); // clear buffer

        System.out.print("Enter new email: ");
        String email = sc.nextLine();
        System.out.print("Enter new phone: ");
        String phone = sc.nextLine();

        Account a = findAccount(no);
        if (a != null) {
            a.updateContact(email, phone);
        } else {
            System.out.println("Account not found.");
        }
    }

    // find account by number
    static Account findAccount(int no) {
        for (int i = 0; i < accCount; i++) {
            if (accounts[i].accNo == no) {
                return accounts[i];
            }
        }
        return null;
    }

    // menu
    static void menu() {
        while (true) {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Show Account");
            System.out.println("5. Update Contact");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (ch) {
                case 1: createAccount(); break;
                case 2: depositMoney(); break;
                case 3: withdrawMoney(); break;
                case 4: showAccount(); break;
                case 5: updateContact(); break;
                case 6: 
                    System.out.println("Thank you for using bank app.");
                    return;
                default: 
                    System.out.println("Wrong choice.");
            }
        }
    }

    // main method
    public static void main(String[] args) {
        menu();
    }
}
