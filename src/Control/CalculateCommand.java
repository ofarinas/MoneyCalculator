package Control;

import Modelo.ExchangeRate;
import Modelo.Money;
import Modelo.MoneyExchanger;
import Persisten.DBExchangeRateLoader;
import View.Interface.CurrencyDialog;
import View.Interface.MoneyDialog;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author osvaldo
 */
public class CalculateCommand extends Command {

    MoneyDialog moneyDialog;
    CurrencyDialog currencyDialog;
    Money moneyExhanger;
    // ExchangeRateLoader exchangeRateLoader;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
    }

    public Money getMoneyExhanger() {
        return moneyExhanger;
    }

    @Override
    public void execute() {
     
        if (checkMoneyAndCurrency() ){
        moneyExhanger = MoneyExchanger.ExchangeRate(moneyDialog.getMoney(),createExgangeLoader());
        JOptionPane.showConfirmDialog(null, "The change is:" + moneyExhanger.getAmount()+ " "
                + "" + moneyExhanger.getCurrency().getCode());
        }else JOptionPane.showMessageDialog(null, "You can enter two currency diferent");
          
         
    }

    private ExchangeRate createExgangeLoader() {
        return new DBExchangeRateLoader().load(currencyDialog.getCurrency(),
                moneyDialog.getMoney().getCurrency(),
                new Date());
    }

    private boolean checkMoneyAndCurrency() {
    if(!moneyDialog.getMoney().getCurrency().getCode().equals(currencyDialog.getCurrency().getCode()))return true;
    return false;
    }
}
