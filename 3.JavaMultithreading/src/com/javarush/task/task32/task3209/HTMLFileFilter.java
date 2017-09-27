package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Admin on 03.07.2017.
 */
public class HTMLFileFilter extends FileFilter {      // 21.1. Создай публичный класс HTMLFileFilter
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        else if (!file.isDirectory()) {
            String fileName = file.getName().toLowerCase();
            return fileName.endsWith(".html") || fileName.endsWith(".htm");
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
