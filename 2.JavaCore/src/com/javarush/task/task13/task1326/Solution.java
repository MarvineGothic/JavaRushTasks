package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
    }
}
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {                         //  solved
    public static void main(String[] args) throws IOException{
// напишите тут ваш код
        BufferedReader readTrackFile = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader fis = new BufferedReader(new InputStreamReader(new FileInputStream(readTrackFile.readLine())))) {
            ArrayList sf = new ArrayList<>();
            String line = " ";
            while ((line = fis.readLine()) != null) {
                int x = Integer.parseInt(line);
                if (x % 2 == 0) {
                    sf.add(x);
                }
            }
            Collections.sort(sf);
            for (Object i : sf) {
                System.out.println(i);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}