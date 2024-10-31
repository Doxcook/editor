package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    Panel panel; //для доступа к панели
    Controller controller;
    public Frame(Panel panel, Controller controller) throws HeadlessException {
        this.controller = controller;
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuShape = new JMenu("shape");
        menuBar.add(menuShape);
        JMenuItem itemRec = new JMenuItem("rectangle");
        JMenuItem itemEll = new JMenuItem("ellipse");
        menuShape.add(itemRec);
        menuShape.add(itemEll);
        itemRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setRectangle();
            }
        });
        itemEll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setEllipse();
            }
        });


        JMenu menuAction = new JMenu("action");
        menuBar.add(menuAction);
        JMenuItem itemCreate = new JMenuItem("Create");
        JMenuItem itemMove = new JMenuItem("Move");
        menuAction.add(itemCreate);
        menuAction.add(itemMove);



        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(1000,1000); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
