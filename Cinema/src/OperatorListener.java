import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class OperatorListener implements ItemListener {
    ComputerListener workTogether;
    JComboBox<String> choice;
    public void setJComboBox(JComboBox<String> box){
        choice = box;
    }

    public void setWorkTogether(ComputerListener computer){
        workTogether = computer;
    }

    public void itemStateChanged(ItemEvent e) {
        String shenfen1 = choice.getSelectedItem().toString();
        workTogether.setShenfen(shenfen1);
    }
}