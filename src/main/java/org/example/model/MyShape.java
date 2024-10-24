package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

//класс фигуры
public class MyShape {
    RectangularShape shape; //объект прямоугольника
    Color color; //цвет

    // конструктор по умолчанию
    public MyShape() {
        color = Color.BLUE; //цвет обводки
        shape = new Rectangle2D.Double(); //фигура - прямоугольник
    }

    //геттер фигуры
    public RectangularShape getShape() {
        return shape;
    }

    //создание фигуры по точкам
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

    //метод клонирования
    public MyShape clone(){
        MyShape s = new MyShape(); //создаем новую фигуру

        //ставим все характеристики прошлой
        s.color = this.color;
        s.shape = (RectangularShape) shape.clone();

        //возвращаем готовую копию
        return s;
    }
}
