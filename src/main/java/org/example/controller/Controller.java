package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionInterface;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;

public class Controller {

    //поля для доступа к панели, рамке, модели
    Panel panel;
    Frame frame;
    public Model model;
    //ActionDraw actionDraw; //new actionInterface
    ActionInterface actionInterface;


    //конструктор по умолчанию
    public Controller() {
        model = Model.getInstance(); // синглтон для того, чтоб модель точно была единственна
        panel = new Panel(this);
        frame = new Frame(panel, this);
        model.setCurrentShape(new MyShape()); // ставим сразу фигуру в текущую
        actionInterface = new ActionDraw(model);

    }

    public void setActionInterface(ActionInterface actionInterface) {
        this.actionInterface = actionInterface;
        actionInterface.setModel(model);
    }

    //обработка действий мыши: нажатие кнопки
    public void mousePressed(Point point){
         actionInterface.mousePressed(point);

    }

    //обработка действий мыши: перемещение
    public void mouseDragged(Point point){
        actionInterface.mouseDragged(point);
    }

    //достаем коллекцию фигур из модели
    public Collection<MyShape> translate(){
        return model.getList();
    }

    public void setRectangle() {
        actionInterface.setSampleShape(new MyShape(new Rectangle2D.Double(),Color.BLUE));
    }

    public void setEllipse() {
        actionInterface.setSampleShape(new MyShape(new Ellipse2D.Double(), Color.cyan));
    }
}
