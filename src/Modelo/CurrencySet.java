/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashSet;

/**
 *
 * @author osvaldo
 */
public class CurrencySet extends HashSet<Currency> {

    private static CurrencySet currencySet;

    private CurrencySet() {
        super();
    }

    public static CurrencySet getCurrencySet() {
        if (currencySet == null) {
            currencySet = new CurrencySet();
        }
        return currencySet;
    }

    public static Currency getCurrency(String code) {
        for (Currency item : currencySet) 
            if (item.getCode().equals(code)) return item;
                return null;           
            }
     public static boolean isCurrency(String code) {
        for (Currency item : currencySet) 
            if (item.getCode().equals(code)) return true;
                return false;           
            }
}
