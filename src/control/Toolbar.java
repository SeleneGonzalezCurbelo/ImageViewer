package control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar {
    private final MainFrame frame;

    public Toolbar(MainFrame frame) {
        this.frame = frame;
    }

    public void init() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage() {
        return (ActionEvent e) -> {
            frame.getImageDisplay().show(frame.getImageDisplay().current().prev());
        };
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {
        return (ActionEvent e) -> {
            frame.getImageDisplay().show(
            frame.getImageDisplay().current().next());
        };
    }
}
