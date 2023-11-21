package customJTable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class test extends JFrame {

	private JPanel contentPanex;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() ->{
			new test();
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		contentPanex = new JPanel();
		contentPanex.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPanex);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPanex);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		table.setRowHeight(34);
		
		table.getColumnModel().getColumn(3).setCellRenderer(new tableCustomerCellRender());
		
		tableAcctionEvent event = new tableAcctionEvent() {
			
			@Override
			public void onSearch(int row) {
				System.out.println(row);
			}
			
			@Override
			public void onNew(int row) {
				System.out.println(row);
			}
			
			@Override
			public void onDelete(int row) {
				if(table.isEditing()) {
					table.getCellEditor().stopCellEditing();
				}
				DefaultTableModel talbe_model = (DefaultTableModel)table.getModel();
				talbe_model.removeRow(row);
			}
		};
		
		table.getColumnModel().getColumn(3).setCellEditor(new tableCustomerCellEditor(event));
		
		
		table.setSelectionBackground(Color.BLUE);
		scrollPane.setViewportView(table);
		
		this.contentPanex.setLayout(gl_contentPane);
		
		this.pack();
		this.setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
