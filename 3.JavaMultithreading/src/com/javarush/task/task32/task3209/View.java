package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 02.07.2017.
 */
public class View extends JFrame implements ActionListener {

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();                      // 11.1. Добавь в представление поле
    private UndoListener undoListener = new UndoListener(undoManager);      // 11.4. Добавь в представление поле UndoListener undoListener


    public UndoListener getUndoListener() {                              // 11.5.4
        return undoListener;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();
        switch (action){
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе": showAbout();
        }

    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        addWindowListener(listener);
        setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();    // 9.1.1. Создавать новый объект
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);                      // 9.1.3

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");                   // 6.1. Устанавливать значение «text/html»
        JScrollPane pane = new JScrollPane(htmlTextPane);          // 6.2. Создавать новый локальный компонент
        tabbedPane.addTab("HTML", pane);                     // 6.3. Добавлять вкладку в панель tabbedPane
        JScrollPane plainPane = new JScrollPane(plainTextPane);   // 6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane
        tabbedPane.addTab("Текст", plainPane);               // 6.5. Добавлять еще одну вкладку в tabbedPane с именем «Текст»
        tabbedPane.setPreferredSize(new Dimension(800, 600));                           // 6.6. Устанавливать предпочтительный размер панели tabbedPane.
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));        // 6.7. Создавать объект класса TabbedPaneChangeListener
        // 6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    public void selectedTabChanged() {
       if (tabbedPane.getSelectedIndex() == 0){                // 18.1. Метод должен проверить, какая вкладка сейчас оказалась выбранной
           controller.setPlainText(plainTextPane.getText());        // 18.2

       } else {
           plainTextPane.setText(controller.getPlainText());        // 18.3.
       }
        resetUndo();
    }

    public boolean canUndo() {                  // 11.5.3
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {                 // 11.5.1. void undo()
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {                      // 11.5.2. void redo()
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {                  // 11.5.5. Добавь и реализуй метод void resetUndo()
        undoManager.discardAllEdits();
    }

    // 13.1. Добавь в представление метод boolean isHtmlTabSelected()
    public boolean isHtmlTabSelected() {
        if (tabbedPane.getSelectedIndex() == 0)
            return true;
        else return false;
    }

    public void selectHtmlTab() {                       // 14.1. Добавь в класс представления метод selectHtmlTab()
        tabbedPane.setSelectedIndex(0);                                  // 14.1.1. Выбирать html вкладку
        resetUndo();                                    // 14.1.2. Сбрасывать все правки
    }
    public void update(){                          // 14.3. Добавь в представление метод update()
        htmlTextPane.setDocument(controller.getDocument());
    }
    public void showAbout(){                       // 14.4. Добавь в представление метод showAbout()
       JOptionPane.showMessageDialog(this, "HTML Editor",
               "About", JOptionPane.INFORMATION_MESSAGE);
    }

}
