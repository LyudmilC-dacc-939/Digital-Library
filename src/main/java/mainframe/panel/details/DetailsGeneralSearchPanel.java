package main.java.mainframe.panel.details;

import main.java.helper.ColumnColorRenderer;
import main.java.helper.UIPersonalization;
import main.java.mainframe.MainFrame;
import main.java.mainframe.panel.BasePanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DetailsGeneralSearchPanel extends BasePanel {

    private JTable booksTable;
    private DefaultTableModel booksTableModel;
    private JTextField searchField;

    public DetailsGeneralSearchPanel(MainFrame frame) {
        super(frame);
        UIPersonalization uiPersonalization = new UIPersonalization();
        String[] columns = {"Book Title", "Author's Name", "Date Of Release", "Subject"};
        booksTableModel = new DefaultTableModel();
        booksTableModel.setColumnIdentifiers(columns);

        frame.mainDataProvider.setBooksTableModel(booksTableModel);
        booksTable = new JTable(booksTableModel);
        TableColumn tableColumn1 = booksTable.getColumnModel().getColumn(0);
        tableColumn1.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor(), uiPersonalization.getProjectColor2()));
        TableColumn tableColumn2 = booksTable.getColumnModel().getColumn(1);
        tableColumn2.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor2(), uiPersonalization.getProjectColor()));
        TableColumn tableColumn3 = booksTable.getColumnModel().getColumn(2);
        tableColumn3.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor(), uiPersonalization.getProjectColor2()));
        TableColumn tableColumn4 = booksTable.getColumnModel().getColumn(3);
        tableColumn4.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor2(), uiPersonalization.getProjectColor()));
        //Table Scroll
        JScrollPane tableScrollPane = new JScrollPane(booksTable);
        tableScrollPane.setBounds(0, 70, frame.getWidth() - 10, frame.getHeight() - 100);
        add(tableScrollPane);

        searchField = new JTextField("General Search");
        searchField.setBounds(0, 0, 600, 70);
        uiPersonalization.setJTextField(searchField, 35);
        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (searchField.getText().equals("General Search")) {
                    searchField.setText("");
                }
            }
        });
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                frame.mainDataProvider.searchQuery(searchField.getText());
            }
        });
        add(searchField);

        JButton updateButton = new JButton("Search");
        uiPersonalization.setJButton(updateButton, 40);
        updateButton.setBounds(600, 0, 200, 70);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textSearch = searchField.getText();
                frame.mainDataProvider.fetchBooks(textSearch);
                frame.mainDataProvider.loadBooksModel();
            }
        });
        add(updateButton);

    }
}

