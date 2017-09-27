package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by Admin on 02.07.2017.
 */
public class UndoMenuListener implements MenuListener {
    private View view;                              // 10.1.1
    private JMenuItem undoMenuItem;                  // 10.1.2
    private JMenuItem redoMenuItem;                   // 10.1.3

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {  //  10.2
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {
        if (view.canUndo())
            undoMenuItem.setEnabled(true);
        else undoMenuItem.setEnabled(false);
        if (view.canRedo())
            redoMenuItem.setEnabled(true);
        else redoMenuItem.setEnabled(false);

    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
