package com.javarush.task.task31.task3102;

import com.javarush.task.task31.task3101.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/* 
Находим все файлы
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        return null;

    }

    public static void main(String[] args) {

    }
}
*/
public class Solution {            // solved

    public static List<String> getFileTree(String root) throws IOException {
        List<String> filesPaths = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Paths.get(root))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> filesPaths.add(path.toString()));
        } catch (IOException e) {
            System.out.printf("No such directory: %s\n", root);
        }
        return filesPaths;

    }


    public static void main(String[] args) {
        /*try {
            getFileTree("k://Загрузки/").forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        // for total commander project
        List<File> list = new ArrayList<>();
        File file = new File("k://");
        list.addAll(Arrays.asList(FileUtils.openDir(file)));
        for (File f : list) {
            System.out.println(f);
            for (File fl :
                    FileUtils.openDir(f)) {
                System.out.println("    " + fl.getName());
            }
        }
    }
}
