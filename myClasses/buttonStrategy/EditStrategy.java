package myclasses.buttonStrategy;

import myclasses.Edit;
import myclasses.Profile;
import myinterface.ButtonActionStrategy;

public class EditStrategy implements ButtonActionStrategy {
    private Profile profile;

    public EditStrategy(Profile profile) {
        this.profile = profile;
    }

    @Override
    public void execute() {
        profile.setVisible(false);
        System.out.println("Exited from Profile class");
        new Edit();
    }
}
