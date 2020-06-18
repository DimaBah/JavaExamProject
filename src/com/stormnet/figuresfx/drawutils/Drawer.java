package com.stormnet.figuresfx.drawutils;

import com.stormnet.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer <T extends Figure & Drawable> implements Drawable{
    ArrayList<T> figuresList;

    public Drawer(ArrayList<T> figuresList) {
        this.figuresList = figuresList;
    }

    @Override
    public void draw(GraphicsContext gc) {
        for (Figure item : figuresList){
            item.draw(gc);
        }
    }
}
