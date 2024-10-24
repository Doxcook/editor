package org.example.controller;

import org.example.model.Model;
import org.example.model.MyShape;
import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Collection;

public class Controller {

    //поля для доступа к панели, рамке, модели
    Panel panel;
    Frame frame;
    public Model model;

    Point2D[] points; //храним точки для фигуры


    //конструктор по умолчанию
    public Controller() {
        model = Model.getInstance(); // синглтон для того, чтоб модель точно была единственна
        panel = new Panel(this);
        frame = new Frame(panel);
        points = new Point2D[2]; //храним две точки для фигуры
        model.setCurrentShape(new MyShape()); // ставим сразу фигуру в текущую
    }

    //обработка действий мыши: нажатие кнопки
    public void mousePressed(Point point){
        points[0]=point; // ставим первую точку
        model.createShape(); //создаем фигуру в модели

    }

    //обработка действий мыши: перемещение
    public void mouseDragged(Point point){
        points[1]=point; //ставим вторую (завершающую) точку
        model.setFrame(points); //устанавливаем размер фигуру из массива точек
    }

    //достаем коллекцию фигур из модели
    public Collection<MyShape> translate(){
        return model.getList();
    }
}
