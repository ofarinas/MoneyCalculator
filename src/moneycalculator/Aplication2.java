package moneycalculator;

import Control.ActionListenerFactory;
import Control.CalculateCommand;
import Control.Command;
import Control.DictionayCommand;
import Persisten.DBCurrencySetLoader;
import View.Console.ErrorViewer;
import View.Swing.MainFrame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author osvaldo
 */
public class Aplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, HeadlessException, ErrorViewer {
        Aplication2.execute();
    }

    public static void execute() throws HeadlessException, ErrorViewer {
        new DBCurrencySetLoader().load();
        final DictionayCommand dictionayCommand = new DictionayCommand();
        ActionListenerFactory actionListenerFactory = new ActionListenerFactory() {
            @Override
            public ActionListener getActionListener(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dictionayCommand.get(action).execute();
                    }
                };
            }
        };
     final  MainFrame mainFrame = new MainFrame(actionListenerFactory);
        dictionayCommand.registrer("exit", new Command() {

            @Override
            public void execute() {
              mainFrame.dispose();
            }
        });
        dictionayCommand.registrer("calculate", new CalculateCommand(mainFrame.getMoneyDialogPanel(),
                                                                     mainFrame.getCurrencyDialogPane()
                                                                      ));
    }
}
