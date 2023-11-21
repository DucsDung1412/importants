package panel_in_JOP;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {


    public TestPanel() {
        initUI();
    }

    public final void initUI() {
        setLayout(null);

        JLabel label = new JLabel("JTextPane:");
        JTextPane textPane = new JTextPane();
        
        // Set the position and size of each component
        label.setBounds(10, 10, 80, 20);
        textPane.setBounds(10, 30, 280, 120);
       

        // Set the preferred size for each component
//        label.setPreferredSize(new Dimension(80, 20));
//        textPane.setPreferredSize(new Dimension(150, 20));

        add(label);
        add(textPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TestPanel panel = new TestPanel();
            panel.setPreferredSize(new Dimension(300, 150));

            int input = JOptionPane.showConfirmDialog(null, panel, "Edit Customer",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (input == JOptionPane.OK_OPTION) {
                // OK button clicked
                // Perform actions here
                System.out.println("true");
                // Process the input values
                // ...
            } else {
                // Cancel button clicked
                // Handle cancellation
            }
        });
    }
}


