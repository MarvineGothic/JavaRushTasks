package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

/**
 * Created by Admin on 02.07.2017.
 */
public class TextEditMenuListener implements MenuListener {
    private View view;                           // 13.2.
    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent menuEvent) {            // 13.3
        JMenu jMenu = (JMenu) menuEvent.getSource();
        Component[] components = jMenu.getMenuComponents();   // 13.3.2
        for (Component component: components)                 // 13.3.3. Для каждого пункта меню вызывать метод setEnabled
            component.setEnabled(view.isHtmlTabSelected());
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
