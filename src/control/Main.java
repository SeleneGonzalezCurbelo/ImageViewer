package control;

import java.io.File;
import java.io.IOException;
import model.Image;
import persistance.FileImageLoader;

public class Main {
        public static void main(String[] args) throws IOException {
            FileImageLoader imageLoader = createImageLoader();
            Image image = imageLoader.load();
            MainFrame mainFrame = new MainFrame();
            mainFrame.getImageDisplay().show(image);
            image.close();
        }
        
        private static FileImageLoader createImageLoader() {
            File file = new File("..\\ImageViewer\\src\\images");
            return new FileImageLoader(file);
        }
}