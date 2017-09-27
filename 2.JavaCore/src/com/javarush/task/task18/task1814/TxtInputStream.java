package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) {
    }

    public static void main(String[] args) {
    }
}
*/

public class TxtInputStream extends FileInputStream {            // solved
    private TxtInputStream txtInputStream;

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
        super(fileName);


        if (!fileName.endsWith(".txt")) {
            super.close();                                         // important
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
    }
}

