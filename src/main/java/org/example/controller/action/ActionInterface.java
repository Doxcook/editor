package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.geom.Point2D;

public interface ActionInterface {
    void mousePressed(Point2D point);
    void mouseDragged(Point2D point);

    void setModel(Model m);
    void setSampleShape(MyShape myShape);
}
