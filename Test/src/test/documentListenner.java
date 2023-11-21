package test;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;

public class documentListenner extends JFrame {

	private JPanel contentPane;
	private JTextField txtFind;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel1;
	private JLabel lblZed;
	private JPanel panel2;
	private JLabel lblNewLabel_1;
	private JPanel panel3;
	private JLabel lblNewLabel_1_1;
	private JPanel panel4;
	private JLabel lblNewLabel_1_1_1;
	private JPanel panel5;
	private JLabel lblNewLabel_1_1_1_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					documentListenner frame = new documentListenner();
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
	public documentListenner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("Tim");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(372, 17, 104, 34);
		contentPane.add(btnNewButton);
		
		txtFind = new JTextField();
		txtFind.setFont(new Font("Arial", Font.BOLD, 16));
		txtFind.setBounds(135, 10, 227, 49);
		txtFind.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				chage();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				chage();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				chage();
				
			}
		});
		contentPane.add(txtFind);
		txtFind.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(10, 91, 686, 367);
		panel.setLayout(new GridLayout(2, 0, 10, 10));
		contentPane.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		lblNewLabel = new JLabel("yasuo");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 49, 89, 43);
		panel_1.add(lblNewLabel);
		
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel1);
		
		lblZed = new JLabel("zed");
		lblZed.setFont(new Font("Arial", Font.BOLD, 16));
		lblZed.setBounds(41, 49, 89, 43);
		panel1.add(lblZed);
		
		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel2);
		
		lblNewLabel_1 = new JLabel("master yi");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(42, 46, 89, 43);
		panel2.add(lblNewLabel_1);
		
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel3);
		
		lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(41, 47, 89, 43);
		panel3.add(lblNewLabel_1_1);
		
		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel4);
		
		lblNewLabel_1_1_1 = new JLabel("leesin");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(41, 46, 89, 43);
		panel4.add(lblNewLabel_1_1_1);
		
		panel5 = new JPanel();
		panel5.setLayout(null);
		panel5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel5);
		
		lblNewLabel_1_1_1_1 = new JLabel("garen");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(33, 49, 89, 43);
		panel5.add(lblNewLabel_1_1_1_1);
		
		panel.add(panel_1);
//		panel.removeAll();
	}
	
	public void chage() {
		String text = this.txtFind.getText();
		this.panel.removeAll();
	    
		
		if(text.isEmpty()) {
			this.panel.add(panel1);
			this.panel.add(panel2);
			this.panel.add(panel_1);
			this.panel.add(panel3);
			this.panel.add(panel4);
			this.panel.add(panel5);
		} else {
			panel_1.setName("yasuo");
			if(panel_1.getName().indexOf(text)>=0) {
				panel.add(panel_1);
			} else {
				panel.remove(panel_1);
				panel.add(panel2);
			}
		}
		
		panel.revalidate();
	    panel.repaint();
	}
}
