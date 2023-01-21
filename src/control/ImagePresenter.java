package control;

import model.Image;


public class ImagePresenter {
    private MainFrame view;
    private Image model;

    public ImagePresenter(MainFrame view, Image model) {
        this.view = view;
        this.model = model;
        updateView();
    }

    public void next() {
        model = model.next();
        updateView();
    }

    public void prev() {
        model = model.prev();
        updateView();
    }

    private void updateView() {
        view.getImageDisplay().show(model);
    }
}