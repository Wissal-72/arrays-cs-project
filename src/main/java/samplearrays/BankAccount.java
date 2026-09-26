package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    private static double[] transactions = new double[1000];

    public BankAccount(String name, int startingBalance){
        currentBalance = startingBalance;
        this.name = name;

        System.out.println("The starting balance of "+ name + "'s account is : "+ currentBalance);
    }

    public void deposit(double amount){
        if (amount<=0)  System.out.println("Deposit unsuccessful");

        else {
            currentBalance+=amount;
            for(int i = 0  ; i<transactions.length ; i++){
                if (transactions[i]==0){
                    transactions[i]= amount;
                    break;
                }
            }

            System.out.println(name+ " deposited " + amount+"MAD successfully");
        }

    }

    public void withdraw(double amount){
        if (amount> currentBalance)  System.out.println("Insufficient balance");

        else {
            currentBalance-=amount;
            for(int i = 0  ; i<transactions.length ; i++){
                if (transactions[i]==0){
                    transactions[i]= - amount;
                    break;
                }
            }

            System.out.println(name+ " Withdrew " + amount+"MAD successfully");
        }
    }

    public void displayTransactions(){
        System.out.println("transactions List :");
        int i = 0;
        while (transactions[i]!=0){
            System.out.println("  "+transactions[i]+" MAD");
            i++;
        }
    }

    public void displayBalance(){
        System.out.println("Current Balance : " +currentBalance+" MAD");
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
