/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Numeric;

/**
 *
 * @author osvaldo
 */
public class NumericRestriction {

    private NumericRestriction() {
      
    }

    public static boolean isNumber(String number) {
        try {
            Double.valueOf(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
