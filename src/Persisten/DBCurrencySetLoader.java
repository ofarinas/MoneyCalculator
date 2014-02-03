/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persisten;

import Modelo.Currency;
import Modelo.CurrencySet;
import Persisten.Interface.CurrencySetLoader;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author osvaldo
 */
public class DBCurrencySetLoader implements CurrencySetLoader {

    @Override
    public CurrencySet load() {
        Conection c = new Conection();
        try {
            if (CurrencySet.getCurrencySet().isEmpty()) {
                CurrencySet.getCurrencySet().add(new Currency("EUR", "Euro", null));
                ResultSet resulSet = new ExecuteQuery(c.conect()).execute("select * from cambio_eur_a");
                while (resulSet.next()) {
                    insertCurrency(resulSet);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return CurrencySet.getCurrencySet();
    }

    private static void insertCurrency(ResultSet resulSet) throws SQLException {
        CurrencySet.getCurrencySet().add(new Currency(resulSet.getString(1), null, null));
    }
}
