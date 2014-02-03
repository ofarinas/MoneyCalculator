/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persisten.Interface;

import Modelo.Currency;
import Modelo.ExchangeRate;
import java.util.Date;

/**
 *
 * @author osvaldo
 */
public interface ExchangeRateLoader {
public ExchangeRate load(Currency to , Currency from ,Date date);
}
