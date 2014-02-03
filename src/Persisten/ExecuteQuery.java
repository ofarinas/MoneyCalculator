/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persisten;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author osvaldo
 */
public class ExecuteQuery {
    Statement statement;

    public ExecuteQuery(Statement statement) {
        this.statement = statement;
    }
    
    public ResultSet execute(String query) throws SQLException{
              return statement.executeQuery(query);
     
    }
}
