package mainframe;

import mainframe.panel.DefaultPanel;
import mainframe.panel.GeneralSearchPanel;
import mainframe.panel.HomePanel;
import mainframe.panel.RegistrationPanel;
import mainframe.panel.details.DetailsGeneralSearchPanel;

public class MainCoordinator {
    private MainFrame frame;

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

    public void moveToDetailsGeneralSearch(){
        DetailsGeneralSearchPanel detailsGeneralSearchPanel = new DetailsGeneralSearchPanel(frame);
        frame.setContentPane(detailsGeneralSearchPanel);
        frame.validate();
    }

}
