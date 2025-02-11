package org.digitallibrary.mainframe.panel;

import org.digitallibrary.helper.UIPersonalization;
import org.digitallibrary.mainframe.MainFrame;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralSearchPanel extends BasePanel {

    public GeneralSearchPanel(final MainFrame frame) {
        super(frame);
        UIPersonalization uiPersonalization = new UIPersonalization();

        JButton searchByQuery = new JButton("General Search");
        uiPersonalization.setJButton(searchByQuery, 25);
        searchByQuery.setBounds(95, 60, 600, 55);
        searchByQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mainCoordinator.moveToDetailsGeneralSearchPanel();
            }
        });
        add(searchByQuery);
    }
}