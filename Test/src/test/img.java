package test;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class img extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					img frame = new img();
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
	public img() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				showI();
			}
		});
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(40, 35, 325, 174);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 60, 305, 49);
		panel.add(lblNewLabel);
	}
	
	public void showI() {
		JFileChooser fc = new JFileChooser();
		int i = fc.showOpenDialog(this);
		if(i == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			if(f.toString().endsWith(".png") || f.toString().endsWith(".jpg")) {
				BufferedImage bi = null;
				try {
					bi = ImageIO.read(f);
					//System.out.println(bi);
					ImageIcon ic = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
//					System.out.println(ic.getImage());
//					lblNewLabel = new JLabel(new ImageIcon(bi));
					lblNewLabel.setIcon(ic);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}
