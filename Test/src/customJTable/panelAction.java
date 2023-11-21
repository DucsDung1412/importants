package customJTable;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

public class panelAction extends JPanel {
	private ActionJButton btnNewButton, btnNewButton_1, btnNewButton_1_1;

	/**
	 * Create the panel.
	 */
	public panelAction() {

		btnNewButton = new ActionJButton();
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\java3_ASM\\icon\\delete16.png"));

		btnNewButton_1 = new ActionJButton();
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\java3_ASM\\icon\\exit16.png"));

		btnNewButton_1_1 = new ActionJButton();
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\java3_ASM\\icon\\search16.png"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout
				.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout
								.createSequentialGroup()
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 34,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNewButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 34,
												Short.MAX_VALUE))
								.addContainerGap()));
		setLayout(groupLayout);
	}

	public void initEvent(tableAcctionEvent event, int row) {
		this.btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				event.onDelete(row);
			}
		});
		this.btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				event.onNew(row);
			}
		});
		this.btnNewButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				event.onSearch(row);
			}
		});
	}
}
