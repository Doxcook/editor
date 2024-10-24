package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Collection;

public class Controller {
    //поля для доступа к панели, рамке, модели
    Panel panel;
    Frame frame;
    public Model model;
    Point2D[] points;


    //конструктор по умолчанию
    public Controller() {
        model = new Model();
        panel = new Panel(this);
        frame = new Frame(panel);
        points = new Point2D[2];
        model.setCurrentShape(new MyShape());
    }

    //обработка действий мыши: нажатие кнопки
    public void mousePressed(Point point){
        points[0]=point;
       model.createShape();

    }

    //обработка действий мыши: перемещение
    public void mouseDragged(Point point){
        points[1]=point;
        model.setFrame(points);



    }

    //достаем коллекцию фигур из модели
    public Collection<MyShape> translate(){
        return model.getList();
    }
}
