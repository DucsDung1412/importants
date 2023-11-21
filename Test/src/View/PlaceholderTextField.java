package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PlaceholderTextField extends JTextField implements FocusListener {
    private String placeholder;
    private boolean showingPlaceholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
        this.showingPlaceholder = true;

        // Set the font and color for the placeholder text
        Font placeholderFont = getFont().deriveFont(Font.ITALIC);
        Color placeholderColor = Color.GRAY;

        // Set the placeholder text and color
        setText(placeholder);
        setFont(placeholderFont);
        setForeground(placeholderColor);

        // Add a focus listener to show/hide the placeholder text
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        // When the field gains focus, remove the placeholder text if it's being displayed
        if (showingPlaceholder) {
            SwingUtilities.invokeLater(() -> {
                setText("");
                setFont(getFont().deriveFont(Font.PLAIN));
                setForeground(Color.BLACK);
            });
            showingPlaceholder = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // When the field loses focus, show the placeholder text if no text has been entered
        if (getText().isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                setText(placeholder);
                setFont(getFont().deriveFont(Font.ITALIC));
                setForeground(Color.GRAY);
            });
            showingPlaceholder = true;
        }
    }
    
}


