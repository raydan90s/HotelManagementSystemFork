package myclasses.buttonStrategy;
import javax.swing.JOptionPane;
import myinterface.ButtonActionStrategy;

public class ExitStrategy implements ButtonActionStrategy {
    @Override
    public void execute() {
        int yesORno = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Alert!", JOptionPane.YES_NO_OPTION);
        if (yesORno == 0) {
            System.exit(1);
        }
    }
}
