package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

public class gridBagLayout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gridBagLayout frame = new gridBagLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public gridBagLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		textField = new PlaceholderTextField("Hello");
		textField.setBounds(166, 103, 229, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		PlaceholderTextField textField_1 = new PlaceholderTextField("Hello");
		textField_1.setColumns(10);
		textField_1.setBounds(166, 156, 229, 33);
		getContentPane().add(textField_1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(0, 0, 83, 263);
		getContentPane().add(toolBar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		toolBar.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 61, 55);
		panel.add(panel_1);
		
//		GridBagConstraints gbc = new GridBagConstraints();
//		
//		gbc.fill = GridBagConstraints.BOTH;
//		gbc.gridx = 0;
//		gbc.gridy = 0;
//		this.add(new JButton("1"), gbc);
//		
//		gbc.gridx = 1;
//		gbc.gridy = 1;
//		this.add(new JButton("2"), gbc);
	}
}
