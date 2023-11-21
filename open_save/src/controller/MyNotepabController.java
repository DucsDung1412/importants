package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.swing.JFileChooser;

import view.MyNotepabView;

public class MyNotepabController implements ActionListener {
	private MyNotepabView myNotepabView;
	
	public MyNotepabController(MyNotepabView myNotepabView) {
		this.myNotepabView = myNotepabView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if(src.equals("Open")) {
			 int returnVal = fc.showOpenDialog(this.myNotepabView);
			 if(returnVal == JFileChooser.APPROVE_OPTION) {
				 File file = fc.getSelectedFile();
				 this.myNotepabView.lblNewLabel.setText(file.getAbsolutePath());
				 if(this.myNotepabView.lblNewLabel.getText().endsWith(".txt")) {
					 try {
						 BufferedReader br = Files.newBufferedReader(file.toPath());
						 String n = "";
						 String k = "";
						 while(true) {
							 n = br.readLine();
							 k += n + "\n";
							 if(n == null) {
								 break;
							 } else {
								 this.myNotepabView.textArea.setText(k);
							 }
						 }
						 this.myNotepabView.textArea.setText(this.myNotepabView.textArea.getText().replaceAll("[\n\r]+$", ""));
					 } catch (Exception e2) {
						e2.printStackTrace();
					}
				 }
			 }
			
		} else if(src.equals("Save")) {
			if(this.myNotepabView.lblNewLabel.getText().equals("")) {
				int retrunSave = fc.showSaveDialog(this.myNotepabView);
				if(retrunSave == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					savex(file.getAbsolutePath());
				}
			} else {
				String strings = this.myNotepabView.lblNewLabel.getText();
				savex(strings);
			}
		}
	}
	
	public void savex(String fileName) {
		try {
			PrintWriter pw = new PrintWriter(fileName, StandardCharsets.UTF_8);
			String date = this.myNotepabView.textArea.getText(); 
			pw.print(date);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
