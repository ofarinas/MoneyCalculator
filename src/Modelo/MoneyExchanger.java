/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.text.DecimalFormat;

/**
 *
 * @author osvaldo
 */
public class MoneyExchanger {

    public static Money ExchangeRate(Money money,ExchangeRate exchangeRate){
        return new Money(calculateRate( money,exchangeRate ), exchangeRate.to);
    }

    private static double calculateRate(Money money, ExchangeRate exchangeRate) {
        double temp=money.amount*exchangeRate.rate;
        DecimalFormat decimal=new DecimalFormat("0.00");
         String format=decimal.format(temp);
         return Double.valueOf(format);
    }
}
