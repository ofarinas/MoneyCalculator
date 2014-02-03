/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionListener;

/**
 *
 * @author osvaldo
 */
public interface ActionListenerFactory {
    public ActionListener getActionListener(String action); 
}
