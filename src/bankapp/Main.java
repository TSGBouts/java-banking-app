package bankapp;

import bankapp.GUI.MyApp;
import bankapp.terminalUI.BankConsoleUI;
import bankapp.terminalUI.ConsoleLoginUI;
import bankapp.terminalUI.SearchIbanToAccountUI;

public class Main{
    public static void main(String[] args) {
        javafx.application.Application.launch(MyApp.class, args);
        new BankConsoleUI().createAccountController(new ConsoleLoginUI().promptFirstLogin(), new IbanGenerator(), new SearchIbanToAccountUI());
    }
}