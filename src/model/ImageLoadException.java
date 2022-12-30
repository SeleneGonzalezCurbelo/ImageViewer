package model;

public class ImageLoadException extends Exception {
    public ImageLoadException(String message) {
        super(message);
    }
    public ImageLoadException(String message, Exception cause) {
        super(message, cause);
    }
}