/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persisten;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author osvaldo
 */
public class Conection {

    private String userName;
    private String password;
    private String url;

    public Conection() {
        userName = "system";
        password = "orcl";
        url = "jdbc:oracle:thin:@" + "localhost:101:orcl";
    }

    public Statement conect() throws SQLException {
         DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        return DriverManager.getConnection(url, userName, password).createStatement();

    }
}
