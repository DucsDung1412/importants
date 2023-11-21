//package calendar;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import com.toedter.calendar.JCalendar;
//
//import java.awt.Font;
//import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.TimeZone;
//import java.awt.event.ActionEvent;
//import java.awt.BorderLayout;
//import javax.swing.border.TitledBorder;
//import java.awt.Color;
//
//public class testJCalendar extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					testJCalendar frame = new testJCalendar();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public testJCalendar() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JCalendar calendar = new JCalendar();
//		calendar.getDayChooser().setDayBordersVisible(false);
//		calendar.setWeekOfYearVisible(false);
//		calendar.setLocation(10, 38);
//		calendar.setSize(352, 202);
//		contentPane.add(calendar);
//		
//		JButton asd = new JButton("OK");
//		asd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				Date date = new Date(calendar.getYearChooser().getYear() - 1900, calendar.getMonthChooser().getMonth(), calendar.getDayChooser().getDay());
//				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//				TimeZone timeZone = TimeZone.getTimeZone("GMT");
//				sdf.setTimeZone(timeZone);
//				String time = sdf.format(date);
//				System.out.println(time);
//			}
//		});
//		calendar.add(asd, BorderLayout.SOUTH);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				calendar.setVisible(true);
//			}
//		});
//		btnNewButton.setBounds(10, 7, 85, 21);
//		contentPane.add(btnNewButton);
//		
//	}
//}