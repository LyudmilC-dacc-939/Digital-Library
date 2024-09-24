package org.digitallibrary.mainframe;

import org.digitallibrary.mainframe.panel.DefaultPanel;
import org.digitallibrary.mainframe.panel.GeneralSearchPanel;
import org.digitallibrary.mainframe.panel.HomePanel;
import org.digitallibrary.mainframe.panel.RegistrationPanel;

public class MainCoordinator {
    private final MainFrame frame;

    public MainCoordinator(MainFrame frame) {
        this.frame = frame;
    }

    public void moveToDefaultPanel(){
        DefaultPanel defaultPanel = new DefaultPanel(frame);
        frame.setContentPane(defaultPanel);
        frame.validate();
    }

    public void moveToRegistrationPanel(){
        RegistrationPanel registrationPanel = new RegistrationPanel(frame);
        frame.setContentPane(registrationPanel);
        frame.validate();
    }

    public void moveToHomePanel(){
        HomePanel homePanel = new HomePanel(frame);
        frame.setContentPane(homePanel);
        frame.validate();
    }

    public void moveToGeneralSearchPanel(){
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel(frame);
        frame.setContentPane(generalSearchPanel);
        frame.validate();
    }

}
