package com.stormnet.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Suriken extends Figure{
    private double radius;

    private Suriken(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_SURIKEN, cx, cy, lineWidth, color);
    }
    public Suriken(double cx, double cy, double lineWidth, Color color, double radius) {
        this(cx, cy, lineWidth, color);
        this.radius = radius < 10 ? 10 : radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{cx - radius * 3, cx - radius / 2, cx, cx + radius / 2, cx + radius * 3, cx + radius / 2, cx, cx - radius / 2},
                new double[]{cy, cy + radius / 2, cy +  + radius * 3, cy + radius / 2, cy, cy - radius / 2, cy - radius * 3, cy - radius / 2},
                8);
    }
}
