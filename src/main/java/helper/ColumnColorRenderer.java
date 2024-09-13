package helper;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class ColumnColorRenderer extends DefaultTableCellRenderer {
    private Color backgroundColor;
    private Color foregroundColor;

    public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
    }

    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        cell.setBackground(backgroundColor);
        cell.setForeground(foregroundColor);
        return cell;
    }
}