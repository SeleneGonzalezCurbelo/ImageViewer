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
    private Toolbar toolbar;

    public MainFrame() throws IOException {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay(), BorderLayout.CENTER);
        this.toolbar = new Toolbar(this);
        this.toolbar.init();
        this.setVisible(true);
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
