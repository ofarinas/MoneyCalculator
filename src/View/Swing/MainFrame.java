package View.Swing;

import Control.ActionListenerFactory;
import View.Console.ErrorViewer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author osvaldo
 */
public class MainFrame extends JFrame {

    private ActionListenerFactory actionListenerFactory;
    private MoneyDialogPanel moneyDialogPanel;
    private CurrencyDialogPanel currencyDialogPanel;

    public MoneyDialogPanel getMoneyDialogPanel() {
        return moneyDialogPanel;
    }

    public CurrencyDialogPanel getCurrencyDialogPane() {
        return currencyDialogPanel;
    }

    public MainFrame(ActionListenerFactory actionListenerFactory) throws HeadlessException, ErrorViewer {
        this.actionListenerFactory = actionListenerFactory;
        this.setTitle("Money Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(350, 300));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.createComponent();
        this.setVisible(true);
    }

    private void createComponent() throws ErrorViewer {
        this.add(createExchangeMoneyPanel());
        this.add(createToolBar(), BorderLayout.SOUTH);
    }

    private JPanel createToolBar() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jpanel.add(createButtonCalculate());
        jpanel.add(createButtonExit());
        return jpanel;
    }

    private JPanel createExchangeMoneyPanel() throws ErrorViewer {
        JPanel jpanel = new JPanel();
        jpanel.add(craateMoneypanel());
        jpanel.add(craateCurrencypanel());
        return jpanel;
    }

    private JButton createButtonCalculate() {
        JButton calculate = new JButton("Calculate");
        calculate.addActionListener(actionListenerFactory.getActionListener("calculate"));
        return calculate;
    }

    private JButton createButtonExit() {
        JButton exit = new JButton("Exit");
        ActionListener a = actionListenerFactory.getActionListener("exit");
        exit.addActionListener(a);
        return exit;
    }

    private MoneyDialogPanel craateMoneypanel() throws ErrorViewer {
        moneyDialogPanel = new MoneyDialogPanel();
        return moneyDialogPanel;
    }

    private CurrencyDialogPanel craateCurrencypanel() throws ErrorViewer {
        currencyDialogPanel = new CurrencyDialogPanel();
        return currencyDialogPanel;
    }
}
