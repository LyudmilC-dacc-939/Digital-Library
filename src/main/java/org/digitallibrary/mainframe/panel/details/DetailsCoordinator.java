package org.digitallibrary.mainframe.panel.details;


import org.digitallibrary.mainframe.MainCoordinator;
import org.digitallibrary.mainframe.MainDataProvider;
import org.digitallibrary.mainframe.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailsCoordinator {
    private final MainFrame frame;

    @Autowired
    private MainDataProvider mainDataProvider;

    @Autowired
    private MainCoordinator mainCoordinator;

    public DetailsCoordinator(MainFrame frame) {
        this.frame = frame;
    }

    public void moveToDetailsGeneralSearch(){
        if(mainDataProvider.isTokenValid()){
            DetailsGeneralSearchPanel detailsGeneralSearchPanel = new DetailsGeneralSearchPanel(frame);
            frame.setContentPane(detailsGeneralSearchPanel);
            frame.validate();
        } else {
            //todo: Redirect
            mainCoordinator.moveToDefaultPanel();
        }
    }

    //public void moveToGeneralSearchPanel() {
    //        if (mainDataProvider.isTokenValid()) {
    //            GeneralSearchPanel generalSearchPanel = new GeneralSearchPanel(frame);
    //            frame.setContentPane(generalSearchPanel);
    //            frame.validate();
    //        } else {
    //            //todo: Redirect to log in if token is invalid
    //            moveToDefaultPanel();
    //        }
    //    }
}
