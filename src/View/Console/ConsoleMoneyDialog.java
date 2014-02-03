/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Console;

import Modelo.Money;
import Modelo.Currency;
import Numeric.NumericRestriction;
import View.Interface.MoneyDialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osvaldo
 */
public class ConsoleMoneyDialog implements MoneyDialog {

    private Money money;

    public ConsoleMoneyDialog() {
    }

    @Override
    public void execute() throws ErrorViewer {
        try {
            System.out.println("what is the money that you want to change , enter amount and currency ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            correctlyParameter(line);
            money = new Money(Double.valueOf(Double.valueOf(line.split(" ")[0])),
                                             new Currency(line.split(" ")[1].toUpperCase(), " ", " ")
                                              );
        } catch (IOException ex) {
            Logger.getLogger(ConsoleMoneyDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void correctlyParameter(String line) throws ErrorViewer {
        if (proofreader(line)) {
            throw new ErrorViewer("Enter 2 parameter ");
        } else if (!NumericRestriction.isNumber(line.split(" ")[0])) 
            throw new ErrorViewer("Enter a number ");
    }

    public boolean proofreader(String line) {
        if (!line.contains(" ") || line.isEmpty() || line.split(" ").length != 2)  return true;
        return false;
    }

    @Override
    public Money getMoney() {
        return money;
    }
}
