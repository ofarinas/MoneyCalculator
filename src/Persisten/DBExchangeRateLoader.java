/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persisten;

import Modelo.Currency;
import Modelo.ExchangeRate;
import Persisten.Interface.ExchangeRateLoader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author osvaldo
 */
public class DBExchangeRateLoader implements ExchangeRateLoader{

    @Override
    public ExchangeRate load(Currency to, Currency from, Date date) {
        return new ExchangeRate(from, to, date, lookForRaet(to, from));
    }
    private double lookForRaet(Currency to, Currency from) {
        try {
            String query="select cambio from historico_cambios "
                    + "where divisa_desde='" + from.getCode() + "' and divisa_a='"+ to.getCode()+"'";
            ResultSet resulSet = new ExecuteQuery(new Conection().conect()).execute(query);
            while (resulSet.next()) 
                return resulSet.getDouble(1);
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return 0;
    }
}
