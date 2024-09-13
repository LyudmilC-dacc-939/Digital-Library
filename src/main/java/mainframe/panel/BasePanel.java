package main.java.mainframe.panel;

import main.java.helper.UIPersonalization;
import main.java.mainframe.MainFrame;

import javax.swing.JPanel;

public class BasePanel extends JPanel {
    MainFrame frame;
    private UIPersonalization uiPersonalization = new UIPersonalization();

    public BasePanel(MainFrame frame) {
        this.frame = frame;
        setBackground(uiPersonalization.getProjectColor());
        setLayout(null);
    }
}
