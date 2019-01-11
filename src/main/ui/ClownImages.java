package ui;

import javax.swing.*;

/**
 * Created by norm on 2015-09-17.
 */
public class ClownImages {
    private ImageIcon standingImage = new ImageIcon("images/standingclown.png");
    private ImageIcon sittingImage = new ImageIcon("images/sittingclown.png");

    // EFFECTS: returns image of standing clown
    public ImageIcon getStandingImage() {
        return standingImage;
    }

    // EFFECTS: returns image of sitting clown
    public ImageIcon getSittingImage() {
        return sittingImage;
    }
}
