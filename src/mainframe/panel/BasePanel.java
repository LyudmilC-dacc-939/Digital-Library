package mainframe.panel;

import helper.UIPersonalization;
import mainframe.MainFrame;

import javax.swing.JPanel;

class BasePanel extends JPanel {
    MainFrame frame;
    private UIPersonalization uiPersonalization = new UIPersonalization();

    BasePanel(MainFrame frame) {
        this.frame = frame;
        setBackground(uiPersonalization.getProjectColor());
        setLayout(null);
    }
}
