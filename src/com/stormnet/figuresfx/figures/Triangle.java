package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Figure{
    private double height;

    private Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }
    public Triangle(double cx, double cy, double lineWidth, Color color, double height) {
        this(cx, cy, lineWidth, color);
        this.height = height < 100 ? 100 : height;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx - height / 2, cx + height / 2, cx}, new double[]{cy + height / 2, cy + height / 2, cy - height / 2}, 3);
    }
}
