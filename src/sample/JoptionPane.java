package sample;

import javax.swing.*;

public class JoptionPane {
    JFrame f;

    JoptionPane(String warningMsg) {
        f = new JFrame();
        JOptionPane.showMessageDialog(f, warningMsg);
    }

}