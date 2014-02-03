/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author osvaldo
 */
public class ExchangeRate {
Currency from;
Currency to;
Date date;
double rate;

    public ExchangeRate(Currency from, Currency to, Date date, double rate) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }


    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public Date getDate() {
        return date;
    }

}
