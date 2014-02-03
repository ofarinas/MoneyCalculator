package Control;

import Control.Command;
import java.util.HashMap;

/**
 *
 * @author osvaldo
 */
public class DictionayCommand {

    HashMap<String,Command>dictioHashMap=new HashMap<>();;

    public DictionayCommand() {
   // dictioHashMap=new HashMap<>();
    }
    public void registrer(String action,Command command ){
    dictioHashMap.put(action, command);
    }

    public Command get(String action) {
        return dictioHashMap.get(action);
    }
   

}
