package org.digitallibrary.mainframe;

import lombok.AllArgsConstructor;
import org.digitallibrary.helper.MessageWindow;
import org.digitallibrary.mainframe.panel.DefaultPanel;
import org.digitallibrary.mainframe.panel.GeneralSearchPanel;
import org.digitallibrary.mainframe.panel.HomePanel;
import org.digitallibrary.mainframe.panel.RegistrationPanel;
import org.digitallibrary.mainframe.panel.DetailsGeneralSearchPanel;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MainCoordinator {

    private final MainFrame frame;

    private final MainDataProvider mainDataProvider;

    public boolean checkTokenValidity() {
        if (!mainDataProvider.isTokenValid()) {
            handleTokenExpiration();
            return true;
        }
        return false;
    }

    public void handleTokenExpiration() {
        MessageWindow.popUpErrorMessage("Your session has expired. Please log in again.");
        SecurityContextHolder.clearContext();
        moveToDefaultPanel();
    }

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
        if (checkTokenValidity()) {
            return;
        }
        HomePanel homePanel = new HomePanel(frame);
        frame.setContentPane(homePanel);
        frame.validate();
    }

    public void moveToGeneralSearchPanel() {
        if (checkTokenValidity()) {
            return;
        }
        GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel(frame);
        frame.setContentPane(generalSearchPanel);
        frame.validate();
    }

    public void moveToDetailsGeneralSearchPanel() {
        if (checkTokenValidity()) {
            return;
        }
        DetailsGeneralSearchPanel detailsGeneralSearchPanel = new DetailsGeneralSearchPanel(frame);
        frame.setContentPane(detailsGeneralSearchPanel);
        frame.validate();
    }

    public void logout() {
        mainDataProvider.logoutUser();
        moveToDefaultPanel();
    }
}
