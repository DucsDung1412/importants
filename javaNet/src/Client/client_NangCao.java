package Client;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class client_NangCao extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public Socket sk = null;
	public DataInputStream dis = null;
	public DataOutputStream dos = null;
	private JTextPane txtMess;
	public SimpleAttributeSet server_Mess;
	public SimpleAttributeSet client_Mess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_NangCao frame = new client_NangCao();
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
	public client_NangCao() {
		this.setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 10, 463, 284);
		contentPane.add(scrollPane);
		
		txtMess = new JTextPane();
		scrollPane.setViewportView(txtMess);
		
		JLabel lblNewLabel = new JLabel("Port");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 76, 61, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(10, 108, 123, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_1.setBounds(10, 349, 406, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("File");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(426, 349, 85, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMess();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton_1.setBounds(521, 349, 85, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					sk = new Socket("localhost",Integer.valueOf(textField.getText()));
					
					dis = new DataInputStream(sk.getInputStream());
					dos = new DataOutputStream(sk.getOutputStream());
					
					Thread t = new Thread(client_NangCao.this);
					t.start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStart.setFont(new Font("Arial", Font.BOLD, 14));
		btnStart.setBounds(30, 147, 85, 29);
		contentPane.add(btnStart);
		
		server_Mess = new SimpleAttributeSet();
		client_Mess = new SimpleAttributeSet();
		
		StyleConstants.setBold(client_Mess, true);
		StyleConstants.setFontFamily(client_Mess, "Arial");
		StyleConstants.setFontSize(client_Mess, 16);
		StyleConstants.setForeground(client_Mess, Color.BLUE);
		
		StyleConstants.setBold(server_Mess, true);
		StyleConstants.setFontFamily(server_Mess, "Arial");
		StyleConstants.setFontSize(server_Mess, 16);
		StyleConstants.setForeground(server_Mess, Color.RED);
	}
	
	public void setInsertionToDocument() {
		Document document = this.txtMess.getDocument();
		int lengthMess = document.getLength();
		this.txtMess.setSelectionStart(lengthMess);
		this.txtMess.setSelectionEnd(lengthMess);
	}
	
	public void insertTextToDocument(String text, SimpleAttributeSet sas) {
		Document document = this.txtMess.getDocument();
		setInsertionToDocument();
		try {
			document.insertString(document.getLength(), text, sas);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	public void insertImageToMess(ImageIcon image) {
		setInsertionToDocument();
		this.txtMess.insertIcon(image);
	}

	@Override
	public void run() {
		try {
			if(sk != null) {
				while(true) {
					String s = dis.readUTF();
					if(!s.equals("") && s != null) {
						if(s.endsWith(".png") || s.endsWith(".jpg")) {
							ImageIcon image = new ImageIcon(s);
							this.insertTextToDocument("Server: ", server_Mess);
							this.insertImageToMess(image);
							this.insertTextToDocument("\n", server_Mess);
						} else {
							this.insertTextToDocument("Server: " + s + "\n", server_Mess);
						}
					}
					s = "";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMess() {
		String s = this.textField_1.getText();
		try {
			dos.writeUTF(s);
			this.insertTextToDocument("Client: " + s + "\n", client_Mess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
