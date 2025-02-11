package org.digitallibrary.mainframe.panel;

import org.digitallibrary.helper.UIPersonalization;
import org.digitallibrary.mainframe.MainFrame;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends BasePanel {
    private JButton bookSearchButton;
    private JButton workAndEditionButton;
    private JButton myBooksButton;
    private JButton authorsButton;
    private JButton subjectsButton;
    private JButton searchInsideButton;
    private JButton searchByIdentifierButton;
    private JButton coversButton;
    private JButton recentChangesButton;
    private JButton userListsButton;


    public HomePanel(MainFrame frame) {
        super(frame);
        UIPersonalization uiPersonalization = new UIPersonalization();

        bookSearchButton = new JButton("General Search");
        uiPersonalization.setJButton(bookSearchButton, 25);
        bookSearchButton.setBounds(95, 30, 600, 55);
        bookSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mainCoordinator.moveToGeneralSearchPanel();
            }
        });
        add(bookSearchButton);

        workAndEditionButton = new JButton("Search Work And Edition By Identifier");
        uiPersonalization.setJButton(workAndEditionButton, 25);
        workAndEditionButton.setBounds(95, 102, 600, 55);
        workAndEditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo add coordinator wiring
            }
        });
        add(workAndEditionButton);

        myBooksButton = new JButton("Retrieve Books On a Patrons Public Log");
        uiPersonalization.setJButton(myBooksButton, 25);
        myBooksButton.setBounds(95, 174, 600, 55);
        myBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo add coordinator wiring
            }
        });
        add(myBooksButton);

        authorsButton = new JButton("Search By Author");
        uiPersonalization.setJButton(authorsButton, 25);
        authorsButton.setBounds(95, 246, 600, 55);
        authorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo add coordinator wiring
            }
        });
        add(authorsButton);

        subjectsButton = new JButton("Search By Subject Name");
        uiPersonalization.setJButton(subjectsButton, 25);
        subjectsButton.setBounds(95, 318, 600, 55);
        subjectsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//todo add coordinator wiring
            }
        });
        add(subjectsButton);

        searchInsideButton = new JButton("Search Within For Matching Text");
        uiPersonalization.setJButton(searchInsideButton, 25);
        searchInsideButton.setBounds(95, 390, 600, 55);
        searchInsideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//todo add coordinator wiring
            }
        });
        add(searchInsideButton);

        searchByIdentifierButton = new JButton("Search By Library Identifiers");
        uiPersonalization.setJButton(searchByIdentifierButton, 25);
        searchByIdentifierButton.setBounds(95, 462, 600, 55);
        searchByIdentifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//todo add coordinator wiring
            }
        });
        add(searchByIdentifierButton);

        coversButton = new JButton("Get Book Covers By ISBN or Open Library Id");
        uiPersonalization.setJButton(coversButton, 25);
        coversButton.setBounds(95, 534, 600, 55);
        coversButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//todo add coordinator wiring
            }
        });
        add(coversButton);

        recentChangesButton = new JButton("Programatic Access To Changes Across Open Library");
        uiPersonalization.setJButton(recentChangesButton, 25);
        recentChangesButton.setBounds(95, 606, 600, 55);
        recentChangesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//todo add coordinator wiring
            }
        });
        add(recentChangesButton);

        userListsButton = new JButton("Reading, Modifying Or Creating User Lists");
        uiPersonalization.setJButton(userListsButton, 25);
        userListsButton.setBounds(95, 678, 600, 55);
        userListsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(userListsButton);

        JButton backButton = new JButton("<");
        uiPersonalization.setJButton(backButton, 25);
        backButton.setBounds(20, 695, 50, 50);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.mainCoordinator.moveToDefaultPanel();
            }
        });
        add(backButton);

        JButton logoutButton = new JButton("Logout");
        uiPersonalization.setJButton(logoutButton, 25);
        logoutButton.setBounds(600, 695, 150, 50);
        logoutButton.addActionListener(e -> frame.mainCoordinator.logout());
        add(logoutButton);
    }
}

