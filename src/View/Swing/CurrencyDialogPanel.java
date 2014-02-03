package View.Swing;

import Modelo.Currency;
import Modelo.CurrencySet;
import View.Console.ErrorViewer;
import View.Interface.CurrencyDialog;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author osvaldo
 */
public class CurrencyDialogPanel extends JPanel implements CurrencyDialog {

    String code;

    public CurrencyDialogPanel() throws ErrorViewer {
        super(new FlowLayout());
        execute();
    }

    @Override
    public Currency getCurrency() {
        return new Currency(code, null, null);
    }

    @Override
    public void execute() throws ErrorViewer {
        this.add(createCurrencyCombox());
    }

    private JComboBox createCurrencyCombox() {
        final JComboBox listaCurrency = new JComboBox();
        addListCurrency(listaCurrency);
        code = (String) listaCurrency.getSelectedItem();
        listaCurrency.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // if(e.getStateChange()!=ItemEvent.SELECTED)return;
                code = (String) listaCurrency.getSelectedItem();
            }
        });
        return listaCurrency;
    }

    public String getCode() {
        return code;
    }

    private void addListCurrency(JComboBox listaCurrency) {
        for (Currency currency : CurrencySet.getCurrencySet()) {
            listaCurrency.addItem(currency.getCode());
        }
    }
}
