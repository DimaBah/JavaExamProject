package com.stormnet.figuresfx.controller;

import com.stormnet.figuresfx.UnknownFigureException;
import com.stormnet.figuresfx.drawutils.Drawer;
import com.stormnet.figuresfx.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

public class MainScreenViewController implements Initializable {
    private ArrayList<Figure> figures;
    private Random random;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("App is initialized!");
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }
    private static final Logger logger = Logger.getLogger(MainScreenViewController.class.getName());

    private Figure createFigure(double x, double y) throws UnknownFigureException {
        Figure figure;
        int figureType = random.nextInt(6);   //пусть будет шанс на неизвестную фигуру
        logger.debug("createFigure called with: " + figureType);
        if (figureType > 3){
            logger.warn("No figures with type > 3");
        }
        switch (figureType){
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(20) , Color.GREEN, random.nextInt(50));
                logger.info("Circle is ready.");
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                figure = new Rectangle(x, y, random.nextInt(20), Color.PINK, random.nextInt(50), random.nextInt(50));
                logger.info("Rectangle is ready.");
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(20) ,Color.BURLYWOOD, random.nextInt(100));
                logger.info("Triangle is ready.");
                break;
            case Figure.FIGURE_TYPE_SURIKEN:
                figure = new Suriken(x, y, random.nextInt(20) , Color.MEDIUMTURQUOISE, random.nextInt(50));
                logger.info("Suriken is ready to fly.");
                break;
            default:
                throw new UnknownFigureException("Unknown type of figure!");
        }
        return figure;
    }
    private void repaint(){
        canvas.getGraphicsContext2D().clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        Drawer <Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            figures.add(createFigure(mouseEvent.getX(), mouseEvent.getY()));
            repaint();
        } catch (UnknownFigureException ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
