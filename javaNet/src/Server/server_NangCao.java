package Server;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class server_NangCao extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField txtPort;
	private JButton btnStart;
	public ServerSocket ssk = null;
	public Socket sk = null;
	public DataInputStream dis = null;
	public DataOutputStream dos = null;
	public SimpleAttributeSet server_Mess;
	public SimpleAttributeSet client_Mess;
	private JTextPane txtMess;
	private JTextField txtMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					server_NangCao frame = new server_NangCao();
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
	public server_NangCao() {
		this.setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 10, 463, 284);
		contentPane.add(scrollPane);
		
		txtMess = new JTextPane();
		txtMess.setEditable(false);
		scrollPane.setViewportView(txtMess);
		
		JLabel lblNewLabel = new JLabel("Port");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(36, 76, 61, 22);
		contentPane.add(lblNewLabel);
		
		txtPort = new JTextField();
		txtPort.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPort.setBounds(10, 108, 123, 29);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		JLabel j = new JLabel();
		j.setFont(new Font("Tahoma", Font.PLAIN, 31));
		j.setText("asd");
		j.setIcon(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\java3_lab7_bai2\\src\\emoji\\angry.png"));
		
		JButton btnNewButton = new JButton("File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendF();
			}
		});
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
		
		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int port = Integer.valueOf(txtPort.getText());
					ssk = new ServerSocket(port);
					sk = ssk.accept();
					dis = new DataInputStream(sk.getInputStream());
					dos = new DataOutputStream(sk.getOutputStream());
					
					Thread t = new Thread(server_NangCao.this);
					t.start();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStart.setFont(new Font("Arial", Font.BOLD, 14));
		btnStart.setBounds(32, 147, 85, 29);
		contentPane.add(btnStart);
		
		txtMessage = new JTextField();
		txtMessage.setBounds(10, 349, 406, 29);
		contentPane.add(txtMessage);
		txtMessage.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				sendIcon(lblNewLabel_1.getIcon().toString());
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\Download của Dũng\\ChatApplication\\src\\data\\icon\\emoji\\angry.png"));
		lblNewLabel_1.setBounds(10, 317, 45, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				sendIcon(lblNewLabel_1_1.getIcon().toString());
			}
		});
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\Download của Dũng\\ChatApplication\\src\\data\\icon\\emoji\\sad.png"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(65, 317, 45, 22);
		contentPane.add(lblNewLabel_1_1);
		
		server_Mess = new SimpleAttributeSet();
		client_Mess = new SimpleAttributeSet();
		
		StyleConstants.setBold(server_Mess, true);
		StyleConstants.setForeground(server_Mess, Color.RED);
		StyleConstants.setFontSize(server_Mess, 16);
		StyleConstants.setFontFamily(server_Mess, "Arial");
		
		StyleConstants.setBold(client_Mess, true);
		StyleConstants.setForeground(client_Mess, Color.BLUE);
		StyleConstants.setFontSize(client_Mess, 16);
		StyleConstants.setFontFamily(client_Mess, "Arial");
	}
	
	public void setInsertionToDocument() {
		Document document = this.txtMess.getDocument();
		int lengthMess = document.getLength();
		this.txtMess.setSelectionStart(lengthMess);
		this.txtMess.setSelectionEnd(lengthMess);
	}
	
	public void insertImangeToMess(ImageIcon image) {
		this.setInsertionToDocument();
		this.txtMess.insertIcon(image);
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
	
	public void sendIcon(String file) {
		try {
			dos.writeUTF(file);
			ImageIcon iamge = new ImageIcon(file);
			this.insertTextToDocument("Server: ", server_Mess);
			this.insertImangeToMess(iamge);
			this.insertTextToDocument("\n", null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			if(sk != null) {
				try {
					String s = dis.readUTF();
					if(!s.equals("") && s != null) {
						this.insertTextToDocument("Client: " + s + "\n", client_Mess);
					}
					s = "";
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void sendMess() {
		String mess = this.txtMessage.getText();
		try {
			dos.writeUTF(mess);
			this.insertTextToDocument("Server: " + mess + "\n", server_Mess);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendF() {
		JFileChooser fc = new JFileChooser();
		int i = fc.showOpenDialog(this);
		if(i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			if(f.toPath().toAbsolutePath().toString().endsWith(".png") || f.toPath().toAbsolutePath().toString().endsWith(".jpg")) {
				this.sendIcon(f.toPath().toAbsolutePath().toString());
			} else {
				try {
					FileInputStream fis = new FileInputStream(f.getAbsolutePath());
					
//					String fileName = f.getName();
//					byte[] fileNameBytes = fileName.getBytes();
//					
//					dos.writeInt(fileName.length());
//					dos.write(fileNameBytes);
					
					byte[] fBytes = new byte[(int) f.length()];
					fis.read(fBytes);
					
					String fileNamee = f.toPath().toAbsolutePath().toString();
					dos.writeUTF(fileNamee);
					this.insertTextToDocument("file", server_Mess);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
