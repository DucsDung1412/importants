package customJTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class tableCustomerCellRender extends DefaultTableCellRenderer{
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		panelAction pa = new panelAction();
		if(isSelected == false && row % 2 ==0) {
			pa.setBackground(Color.WHITE);
		} else {
			pa.setBackground(com.getBackground());
		}
		return pa;
	}
}
