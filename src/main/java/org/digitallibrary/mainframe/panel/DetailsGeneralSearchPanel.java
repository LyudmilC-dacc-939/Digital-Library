package org.digitallibrary.mainframe.panel;

import org.digitallibrary.helper.ColumnColorRenderer;
import org.digitallibrary.helper.UIPersonalization;
import org.digitallibrary.mainframe.MainFrame;


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

    private final JTable booksTable;
    private final DefaultTableModel booksTableModel;
    private final JTextField searchField;
    private final JComboBox<String> searchTypeComboBox;

    private MainFrame frame;

    public DetailsGeneralSearchPanel(MainFrame frame) {
        super(frame);
        UIPersonalization uiPersonalization = new UIPersonalization();

        String[] columns = {"Title", "Author", "First Publish Year", "Edition Count"};
        booksTableModel = new DefaultTableModel();
        booksTableModel.setColumnIdentifiers(columns);

        booksTable = new JTable(booksTableModel);
        booksTable.setRowHeight(30);

        TableColumn tableColumn1 = booksTable.getColumnModel().getColumn(0);
        tableColumn1.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor(),
                uiPersonalization.getProjectColor2()));
        TableColumn tableColumn2 = booksTable.getColumnModel().getColumn(1);
        tableColumn2.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor2(),
                uiPersonalization.getProjectColor()));
        TableColumn tableColumn3 = booksTable.getColumnModel().getColumn(2);
        tableColumn3.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor(),
                uiPersonalization.getProjectColor2()));
        TableColumn tableColumn4 = booksTable.getColumnModel().getColumn(3);
        tableColumn4.setCellRenderer(new ColumnColorRenderer(uiPersonalization.getProjectColor2(),
                uiPersonalization.getProjectColor()));

        JScrollPane tableScrollPane = new JScrollPane(booksTable);
        tableScrollPane.setBounds(0, 120, frame.getWidth() - 10, frame.getHeight() - 150);
        add(tableScrollPane);

        frame.mainDataProvider.setBooksTableModel(booksTableModel);

        searchField = new JTextField("Enter search query...");
        searchField.setBounds(0, 0, 500, 50);
        uiPersonalization.setJTextField(searchField, 20);
        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (searchField.getText().equals("Enter search query...")) {
                    searchField.setText("");
                }
            }
        });
        add(searchField);

        String[] searchTypes = {"Title", "Author", "Subject"};
        searchTypeComboBox = new JComboBox<>(searchTypes);
        searchTypeComboBox.setBounds(510, 0, 150, 50);
        uiPersonalization.setJButton((JButton) searchTypeComboBox.getRenderer(), 20);
        add(searchTypeComboBox);

        JButton searchButton = new JButton("Search");
        uiPersonalization.setJButton(searchButton, 20);
        searchButton.setBounds(670, 0, 120, 50);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performSearch();
            }
        });
        add(searchButton);

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                performSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        String query = searchField.getText().trim();
        String searchType = (String) searchTypeComboBox.getSelectedItem();

        if (query.isEmpty() || query.equals("Enter search query...")) {
            return; // Don't search if the query is empty
        }

        try {
            // Fetch data from the API using GeneralSearchRequest
            frame.mainDataProvider.fetchBooks(query, searchType);

            // Update the table with the results
            frame.mainDataProvider.loadBooksModel();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to fetch data from the API.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}