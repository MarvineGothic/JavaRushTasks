package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Admin on 02.07.2017.
 */
public class RedoAction extends AbstractAction {       // 12.1
    private View view;                              // 12.1.1. Добавь в класс поле View

    public RedoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {          // 12.1.2. Реализуй метод
        view.redo();
    }
}
