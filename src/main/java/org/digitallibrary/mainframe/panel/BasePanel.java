package mainframe.panel;

import helper.UIPersonalization;
import lombok.NoArgsConstructor;
import mainframe.MainFrame;

import javax.swing.JPanel;

@NoArgsConstructor
public class BasePanel extends JPanel {
    MainFrame frame;
    private UIPersonalization uiPersonalization = new UIPersonalization();

    public BasePanel(MainFrame frame) {
        this.frame = frame;
        setBackground(uiPersonalization.getProjectColor());
        setLayout(null);
    }
}
