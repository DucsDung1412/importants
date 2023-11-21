package exportToPDFAndExcel;

//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTable;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//
//import java.awt.Font;
//import javax.swing.table.DefaultTableModel;
//
//import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Phrase;
//import com.itextpdf.text.pdf.BaseFont;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.microsoft.schemas.office.visio.x2012.main.CellType;
//
//import javax.swing.JScrollPane;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.AttributedCharacterIterator.Attribute;
//import java.util.Map;
//import java.util.concurrent.Phaser;
//import java.awt.event.ActionEvent;
//
//public class testExportToExcelAndPDF extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					testExportToExcelAndPDF frame = new testExportToExcelAndPDF();
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
//	public testExportToExcelAndPDF() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 748, 438);
//		this.setLocationRelativeTo(null);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JButton excel = new JButton("excel");
//		excel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fc = new JFileChooser();
//				int option = fc.showSaveDialog(testExportToExcelAndPDF.this);
//				if(option == JFileChooser.APPROVE_OPTION) {
//					String file = fc.getSelectedFile().getAbsolutePath();
//					Workbook workbook = new XSSFWorkbook();
//					Sheet sheet = workbook.createSheet("Hello");
//					
//					CellStyle headerStyle = workbook.createCellStyle();
//			        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
//			        font.setBold(true);
//			        headerStyle.setFont(font);
//			        headerStyle.setAlignment(HorizontalAlignment.CENTER);
//					
//					int colummnCount = table.getColumnCount();
//					Row headerRow = sheet.createRow(3);
//					for (int i = 0; i < colummnCount; i++) {
//						Cell cell = headerRow.createCell(i + 3);
//						cell.setCellValue(table.getColumnName(i));
//						cell.setCellStyle(headerStyle);
//					}
//					
//					CellStyle dataStyle = workbook.createCellStyle();
//			        dataStyle.setBorderTop(BorderStyle.THIN);
//			        dataStyle.setBorderBottom(BorderStyle.THIN);
//			        dataStyle.setBorderLeft(BorderStyle.THIN);
//			        dataStyle.setBorderRight(BorderStyle.THIN);
//					
//					for (int i = 0; i < table.getRowCount(); i++) {
//						Row rowHeader = sheet.createRow(i + 4);
//						for(int j = 0; j < table.getColumnCount(); j++) {
//							Cell cell = rowHeader.createCell(j + 3);
//							cell.setCellValue(table.getValueAt(i, j).toString());
//							cell.setCellStyle(dataStyle);
//						}
//					}
//					
//					try {
//						FileOutputStream fos = new FileOutputStream(file + ".xlsx");
//						workbook.write(fos);
//						fos.close();
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//		excel.setFont(new Font("Arial", Font.BOLD, 18));
//		excel.setBounds(522, 37, 85, 21);
//		contentPane.add(excel);
//		
//		JButton pdf = new JButton("pdf");
//		pdf.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				JFileChooser fc = new JFileChooser();
//				int option = fc.showSaveDialog(testExportToExcelAndPDF.this);
//				if(option == JFileChooser.APPROVE_OPTION) {
//					String file = fc.getSelectedFile().getAbsolutePath();
//					Document document = new Document();
//					try {
//						FileOutputStream fos = new FileOutputStream(file + ".pdf");
//						PdfWriter.getInstance(document, fos);
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//					
//					document.open();
//					
//					BaseFont bf = null;
//					com.itextpdf.text.Font font = null;
//					try {
//						bf = BaseFont.createFont("C:\\Users\\Admin\\eclipse-workspace\\librarySys3\\src\\main\\java\\font\\Roboto-Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//						font = new com.itextpdf.text.Font(bf, 20);
//					} catch (Exception e2) {
//						e2.printStackTrace();
//					}
//					
//					PdfPTable tablePDF = new PdfPTable(table.getColumnCount());
//					tablePDF.setWidthPercentage(100);
//					
//					for (int i = 0; i < table.getColumnCount(); i++) {
//						PdfPCell cell = new PdfPCell();
//					    Phrase phrase = new Phrase(table.getColumnName(i), font); // Create Phrase with the specified font
//					    cell.addElement(phrase);
//					    cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//					    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//					    tablePDF.addCell(cell);
//					}
//					
//					for (int i = 0; i < table.getRowCount(); i ++) {
//						for (int j = 0; j < table.getColumnCount(); j++) {
//							PdfPCell cell = new PdfPCell(new Phrase(table.getValueAt(i, j) + ""));
//							cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//				            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//							tablePDF.addCell(cell);
//						}
//					}
//					
//					try {
//						document.add(tablePDF);
//					} catch (DocumentException e1) {
//						e1.printStackTrace();
//					}
//					document.close();
//				}
//			}
//		});
//		pdf.setFont(new Font("Arial", Font.BOLD, 18));
//		pdf.setBounds(522, 102, 85, 21);
//		contentPane.add(pdf);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(20, 16, 430, 337);
//		contentPane.add(scrollPane);
//		
//		table = new JTable();
//		table.setFont(new Font("Arial", Font.PLAIN, 14));
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"H\u01B0ng Th\u00EC Ngu", "L\u1EE3i Th\u00EC Ph\u1EBF", "D\u0169ng Th\u00EC VipPro"},
//				{"H\u01B0ng Si\u00EAu L\u01B0\u1EDDi", "L\u1EE3i Si\u00EAu Ph\u1EBF", "D\u0169ng Si\u00EAu \u0110\u1EC9nh"},
//			},
//			new String[] {
//				"H\u01B0ng", "L\u1EE3i", "D\u0169ng"
//			}
//		));
//		scrollPane.setViewportView(table);
//	}
//}
