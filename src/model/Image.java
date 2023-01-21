package model;

import java.io.IOException;
import java.io.InputStream;

public interface Image {
    public String name();
    public InputStream stream() throws IOException;
    public void close() throws IOException;
    public Image next();
    public Image prev();
}