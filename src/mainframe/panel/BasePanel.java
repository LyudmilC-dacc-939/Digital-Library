package mainframe.panel;

import helper.UIPersonalization;
import mainframe.MainFrame;

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
