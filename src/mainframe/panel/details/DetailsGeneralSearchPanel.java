package mainframe.panel.details;

import mainframe.MainFrame;
import mainframe.panel.BasePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DetailsGeneralSearchPanel extends BasePanel {

    private JTable booksTable;
    private DefaultTableModel booksTableModel;
    private JTextField searchField;
    private JComboBox<String> testComboBox;

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

    }
}

