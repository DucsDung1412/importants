package File;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class file extends JFrame {

	private JPanel contentPane;
	private JTextField txt_openFile;
	private JTextField txt_createdFile;
	private JTextPane txt_Files;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					file frame = new file();
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
	public file() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 514);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("File");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 602, 55);
		contentPane.add(lblNewLabel);
		
		txt_openFile = new JTextField();
		txt_openFile.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_openFile.setBounds(65, 75, 387, 39);
		contentPane.add(txt_openFile);
		txt_openFile.setColumns(10);
		
		JButton btnNewButton = new JButton("OPEN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int i = fc.showOpenDialog(file.this);
				if(i == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					txt_openFile.setText(f.getAbsolutePath());
					txt_Files.setText(listFiles(f, 0));
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(462, 75, 97, 39);
		contentPane.add(btnNewButton);
		
		txt_createdFile = new JTextField();
		txt_createdFile.setFont(new Font("Arial", Font.PLAIN, 14));
		txt_createdFile.setColumns(10);
		txt_createdFile.setBounds(65, 128, 387, 39);
		contentPane.add(txt_createdFile);
		
		JButton btnCreated = new JButton("CREATE");
		btnCreated.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File(txt_openFile.getText() + "/" +txt_createdFile.getText());
				try {
					if(f.exists()) {
						JOptionPane.showMessageDialog(null, "Ton ta roi");
					} else {
						f.createNewFile();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCreated.setFont(new Font("Arial", Font.BOLD, 15));
		btnCreated.setBounds(462, 128, 97, 39);
		contentPane.add(btnCreated);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(65, 187, 494, 205);
		contentPane.add(scrollPane);
		
		txt_Files = new JTextPane();
		scrollPane.setViewportView(txt_Files);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File(txt_openFile.getText());
				deleteFile(f);
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 15));
		btnDelete.setBounds(462, 402, 97, 39);
		contentPane.add(btnDelete);
		
		JButton btnRemane = new JButton("REMANE");
		btnRemane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = JOptionPane.showInputDialog(null);
				if(newName.trim().length() > 0) {
					File fileOld = new File(txt_openFile.getText());
					
					File fileNew = new File(fileOld.getParent() + "\\" + newName);
					
					fileOld.renameTo(fileNew);
				}
			}
		});
		btnRemane.setFont(new Font("Arial", Font.BOLD, 15));
		btnRemane.setBounds(310, 402, 127, 39);
		contentPane.add(btnRemane);
	}
	
	public void deleteFile(File f) {
		try {
			if(f.isDirectory()) {
				for(File File : f.listFiles()) {
					deleteFile(File);
				}
			}
			f.delete();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public String listFiles(File f, int i) {
		String s = "";
		
		if(f.isHidden()) {
			return s;
		}
		
		for (int j = 0; j < i; j++) {
			s += "\t";
		}
		for (int j = 0; j < i; j++) {
			s += "-";
		}
		s += f.getName() + "\n";
		
		if(f.isFile()) {
			return s;
		}
		
		File[] arrF = f.listFiles();
		
		if(arrF.length > 0) {
			i++;
			for (File File : arrF) {
				s += listFiles(File, i);
			}
		}
		
		return s;
	}
}
