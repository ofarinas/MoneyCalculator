/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Console;

import Modelo.Money;
import View.Interface.MoneyViewer;

/**
 *
 * @author osvaldo   
 */
public class ConsoleMoneyViwer implements MoneyViewer{

    @Override
    public void show( Money money){
        System.out.println("The change is:"+money.getAmount()+" "+money.getCurrency().getCode());
    }
}
