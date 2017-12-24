package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName, partOfContent;
    private int minSize = -1, maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean containsName = partOfName == null || file.getFileName().toString().contains(partOfName);
        boolean containsContent = partOfContent == null ||
                Files.lines(file).anyMatch(string -> string.matches(".*" + partOfContent + ".*"));

        boolean larger = minSize == -1 || attrs.size() >= minSize;
        boolean smaller = maxSize == -1 || attrs.size() <= maxSize;
        if (containsName && containsContent && larger && smaller) foundFiles.add(file);
        return super.visitFile(file, attrs);
    }

    // getters setters
    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}