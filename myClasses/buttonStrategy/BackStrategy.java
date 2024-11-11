package myclasses.buttonStrategy;
import myclasses.Profile;
import myclasses.UDashBoard;
import myinterface.*;

public class BackStrategy implements ButtonActionStrategy {
    private Profile profile;

    public BackStrategy(Profile profile) {
        this.profile = profile;
    }

    @Override
    public void execute() {
        profile.setVisible(false);
        System.out.println("Exited from Profile class");
        new UDashBoard();
    }
}