								//Find Jlabel in Jpanel
//import javax.swing.*;
//import java.awt.*;
//
//public class NoLabelPanelFinder {
//
//    public static JPanel find(Container container) {
//        Component[] components = container.getComponents();
//        for (Component component : components) {
//            if (component instanceof JPanel) {
//                JPanel panel = (JPanel) component;
//                if (!hasLabels(panel)) {
//                    return panel;
//                }
//            }
//        }
//        return null;
//    }
//
//    private static boolean hasLabels(JPanel panel) {
//        Component[] components = panel.getComponents();
//        for (Component component : components) {
//            if (component instanceof JLabel) {
//                return true;
//            }
//        }
//        return false;
//    }
//}


						//Document with icon
//import javax.swing.*;
//import javax.swing.event.*;
//import java.awt.*;
//import java.io.*;
//
//public class PicturePanelExample extends JFrame {
//
//    private JTextField textField;
//    private PicturePanel panel;
//
//    public PicturePanelExample() {
//        super("Picture Panel Example");
//
//        textField = new JTextField(20);
//        panel = new PicturePanel();
//
//        // Add a document listener to the text field to detect changes
//        textField.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                updatePanel();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                updatePanel();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                updatePanel();
//            }
//        });
//
//        JPanel contentPane = new JPanel(new BorderLayout());
//        contentPane.add(textField, BorderLayout.NORTH);
//        contentPane.add(panel, BorderLayout.CENTER);
//
//        setContentPane(contentPane);
//        setSize(500, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    private void updatePanel() {
//        // Get the text from the text field
//        String text = textField.getText();
//
//        // Load the image file based on the text
//        ImageIcon icon = null;
//        if (!text.isEmpty()) {
//            String fileName = text + ".jpg";
//            File file = new File(fileName);
//            if (file.exists()) {
//                icon = new ImageIcon(fileName);
//            }
//        }
//
//        // Update the panel with the new image
//        panel.setIcon(icon);
//        panel.revalidate();
//        panel.repaint();
//    }
//
//    public static void main(String[] args) {
//        new PicturePanelExample();
//    }
//}
//
//class PicturePanel extends JPanel {
//
//    private ImageIcon icon;
//
//    public void setIcon(ImageIcon icon) {
//        this.icon = icon;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        if (icon != null) {
//            // Scale the image to fit the panel
//            Image image = icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon scaledIcon = new ImageIcon(image);
//
//            // Draw the image on the panel
//            scaledIcon.paintIcon(this, g, 0, 0);
//        }
//    }
//}

								//Document with String
//package test;
//
//import javax.swing.*;
//import javax.swing.event.*;
//import java.awt.*;
//
//public class TextFieldExample extends JFrame {
//
//    private JTextField textField;
//    private JPanel panel;
//
//    public TextFieldExample() {
//        super("Text Field Example");
//
//        textField = new JTextField(20);
//        panel = new JPanel();
//
//        // Add a document listener to the text field to detect changes
//        textField.getDocument().addDocumentListener(new DocumentListener() {
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                updatePanel();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                updatePanel();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                updatePanel();
//            }
//        });
//
//        // Initialize the panel with the initial text
//        updatePanel();
//
//        JPanel contentPane = new JPanel(new BorderLayout());
//        contentPane.add(textField, BorderLayout.NORTH);
//        contentPane.add(panel, BorderLayout.CENTER);
//
//        setContentPane(contentPane);
//        setSize(500, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }
//
//    private void updatePanel() {
//        // Get the text from the text field
//        String text = textField.getText();
//
//        // Clear the panel
//        panel.removeAll();
//
//        // Add components to the panel based on the text
//        if (text.isEmpty()) {
//            // If the text is empty, display a message
//            JLabel label = new JLabel("Enter some text");
//            panel.add(label);
//        } else {
//            // Otherwise, display the text in a label
//            JLabel label = new JLabel(text);
//            panel.add(label);
//        }
//
//        // Repaint the panel to update the UI
//        panel.revalidate();
//        panel.repaint();
//    }
//
//    public static void main(String[] args) {
//        new TextFieldExample();
//    }
//}
//

