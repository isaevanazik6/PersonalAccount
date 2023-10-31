import java.util.ArrayList;

class Amount {
    private double amount;
    private String transactionType;

    public Amount(double amount, String transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }
}

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<Amount> transactions;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactions.add(new Amount(amount, "Deposit"));
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            transactions.add(new Amount(amount, "Withdrawal"));
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for Account Number: " + accountNumber);
        for (Amount transaction : transactions) {
            System.out.println("Type: " + transaction.getTransactionType() + ", Amount: $" + transaction.getAmount());
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public static void main(String[] args) {
        PersonalAccount account = new PersonalAccount(1001, "John Doe");

        account.deposit(1000);
        account.withdraw(500);
        account.deposit(200);
        account.withdraw(300);

        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Current Balance: $" + account.getBalance());

        account.printTransactionHistory();
    }
}

