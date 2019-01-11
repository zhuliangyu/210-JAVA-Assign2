package ui;

import model.Clown;

import javax.swing.*;

/**
 * Created by norm on 2015-09-17.
 */
public class ClownIcon extends ImageIcon {
    Clown clown;

    // EFFECTS: constructs a clown icon that is standing if isStanding is true, otherwise sitting
    public ClownIcon(boolean isStanding) {
        super(isStanding ? "images/standingclown.png" : "images/sittingclown.png");
    }
}
