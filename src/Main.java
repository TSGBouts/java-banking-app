//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Customer me = FirstLogin.customer();
        Bank bank = new Bank(me);
        bank.Loop();
        System.out.println(me.getAccount().getBankAccount().getIBAN());
    }
}