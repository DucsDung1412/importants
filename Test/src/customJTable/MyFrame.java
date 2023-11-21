package customJTable;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MyFrame {

	public static void main(String[] args) {
	    JFrame frame = new JFrame("Custom Table");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	    // Create the table
	    Object[][] data = {{1, "John Doe"}, {2, "Jane Doe"}, {3, "Peter Smith"}};
	    String[] columns = {"ID", "Name"};
	    JTable table = new JTable(data, columns);
	
	    // Set the row height
	    table.setRowHeight(50);
	
	    // Set the column model
	    TableColumnModel columnModel = table.getColumnModel();
	
	    // Set the preferred width of the columns
	    columnModel.getColumn(0).setPreferredWidth(100);
	    columnModel.getColumn(1).setPreferredWidth(200);
	
	    // Add a panel to the first column
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.red);
	    columnModel.getColumn(0).setHeaderRenderer((TableCellRenderer) new MyHeaderRenderer(panel));
	
	    // Add a panel to the second column
	    panel = new JPanel();
	    panel.setBackground(Color.blue);
	    columnModel.getColumn(1).setHeaderRenderer((TableCellRenderer) new MyHeaderRenderer(panel));
	
	    // Add the table to the scroll pane
	    JScrollPane scrollPane = new JScrollPane(table);
	    frame.add(scrollPane);
	
	    // Set the row margin
	    table.setRowMargin(50);
	
	    // Set the cell editor
	    table.getColumnModel().getColumn(0).setCellEditor(new MyCellEditor(new JTextField("a")));
	
	    // Display the frame
	    frame.pack();
	    frame.setVisible(true);
	}

	private static class MyHeaderRenderer extends DefaultTableCellRenderer {
	
	    private JPanel panel;
	
	    public MyHeaderRenderer(JPanel panel) {
	        this.panel = panel;
	    }
	
	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        setBackground(panel.getBackground());
	        return this;
	    }
	}

	private static class MyCellEditor extends DefaultCellEditor {
	
	    public MyCellEditor(JTextField textField) {
			super(textField);
		}

		@Override
	    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
	        JTextField textField = new JTextField();
	        textField.setText(value.toString());
	        textField.setEditable(true);
	        return textField;
	    }
	
	    @Override
	    public Object getCellEditorValue() {
	        JTextField textField = (JTextField) getComponent();
	        return textField.getText();
	    }
	}
}