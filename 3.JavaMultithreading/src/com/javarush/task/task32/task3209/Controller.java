package com.javarush.task.task32.task3209;

import javafx.scene.control.Tab;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/**
 * Created by Admin on 02.07.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public HTMLDocument getDocument() {                   // 14.2. Добавь в класс контроллера геттер для модели
        return document;
    }

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {             // 20.2. Реализуй метод инициализации init() контроллера.
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void resetDocument() {
        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());        // 15.1. Удалять у текущего документа
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();  // 15.2. Создавать новый документ
        document.addUndoableEditListener(view.getUndoListener());               // 15.3. Добавлять новому документу слушателя правок.
        view.update();           // 15.4. Вызывать у представления метод update()
    }

    public void setPlainText(String text) {
        resetDocument();                                       // 16.1. Сбрось документ.
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader, document, 0);   //16.3. Вызови метод read()
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter stringWriter = new StringWriter();        //17.1. Создай объект StringWriter
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {          // 20.1. Реализуй метод создания нового документа createNewDocument() в контроллере
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int n = fileChooser.showOpenDialog(view);
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();      // 23.2.1. Установить новое значение currentFile.
            resetDocument();                                // 23.2.2. Сбросить документ.
            view.setTitle(currentFile.getName());             // 23.2.3. Установить имя файла в заголовок у представления.

            try {
                FileReader reader = new FileReader(currentFile);      // 23.2.4. Создать FileReader, используя currentFile.
                new HTMLEditorKit().read(reader, document, 0);   // 23.2.5. Вычитать данные
                view.resetUndo();                                      // 23.2.6. Сбросить правки
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocument() {     // 23.1. Напишем метод для сохранения открытого файла saveDocument().
        if (currentFile != null) {
            view.selectHtmlTab();
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }else saveDocumentAs();
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int n = fileChooser.showSaveDialog(view);
        if (n == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter fileWriter = new FileWriter(currentFile);
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
