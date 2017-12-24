package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
public class Solution {

    public static void main(String[] args) throws IOException {
    }
}
*/
public class Solution {  // solved

    private static int folders;
    private static int files;
    private static long sizeBytes;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = "";
            while ((input = reader.readLine()) != null) {
                Path path = Paths.get(input);
                insideFolder(path);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insideFolder(Path path) throws IOException {
        if (Files.isDirectory(path)) {
            folders = 0;
            files = 0;
            sizeBytes = 0;
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    files++;
                    sizeBytes += attrs.size();
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (!dir.equals(path)) folders++;
                    return super.postVisitDirectory(dir, exc);
                }
            });
            System.out.println("Всего папок - " + folders);
            System.out.println("Всего файлов - " + files);
            System.out.println("Общий размер - " + sizeBytes);
        } else System.out.println(path.toAbsolutePath() + " - не папка");
    }
}
