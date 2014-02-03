/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Console;

import Modelo.Currency;
import Modelo.CurrencySet;

/**
 *
 * @author osvaldo
 */
public class ConsoleCurrencyViewer {

    public void show() {
        for (Currency item : CurrencySet.getCurrencySet()) {
            System.out.println("la divisa es:"+item.getCode());
        }
    }
}
