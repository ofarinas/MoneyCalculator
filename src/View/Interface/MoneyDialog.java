/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Interface;

import Modelo.Money;
import View.Console.ErrorViewer;

/**
 *
 * @author osvaldo
 */
public interface MoneyDialog {
    public Money getMoney();    
    public void execute()throws ErrorViewer;
}
