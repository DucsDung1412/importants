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

public class controller implements ActionListener{
	private MyNotepabView view;
	
	
	public controller(MyNotepabView view) {
		this.view = view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if(src.equals("Open")) {
			int i = fc.showOpenDialog(this.view);
			if(i == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				this.view.lblNewLabel.setText(f.getAbsolutePath());
				if(f.getName().endsWith(".txt")) {
					try {
						BufferedReader br = Files.newBufferedReader(f.toPath());
						String n = "";
						String k = "";
						while(true) {
							n = br.readLine();
							k = k + n + "\n";
							if(n == null) {
								break;
							}
							this.view.textArea.setText(k);
						}
						
						this.view.textArea.setText(this.view.textArea.getText().replaceAll("[\n\r]+$", ""));
					} catch (Exception e2) {
						
					}
				}
			}
		} else if (src.equals("Save")) {
			if(this.view.lblNewLabel.getText().equals("")) {
				int j = fc.showSaveDialog(this.view);
				if(j == JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					savex(f.getAbsolutePath());
				}
				
			} else {
				String s = this.view.lblNewLabel.getText();
				savex(s);
			}
		}
	}
	
	public void savex(String f) {
		try {
			PrintWriter pw = new PrintWriter(f, StandardCharsets.UTF_8);
			String s = this.view.textArea.getText();
			pw.print(s);
			pw.flush();
			pw.close();
		} catch (Exception e) {

		}
	}

}
