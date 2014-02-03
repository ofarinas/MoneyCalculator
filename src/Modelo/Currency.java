/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author osvaldo
 */
public class Currency {
    String code;
    String symbol;
    String nombre;

    public Currency(String code,String symbol,String nombre) {
        this.code = code;
        this.symbol = symbol;
        this.nombre = nombre;
    }

//    public Currrency(String code) {
//       Currrency(code," "," ");
//    }
    

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNombre() {
        return nombre;
    }

   
    
}
