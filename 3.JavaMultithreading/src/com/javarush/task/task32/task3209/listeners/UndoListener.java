package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by Admin on 02.07.2017.
 */
public class UndoListener implements UndoableEditListener {      //  11.2. Добавь класс
    private UndoManager undoManager;                           // 11.3.1. Поле UndoManager undoManager

    public UndoListener(UndoManager undoManager) {            // 11.3.2. Конструктор
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {        // 11.3.3. Метод undoableEditHappened(UndoableEditEvent e)
        undoManager.addEdit(e.getEdit());
    }

}
