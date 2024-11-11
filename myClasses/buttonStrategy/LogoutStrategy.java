package myclasses.buttonStrategy;
import javax.swing.JOptionPane;
import myclasses.Login;
import myclasses.Profile;
import myinterface.ButtonActionStrategy;


public class LogoutStrategy implements ButtonActionStrategy {
    private Profile profile;

    public LogoutStrategy(Profile profile) {
        this.profile = profile;
    }

    @Override
    public void execute() {
        int yesORno = JOptionPane.showConfirmDialog(null, "Are you sure?", "Alert!", JOptionPane.YES_NO_OPTION);
        if (yesORno == JOptionPane.YES_OPTION) {
            profile.setVisible(false);
            System.out.println("Exited from Profile class");
            new Login();
        }
    }

}