package org.digitallibrary.mainframe;

import lombok.AllArgsConstructor;
import org.digitallibrary.mainframe.panel.DefaultPanel;
import org.digitallibrary.mainframe.panel.GeneralSearchPanel;
import org.digitallibrary.mainframe.panel.HomePanel;
import org.digitallibrary.mainframe.panel.RegistrationPanel;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MainCoordinator {

    private final MainFrame frame;

    private final MainDataProvider mainDataProvider;

    public void moveToDefaultPanel() {
        DefaultPanel defaultPanel = new DefaultPanel(frame);
        frame.setContentPane(defaultPanel);
        frame.validate();
    }

    public void moveToRegistrationPanel() {
        RegistrationPanel registrationPanel = new RegistrationPanel(frame);
        frame.setContentPane(registrationPanel);
        frame.validate();
    }

    public void moveToHomePanel() {
        if (mainDataProvider.isTokenValid()) {
            HomePanel homePanel = new HomePanel(frame);
            frame.setContentPane(homePanel);
            frame.validate();
        } else {
            //todo: Redirect to log in if token is invalid
            moveToDefaultPanel();
        }
    }

    public void moveToGeneralSearchPanel() {
        if (mainDataProvider.isTokenValid()) {
            GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel(frame);
            frame.setContentPane(generalSearchPanel);
            frame.validate();
        } else {
            //todo: Redirect to log in if token is invalid
            moveToDefaultPanel();
        }
    }
}
