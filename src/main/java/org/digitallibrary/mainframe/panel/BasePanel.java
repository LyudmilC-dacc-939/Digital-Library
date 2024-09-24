package org.digitallibrary.mainframe.panel;

import org.digitallibrary.helper.UIPersonalization;
import lombok.NoArgsConstructor;
import org.digitallibrary.mainframe.MainFrame;

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
