package mainframe.panel;

import helper.UIPersonalization;
import mainframe.MainFrame;
import mainframe.panel.details.DetailsCoordinator;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneralSearchPanel extends BasePanel {

    public GeneralSearchPanel(final MainFrame frame) {
        super(frame);
        UIPersonalization uiPersonalization = new UIPersonalization();
        DetailsCoordinator detailsCoordinator = new DetailsCoordinator(frame);

        JButton searchByQuery = new JButton("General Search");
        uiPersonalization.setJButton(searchByQuery, 25);
        searchByQuery.setBounds(95, 60, 600, 55);
        searchByQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsCoordinator.moveToDetailsGeneralSearch();
            }
        });
        add(searchByQuery);

        JButton searchByTitle = new JButton("Search By Title");
        uiPersonalization.setJButton(searchByTitle, 25);
        searchByTitle.setBounds(95, 135, 600, 55);
        searchByTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo add path to another class
            }
        });
        add(searchByTitle);

        JButton searchByAuthor = new JButton("Search By Author");
        uiPersonalization.setJButton(searchByAuthor, 25);
        searchByAuthor.setBounds(95, 210, 600, 55);
        searchByAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo add path to another class
            }
        });
        add(searchByAuthor);
    }
}
