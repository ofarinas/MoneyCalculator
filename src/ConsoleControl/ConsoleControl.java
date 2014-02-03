/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsoleControl;

import Modelo.Currency;
import Modelo.CurrencySet;
import Modelo.ExchangeRate;
import Modelo.Money;
import Modelo.MoneyExchanger;
import Persisten.Interface.CurrencySetLoader;
import Persisten.Interface.ExchangeRateLoader;
import View.Console.ErrorViewer;
import View.Console.ConsoleMoneyViwer;
import View.Interface.CurrencyDialog;
import View.Interface.MoneyDialog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author osvaldo
 */
public class ConsoleControl {

    private MoneyDialog moneyDialogo;
    private CurrencyDialog currencyDialog;
    private ExchangeRateLoader exchangeRateLoader;
    private CurrencySetLoader currencySetLoader;

    public ConsoleControl(MoneyDialog moneyDialogo, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, CurrencySetLoader currencySetLoader) {
        this.moneyDialogo = moneyDialogo;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.currencySetLoader = currencySetLoader;
    }

    public void execute() throws FileNotFoundException, IOException {
        while (true) {
            try {
                loadCurrency();
                readMoneyAndCurrency();
                showMoney();
            } catch (ErrorViewer e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void readMoneyAndCurrency() throws ErrorViewer {
        readMoney();
        readCurrency();
    }

    private void loadCurrency() {
        currencySetLoader.load();
    }

    private void checkCurrency(Currency currency ) throws ErrorViewer {
        if (CurrencySet.getCurrency(currency.getCode()) == null) {
            throw new ErrorViewer("Enter a valid currency");
        }
    }

    private void readMoney() throws ErrorViewer {
        moneyDialogo.execute();
        checkCurrency(moneyDialogo.getMoney().getCurrency() );
    }

    private void readCurrency() throws ErrorViewer {
        while(true){
        try{
            currencyDialog.execute();
        checkCurrency(currencyDialog.getCurrency());
        break;
        }catch (ErrorViewer e){
            System.out.println(e.getMessage());
        }
        }
    }

   

    private ExchangeRate loadExchangeRste() {
        return exchangeRateLoader.load(currencyDialog.getCurrency(),
                moneyDialogo.getMoney().getCurrency(),
                new Date());
    }

    private void showMoney() {
        Money money = MoneyExchanger.ExchangeRate(moneyDialogo.getMoney(), loadExchangeRste());
        new ConsoleMoneyViwer().show(money);

    }
}
