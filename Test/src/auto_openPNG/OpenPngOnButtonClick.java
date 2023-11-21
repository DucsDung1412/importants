package auto_openPNG;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class OpenPngOnButtonClick {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame and a button
            JFrame frame = new JFrame("Open PNG on Button Click");
            JButton button = new JButton("Open PNG");
            
            // Add an ActionListener to the button
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Define the file path of the PNG file
                    String filePath = "C:\\Users\\Admin\\Downloads\\New folder\\ICON\\soLuonghv.jpg";
                    
                    // Open the PNG file with the default image viewer
                    openPngFile(filePath);
                }
            });
            
            // Add the button to the frame
            frame.getContentPane().add(button);
            
            // Set the frame properties
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
    
    private static void openPngFile(String filePath) {
        // Check if the Desktop class is supported on the current platform
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                // Open the PNG file with the default image viewer
                File pngFile = new File(filePath);
                desktop.open(pngFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Desktop is not supported on this platform.");
        }
    }
}
