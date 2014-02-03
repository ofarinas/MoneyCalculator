/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Interface;

import Modelo.Currency;
import View.Console.ErrorViewer;

/**
 *
 * @author osvaldo
 */
public interface CurrencyDialog {
public Currency getCurrency();    

    public void execute() throws ErrorViewer;
}
