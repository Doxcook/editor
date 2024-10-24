package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
    private static Model model = null;
    MyShape currentMyShape; //текущая фигура
    Collection<MyShape> myShapes; //сюда складываем все фигуры

    //конструктор по умолчанию
    private Model(){
        myShapes = new ArrayList<>(); //создаем коллекцию фигур
    }

    //конструктор синглтона
    public static Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
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

    //создать фигуру
    public void createShape() {
        currentMyShape = currentMyShape.clone();
        myShapes.add(currentMyShape);
    }

    //установить размер
    public void setFrame(Point2D[] points) {
        currentMyShape.createShape(points);
    }
}
