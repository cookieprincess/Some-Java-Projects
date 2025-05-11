import java.util.Scanner;
public class Banking{
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        double balance = 0.;
        boolean isRunning = true;
        int choice; //choice 1 for showBalance, 2 for deposit, 3 for withdraw, 4 for exist

        while(isRunning){
        System.out.println("***Banking Program***");
        System.out.println("1. Show Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");

        System.out.println("Enter your choice (1-4): ");
        choice = scanner.nextInt();

        switch(choice){
            case 1:
            showBalance(balance);
            break;
            case 2:
            balance = balance + deposit();
            break;
            case 3: 
            balance = balance - withdraw(balance);
            break;
            case 4:
            isRunning = false;
            break;
            default:
            System.out.println("Invalid Choice");
            case 5:
            scanner.close();
        }

        System.out.println("***Thank you! Have a nice day!***");
    }
    }

    static void showBalance(double balance){
        System.out.printf("$%.2f\n", balance);
    }
    //our main method is also static, hence this is static

    static double deposit(){
        double amount;

        System.out.print("Enter an amount to be deposited ");
        amount  = scanner.nextDouble();

        if(amount < 0){
            System.out.println("Amount can't be negative ");
            return 0;
        }
        else{
            System.out.println("Amount deposited!");
            return amount;
        }

    }

    static double withdraw(double balance){

        double amount;
        System.out.println("Enter the amount you want to be withdrawn");
        amount = scanner.nextDouble();

        if(amount > balance){
            System.out.println("Insufficient");
            return 0;
        }
        else if(amount < 0){
            System.out.println("Amount can't be negative");
            return 0;
        }
        else{
            return amount;
        }
    }

}
