package ui.swing;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Image;
import model.ImageLoadException;
import ui.ImageDisplay;

public class SwingImageDisplay extends JPanel implements ImageDisplay{

    private Image currentImage;
    
    private BufferedImage imageOf(Image image) throws ImageLoadException {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException e) {
            throw new ImageLoadException("Error al cargar imagen", e);
        }
    }

    @Override
    public Image current() {
        return currentImage;
    }

    @Override
    public void show(Image image) {
        if (currentImage != null) {
            try {
                currentImage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.currentImage = image;
        this.repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);  
        if (currentImage == null) {
            return;
        }
        try {
            BufferedImage image = imageOf(currentImage);
            int width = getWidth();
            int height = getHeight();
            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics g2 = scaledImage.createGraphics();
            g2.drawImage(image, 0, 0, width, height, null);
            g2.dispose();
            g.drawImage(scaledImage, 0, 0, null);
        } catch (ImageLoadException ex) {
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}