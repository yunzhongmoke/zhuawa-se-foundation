package homework.account;

public class Test {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(2000);
//        System.out.println(checkingAccount.getBalance());
//        checkingAccount.deposit(100);
//        System.out.println(checkingAccount.getBalance());
        SavingAccount saving = new SavingAccount(2000);
        saving.deposit(100);
        saving.deposit(100);
        saving.deposit(100);
        saving.deposit(100);
        System.out.println(saving.getBalance());
        saving.earnMonthlyInterest();
        System.out.println(saving.getBalance());
        saving.deposit(100);
        saving.deposit(100);
        saving.deposit(100);
        saving.deposit(100);
        saving.deposit(100);
        System.out.println(saving.getBalance());


    }
}
