package customJTable;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class tableCustomerCellEditor extends DefaultCellEditor{
	
	private tableAcctionEvent event;
	
	public tableCustomerCellEditor(tableAcctionEvent event) {
		super(new JCheckBox());
		this.event = event;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		panelAction pa = new panelAction();
		pa.setBackground(table.getSelectionBackground());
		pa.initEvent(event, row);
		return pa;
	}
}
