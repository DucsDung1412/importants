package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MyNotepabController;
import controller.controller;
import model.MyNotepabModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MyNotepabView extends JFrame {
	private MyNotepabModel myNotepabModel;
	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyNotepabView frame = new MyNotepabView();
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
	/**
	 * 
	 */
	public MyNotepabView() {
		this.myNotepabModel = new MyNotepabModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 396);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10 ,50));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 0, 226, 40);
		panel.add(lblNewLabel);
		
		MyNotepabController myNotepabController = new MyNotepabController(this);
		controller c = new controller(this);
;		JButton btn_open = new JButton("Open");
		btn_open.setFont(new Font("Arial", Font.BOLD, 18));
		btn_open.setBounds(310, 12, 98, 28);
		btn_open.addActionListener(c);
		panel.add(btn_open);
		
		JButton btn_save = new JButton("Save");
		btn_save.setFont(new Font("Arial", Font.BOLD, 18));
		btn_save.setBounds(418, 12, 98, 28);
		btn_save.addActionListener(c);
		panel.add(btn_save);
		
	}

}
