/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Console;

import Modelo.Currency;
import View.Interface.CurrencyDialog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osvaldo
 */
public class ConsoleCurrencyDialog implements CurrencyDialog {

    Currency currency;

    @Override
    public void execute() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("Enter the change curreny");
                String line = reader.readLine();
                isCurrency(line);
                break;
            } catch (IOException ex) {
                Logger.getLogger(ConsoleCurrencyDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ErrorViewer e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void isCurrency(String line) throws ErrorViewer {
        if (!line.contains(" ") && !line.isEmpty()) {
            currency = new Currency(line.toUpperCase(), " ", " ");
        } else {
            throw new ErrorViewer("enter the valid currency");
        }
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }
}
