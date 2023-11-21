package Client;

import java.awt.EventQueue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class client_chat_CoBan extends JFrame implements Runnable{

	private JPanel contentPane;
	private JTextField txtText;
	public JTextField port;
	public Socket sk = null;
	public DataInputStream dis;
	public DataOutputStream dos;
	private JTextArea txtMess;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					client_chat_CoBan frame = new client_chat_CoBan();
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
	public client_chat_CoBan() {
		this.setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtText = new JTextField();
		txtText.setBounds(10, 234, 324, 19);
		contentPane.add(txtText);
		txtText.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendMess();
			}
		});
		btnSend.setBounds(341, 233, 85, 21);
		contentPane.add(btnSend);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 10, 310, 201);
		contentPane.add(scrollPane);
		
		txtMess = new JTextArea();
		scrollPane.setViewportView(txtMess);
		
		port = new JTextField();
		port.setBounds(10, 91, 96, 19);
		contentPane.add(port);
		port.setColumns(10);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int po = Integer.valueOf(port.getText());
					sk = new Socket("localhost", po);
					
					dis = new DataInputStream(sk.getInputStream());
					
					dos = new DataOutputStream(sk.getOutputStream());
					
					Thread t = new Thread (client_chat_CoBan.this);
					t.start();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStart.setBounds(20, 120, 75, 21);
		contentPane.add(btnStart);
	}
	
	public void sendMess() {
		try {
			String s = this.txtText.getText();
			dos.writeUTF(s);
			dos.flush();
			
			if(this.txtMess.getText().equals("")) {
				this.txtMess.setText("Client: " + s);
			} else {
				this.txtMess.setText(this.txtMess.getText() + "\nClient: " + s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			while(true) {
				if(sk !=null) {
					String in = dis.readUTF();
					if(in != null) {
						if(this.txtMess.getText().equals("")) {
							this.txtMess.setText("Server: " + in);
						} else {
							this.txtMess.setText(this.txtMess.getText() + "\nServer: " + in);
						}
						in = null;
					}
				}
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
