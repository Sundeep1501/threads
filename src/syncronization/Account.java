package syncronization;

public class Account {
    private String name;
    private double balance;

    Account(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
    }

    synchronized void deposit(double amount) {
        balance+=amount;
    }

    synchronized void withdrawal(double amount) throws IllegalArgumentException {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance-=amount;
    }

    @Override
    public String toString() {
        return "Account:{name:" + name + ", balance:" + balance + "}";
    }
}