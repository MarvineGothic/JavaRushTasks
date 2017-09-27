package com.javarush.task.task32.task3209.actions;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Admin on 02.07.2017.
 */
public class UndoAction extends AbstractAction {            // 12.2.
    private View view;

    public UndoAction(View view) {
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        view.undo();
    }
}
