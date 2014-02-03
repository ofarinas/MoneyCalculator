package View.Swing;

import Modelo.Currency;
import Modelo.Money;
import Numeric.NumericRestriction;
import View.Console.ErrorViewer;
import View.Interface.MoneyDialog;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author osvaldo
 */
public class MoneyDialogPanel extends JPanel implements MoneyDialog {

    String amount;
    CurrencyDialogPanel currencyDialogPanel;

    public MoneyDialogPanel() throws ErrorViewer {
        super(new FlowLayout(FlowLayout.LEFT));
        execute();
    }

    @Override
    public Money getMoney() {
        return new Money(Double.valueOf(amount), new Currency(currencyDialogPanel.getCode(), null, null));
    }

    @Override
    public void execute() throws ErrorViewer {
    this.add(createAmountJtexfield());
    this.add(createCurrency());
    }

    private JTextField createAmountJtexfield() {
         final JTextField jtexfield =new JTextField(10);
         jtexfield.addKeyListener(new KeyListener() {

             @Override
             public void keyTyped(KeyEvent e) {
             }

             @Override
             public void keyPressed(KeyEvent e) {
             }

             @Override
             public void keyReleased(KeyEvent e) {
                 amount=jtexfield.getText();
             }
         });
         return jtexfield;
    }

    private CurrencyDialogPanel createCurrency() throws ErrorViewer {
         currencyDialogPanel =new CurrencyDialogPanel();
      //  code=currencyDialogPanel.code;
        return currencyDialogPanel;
    }
}
