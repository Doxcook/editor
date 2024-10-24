package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

//класс фигуры
public class MyShape {
    Color color;
    RectangularShape shape; //объект прямоугольника
    //Point2D p; // начальная точка в 2х мерном пространстве

    // конструктор по умолчанию
    public MyShape() {
        color = Color.BLUE;
        shape = new Rectangle2D.Double();
    }

    //геттер фигуры
    public RectangularShape getShape() {
        return shape;
    }

    //метод для определения первой точки
    public void createShape(Point2D[] point) {
        shape.setFrameFromDiagonal(point[0], point[1]);
    }




    // Добавляем рисовку фигуры
    public void draw(Graphics2D g) {
        Paint p= g.getPaint();
        g.setColor(color);
        g.draw(shape);
        g.setPaint(p);
    }
    public MyShape clone(){
        MyShape s = new MyShape();
        s.color = this.color;
        s.shape = (RectangularShape) shape.clone();
        return s;


    }
}
