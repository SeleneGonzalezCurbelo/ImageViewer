package control;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import ui.ImageDisplay;
import ui.swing.SwingImageDisplay;

public class MainFrame extends JFrame{
    private ImageDisplay imageDisplay;
    private ImagePresenter presenter;

    public MainFrame() throws IOException {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private JPanel toolBar(){
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    
    private JButton nextButton(){
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }
    
    private ActionListener nextImage(){
        return (ActionEvent e) -> {
            imageDisplay.show(imageDisplay.current().next());
        };
    }
    
    private JButton prevButton(){
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }
    
    private ActionListener prevImage(){
        return (ActionEvent e) -> {
            imageDisplay.show(imageDisplay.current().prev());
        };
    }
    
    private JPanel imageDisplay() throws IOException{
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }
    
    public void setPresenter(ImagePresenter presenter) {
        this.presenter = presenter;
    }
    
    public ImageDisplay getImageDisplay(){
        return imageDisplay;
    }
}
