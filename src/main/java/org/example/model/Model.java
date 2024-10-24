package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
    MyShape currentMyShape; //текущая фигура
    Collection<MyShape> myShapes; //сюда складываем все фигуры

    //конструктор по умолчанию
    public Model(){
        myShapes = new ArrayList<>();
    }

    //для установки текущей фигура
    public void setCurrentShape(MyShape currentMyShape) {
        this.currentMyShape = currentMyShape;
    }

    //получаем текущую фигуру
    public MyShape getCurrentShape() {
        return currentMyShape;
    }

    //для получения коллекции фигур
    public Collection<MyShape> getList() {
        return myShapes;
    }

    //добавление в коллекцию


    public void createShape() {
        currentMyShape = currentMyShape.clone();
        myShapes.add(currentMyShape);
    }

    public void setFrame(Point2D[] points) {
        currentMyShape.createShape(points);
    }
}
