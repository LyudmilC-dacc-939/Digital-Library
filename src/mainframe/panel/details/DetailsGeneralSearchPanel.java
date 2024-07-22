package mainframe.panel.details;

import mainframe.MainFrame;
import mainframe.panel.BasePanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class DetailsGeneralSearchPanel extends BasePanel {

    private JTable booksTable;
    private DefaultTableModel booksTableModel;
    private JTextField searchField;

    public DetailsGeneralSearchPanel(MainFrame frame) {
        super(frame);
        String[] columns = {"Book Title", "Author's Name", "Date Of Release", "Subject"};
        booksTableModel = new DefaultTableModel();
        booksTableModel.setColumnIdentifiers(columns);

        frame.mainDataProvider.setBooksTableModel(booksTableModel);
        booksTable = new JTable(booksTableModel);
        //Table Scroll
        JScrollPane tableScrollPane = new JScrollPane(booksTable);
        tableScrollPane.setBounds(0, 70, frame.getWidth() - 10, frame.getHeight() - 100);
        add(tableScrollPane);

        searchField = new JTextField("General Search");
        searchField.setBounds(0, 0, frame.getWidth(), 30);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                frame.mainDataProvider.searchQuery(searchField.getText());
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

    }
}

