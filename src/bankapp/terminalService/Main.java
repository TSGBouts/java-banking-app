package bankapp.terminalService;

import bankapp.terminalUI.BankConsoleUI;
import bankapp.terminalUI.ConsoleLoginUI;
import bankapp.terminalUI.SearchIbanToAccountUI;

public class Main{
    public static void main(String[] args) {
        new BankConsoleUI().createAccountController(new ConsoleLoginUI().promptFirstLogin(), new IbanGenerator(), new SearchIbanToAccountUI());
    }
}