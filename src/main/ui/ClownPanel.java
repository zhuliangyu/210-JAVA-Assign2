package ui;

import model.ListOfClowns;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by norm on 2015-09-17.
 */
public class ClownPanel extends JPanel {
    final ListOfClowns cl = new ListOfClowns();
    final List<JButton> buttons = new ArrayList<>();
    ClownImages clownImages = new ClownImages();

    // EFFECTS: constructs a clown panel with a clown standing/sitting as specified by each arg
    public ClownPanel(boolean... args) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        for (int i = 0; i < args.length; ++i) {
            JButton b = new JButton(new ClownIcon(args[i]));
            cl.addClown(args[i]);
            final int myindex = i;
            //Add action listener to button
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Execute when button is pressed
                    System.out.println("You clicked clown " + myindex);
                    flip(myindex);
                }
            });
            add(b);
            buttons.add(b);
        }
    }

    // EFFECTS: shows a dialog to inform user that they have won the game; terminates application when
    // dialog is closed
    void createAndShowWinMessage() {
        JOptionPane.showMessageDialog(this, "You have won the game!", "You Win!", JOptionPane.INFORMATION_MESSAGE,
                clownImages.getStandingImage());
        System.exit(0);
    }

    // MODIFIES: this
    // EFFECTS: flips the clown at the specified index and updates all clown images;
    //          displays dialog to user if they have won the game
    void flip(int index) {
        cl.flip(index);
        for (int i = 0; i < buttons.size(); ++i) {
            if (cl.isClownStanding(i)) {
                buttons.get(i).setIcon(clownImages.getStandingImage());
            } else {
                buttons.get(i).setIcon(clownImages.getSittingImage());
            }
        }
        if (cl.allClownsStanding()) {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowWinMessage();
                }
            });
        }
    }
}
