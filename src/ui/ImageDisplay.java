package ui;

import model.Image;

public interface ImageDisplay {
    public Image current();
    public void show(Image image);
}
