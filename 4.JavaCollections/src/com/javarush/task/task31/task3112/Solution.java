package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {  // solved
    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://www.amigo.com/ship/secretPassword.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Path temp = Files.createTempFile("jr_temp-", ".tmp");
        String fileName = urlString.substring(urlString.lastIndexOf("/"));
        Path file = Paths.get(downloadDirectory + fileName);
        InputStream inputStream = url.openStream();

        Files.copy(inputStream, temp, StandardCopyOption.REPLACE_EXISTING);
        if (!Files.exists(downloadDirectory)) try {
            Files.createDirectory(downloadDirectory);
        } catch (IOException e) {
            System.out.println("Error while creating a directory");
        }
        Files.move(temp, file, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();
        return file;
    }
}
