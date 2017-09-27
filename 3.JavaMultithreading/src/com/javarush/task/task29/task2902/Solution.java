package com.javarush.task.task29.task2902;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Рефакторинг в соответствии с Naming and Code Convention 2
public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        Solution Solution = new Solution();
        String file_name_to_be_opened_by_notepad = Solution.Getabsolutepathtodefaulttxtfile().toString();
        Process NOTEPAD = Solution.getprocessstartnotepad(file_name_to_be_opened_by_notepad);
        NOTEPAD.waitFor();
    }

    public Process getprocessstartnotepad(String FILE_NAME) throws IOException {
        String[] cmd_array = new String[]{"notepad.exe", FILE_NAME};
        return Runtime.getRuntime().exec(cmd_array);
    }

    public Path Getabsolutepathtodefaulttxtfile() {
        URI uRi = Solution.class.getResource("file.txt").toURI();
        return  Paths.get(uRi);
    }
}

*/
public class Solution {       // solved
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
        Solution solution = new Solution();
        String fileNameToBeOpenedByNotepad = solution.getAbsolutePathToDefaultTxtFile().toString();
        Process notepad = solution.getProcessStartNotepad(fileNameToBeOpenedByNotepad);
        notepad.waitFor();
    }

    public Process getProcessStartNotepad(String fileName) throws IOException {
        String[] cmdArray = new String[]{"notepad.exe", fileName};
        return Runtime.getRuntime().exec(cmdArray);
    }

    public Path getAbsolutePathToDefaultTxtFile() throws URISyntaxException {
        URI uri = Solution.class.getResource("file.txt").toURI();
        return  Paths.get(uri);
    }
}
