package persistance;

import control.ImagePresenter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import model.Image;

public final class FileImageLoader implements ImageLoader {
    private final File[] files;
    private InputStream inputStream;
    private ImagePresenter presenter;
    
    public FileImageLoader(File folder) {
        this.files = folder.listFiles(imageTypes());
    }
    
    public FileFilter imageTypes() {
        return (File pathname) -> pathname.getName().endsWith(".jpg");
    }

    public Image imageAt(int i) {
        return new Image() {

            @Override
            public String name() {
                return files[i].getName();
            }

            @Override
            public InputStream stream() throws IOException {
                try {
                    return new BufferedInputStream(new FileInputStream(files[i]));
                } catch (FileNotFoundException e) {
                    return null;
                }
            }

            @Override
            public void close() throws IOException {
                if (inputStream != null) {
                    inputStream.close();
                }
            }

            @Override
            public Image next() {
                if (i == files.length - 1) {
                    return this;
                }
                return imageAt(i + 1);
            }

            @Override
            public Image prev() {
                if (i == 0) {
                    return this;
                }
                return imageAt(i - 1);
            }
        };
    }
    
    public void setPresenter(ImagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Image load() {
        return imageAt(0);
    }

}
