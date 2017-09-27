package com.javarush.task.task19.task1902;

/* 
Адаптер

public class AdapterFileOutputStream {

    public static void main(String[] args) {

    }


}
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {               // solved

    private FileOutputStream fileOutputStream;           // very important to name it as fileOutputStream

    AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }


    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        this.fileOutputStream.write(s.getBytes());     // some strange .getBytes!!!
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close();
    }

    public static void main(String[] args) {

    }
}

