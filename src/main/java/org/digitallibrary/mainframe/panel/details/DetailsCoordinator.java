package org.digitallibrary.mainframe.panel.details;


import org.digitallibrary.mainframe.MainFrame;

public class DetailsCoordinator {
    private final MainFrame frame;

    public DetailsCoordinator(MainFrame frame) {
        this.frame = frame;
    }

    public void moveToDetailsGeneralSearch(){
        DetailsGeneralSearchPanel detailsGeneralSearchPanel = new DetailsGeneralSearchPanel(frame);
        frame.setContentPane(detailsGeneralSearchPanel);
        frame.validate();
    }
}
