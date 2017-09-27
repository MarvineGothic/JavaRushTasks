package com.javarush.task.task18.task1820;

/* 
Округление чисел
public class Solution {
    public static void main(String[] args) {

    }
}
*/

import java.io.*;

public class Solution {            //  solved
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

        FileInputStream filein = new FileInputStream(fileName1);
        FileOutputStream fileout = new FileOutputStream(fileName2);

        if (filein.available() > 0){
            byte[] data = new byte[filein.available()];
            filein.read(data);

            String[] strArrDouble = new String(data).split(" ");
            StringBuilder resultStrLong = new StringBuilder(data.length);

            for (String strDouble : strArrDouble) {
                resultStrLong.append(Math.round(Double.valueOf(strDouble)));
                resultStrLong.append(" ");
            }
            fileout.write(resultStrLong.toString().getBytes());
        }
        filein.close();
        fileout.close();
    }
}
