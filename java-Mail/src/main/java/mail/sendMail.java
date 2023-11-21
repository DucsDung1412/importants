package mail;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class sendMail extends JFrame {

	private JPanel contentPane;
	private JTextField txttk;
	private JTextField txtmk;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sendMail frame = new sendMail();
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
	public sendMail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tai khoan");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 51, 90, 28);
		contentPane.add(lblNewLabel);
		
		txttk = new JTextField();
		txttk.setBounds(128, 51, 233, 28);
		contentPane.add(txttk);
		txttk.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mat khau");
		lblMatKhau.setFont(new Font("Arial", Font.BOLD, 16));
		lblMatKhau.setBounds(28, 100, 90, 28);
		contentPane.add(lblMatKhau);
		
		txtmk = new JPasswordField();
		txtmk.setColumns(10);
		txtmk.setBounds(128, 100, 233, 28);
		contentPane.add(txtmk);
		
		JLabel lblNewLabel_1_1 = new JLabel("Den dau");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(28, 159, 90, 28);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 159, 233, 28);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Properties p = new Properties();
					  p.put("mail.smtp.auth", "true");
			            p.put("mail.smtp.starttls.enable", "true"); // Updated property key
			            p.put("mail.smtp.host", "smtp.gmail.com");
			            p.put("mail.smtp.port", "587"); // Changed to string value
			            p.put("mail.smtp.ssl.protocols", "TLSv1.2");
					String tk = txttk.getText();
					String mk = txtmk.getText();
					
					Authenticator au = new Authenticator() {
						@Override
						protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
							return new javax.mail.PasswordAuthentication(tk, mk);
						}
					};
					
					Session s = Session.getInstance(p, au);
					
					String from = txttk.getText();
					String to = textField_2.getText();
					String sub = "Ma bao mat";
					String body = "" + Math.round((Math.random() * (9999 - 1000)) + 1000);
					Message msg = new MimeMessage(s);
					msg.setFrom(new InternetAddress(from));
		            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		            msg.setSubject(sub);
		            msg.setText(body);
					
					Transport.send(msg);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(80, 218, 85, 28);
		contentPane.add(btnNewButton);
	}
}
