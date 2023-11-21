package test;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TextFieldExample extends JFrame {

    private JTextField textField;
    private JPanel panel;

    public TextFieldExample() {
        super("Text Field Example");

        textField = new JTextField(20);
        panel = new JPanel();

        // Add a document listener to the text field to detect changes
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePanel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePanel();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePanel();
            }
        });

        // Initialize the panel with the initial text
        updatePanel();

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(textField, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);

        setContentPane(contentPane);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updatePanel() {
        // Get the text from the text field
        String text = textField.getText();

        // Clear the panel
        panel.removeAll();

        // Add components to the panel based on the text
        if (text.isEmpty()) {
            // If the text is empty, display a message
            JLabel label = new JLabel("Enter some text");
            panel.add(label);
        } else {
            // Otherwise, display the text in a label
            JLabel label = new JLabel(text);
            panel.add(label);
        }

        // Repaint the panel to update the UI
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        new TextFieldExample();
    }
}

