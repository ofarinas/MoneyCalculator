/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moneycalculator;

import ConsoleControl.ConsoleControl;
import Persisten.DBCurrencySetLoader;
import Persisten.DBExchangeRateLoader;
import Persisten.Interface.CurrencySetLoader;
import Persisten.Interface.ExchangeRateLoader;
import View.Console.ConsoleCurrencyDialog;
import View.Console.ConsoleMoneyDialog;
import View.Interface.CurrencyDialog;
import View.Interface.MoneyDialog;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author osvaldo
 */
public class Aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Aplication.execute();
    }

    private static void execute() throws FileNotFoundException, IOException {

        ConsoleControl control = new ConsoleControl(createMoneyDialog(), 
                                                            createCurrencyDialog(),
                                                            createExchangeRateLoader(),
                                                            createCurrencySetLoader()
                                                             );
       control.execute();
    }

    public static MoneyDialog createMoneyDialog() {
        return new ConsoleMoneyDialog();
    }

    public static CurrencyDialog createCurrencyDialog() {
        return new ConsoleCurrencyDialog();
    }
    public static ExchangeRateLoader createExchangeRateLoader() {
        return new DBExchangeRateLoader();
    }
    public static CurrencySetLoader createCurrencySetLoader() {
        return new DBCurrencySetLoader();
    }
}
