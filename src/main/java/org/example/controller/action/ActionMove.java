package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;

public class ActionMove implements ActionInterface{
    MyShape sampleShape;
    MyShape shape;
    Point2D[] p;
    Model model;

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }
    public void stretchShape(Point point){
        p[1] =(Point2D) point;
        shape.createShape(p);
    }
    public void createShape(Point point){
        p[0] = (Point2D)point;
        shape = sampleShape.clone();
        model.createShape(shape);
    }


    @Override
    public void mousePressed(Point2D point) {
        createShape((Point) point);
    }

    @Override
    public void mouseDragged(Point2D point) {
        stretchShape((Point) point);
    }

    @Override
    public void setModel(Model m) {

    }
}
