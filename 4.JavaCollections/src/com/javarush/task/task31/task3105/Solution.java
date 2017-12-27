package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
public class Solution {
    public static void main(String[] args) throws IOException {
    String fileName = "k://c.txt";
        String zipName = "k://archive.zip";
    }
}
*/
public class Solution {             // solved
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipName = args[1];
        File file = new File(fileName);
        Map<String, ByteArrayOutputStream> archFiles = new HashMap<>();


        try (FileInputStream inputStream = new FileInputStream(zipName);
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int count = 0;
                while ((count = zipInputStream.read(buf)) != -1)
                    byteArrayOutputStream.write(buf, 0, count);
                archFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream(zipName);
             ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
            for (Map.Entry<String, ByteArrayOutputStream> pair : archFiles.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutputStream.write(pair.getValue().toByteArray());
            }
            zipOutputStream.putNextEntry(new ZipEntry("new/" + file.getName()));
            Files.copy(file.toPath(), zipOutputStream);
        }
    }
}