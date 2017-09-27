package com.javarush.task.task22.task2212;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Проверка номера телефона

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        return false;
    }

    public static void main(String[] args) {

    }
}
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        /*String temp = telNumber;
        if (telNumber.isEmpty())return false;
        int length = temp.replaceAll("\\D", "").length();
        if (telNumber.contains("[a-aA-Z]")) {return false;}
        if (length==12) {
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        else if (length==10) {
            return telNumber.matches("(^\\d|\\d*(\\(\\d{3}\\)))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
            //     return telNumber.matches("(^\\d+|\\d*(\\(\\d{3}\\)))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        return false;*/
        if (telNumber == null) return false;
        if (telNumber.isEmpty()) return false;
        int digits = telNumber.replaceAll("\\D", "").length();
        if ((telNumber.charAt(0) == '+' && digits == 12) || (telNumber.charAt(0) != '+' && digits == 10)) {
            return telNumber.matches("(\\+\\d+)?\\d*(\\(\\d{3}\\))?\\d+(-?\\d+){0,2}");
        } else return false;
    }

    public static void main(String[] args) {
        Map<String, Boolean> phones = new LinkedHashMap<>();
        ArrayList<String> list = new ArrayList<>();

        phones.put("null", false);
        phones.put("", false);
        phones.put("0501234567", true);
        phones.put("(050)1234567", true);
        phones.put("0(501)234567", true);
        phones.put("05(012)34567", true);
        phones.put("050(123)4567", true);
        phones.put("0501(234)567", true);
        phones.put("05012(345)67", true);
        phones.put("050123(456)7", true);

        phones.put("0-501234567", true);
        phones.put("05-01234567", true);
        phones.put("050-1234567", true);
        phones.put("0501-234567", true);
        phones.put("05012-34567", true);
        phones.put("050123-4567", true);
        phones.put("0501234-567", true);
        phones.put("05012345-67", true);
        phones.put("050123456-7", true);

        phones.put("(050)-1234567", true);
        phones.put("0(501)-234567", true);
        phones.put("05(012)-34567", true);
        phones.put("050(123)-4567", true);
        phones.put("0501(234)-567", true);
        phones.put("05012(345)-67", true);
        phones.put("050123(456)-7", true);

        phones.put("(050)-1-234567", true);
        phones.put("0(501)-2-34567", true);
        phones.put("05(012)-3-4567", true);
        phones.put("050(123)-4-567", true);
        phones.put("0501(234)-5-67", true);
        phones.put("05012(345)-6-7", true);

        phones.put("(050)-12-34567", true);
        phones.put("0(501)-23-4567", true);
        phones.put("05(012)-34-567", true);
        phones.put("050(123)-45-67", true);
        phones.put("0501(234)-56-7", true);
        phones.put("05012(345)-67", true);
        phones.put("1-23456789-0", true);

        phones.put("050123456", false);
        phones.put("(050)123(456)7", false);
        phones.put("0(501)23(456)7", false);
        phones.put("-(050)1234567", false);
        phones.put("-0501234567", false);
        phones.put("0501234567-", false);
        phones.put("(0501234567", false);
        phones.put("0501234567)", false);
        phones.put("0--501234567", false);
        phones.put("05--01234567", false);
        phones.put("050--1234567", false);
        phones.put("050123456--7", false);
        phones.put("0-(501)234567", false);
        phones.put("(0)501234567", false);
        phones.put("(05)01234567", false);
        phones.put("(050)1--234567", false);
        phones.put("(050)1-2-345-67", false);

        phones.put("1-234567(89-0)", false);
        phones.put("1-2345678(9-0)", false);
        phones.put("(1-2)3456789-0", false);

        phones.put("+380501234567", true);
        phones.put("+(380)501234567", true);
        phones.put("+3(805)01234567", true);
        phones.put("+38(050)1234567", true);
        phones.put("+380(501)234567", true);
        phones.put("+3805(012)34567", true);
        phones.put("+38050(123)4567", true);
        phones.put("+380501(234)567", true);
        phones.put("+3805012(345)67", true);
        phones.put("+38050123(456)7", true);
        phones.put("+380501234(567)", false);
        phones.put("+3805012345(67)", false);
        phones.put("+38050123456(7)", false);
        phones.put("+(380)-5-01234567", true);
        phones.put("+3(805)-0-1234567", true);
        phones.put("+38(050)-1-234567", true);
        phones.put("+380(501)-2-34567", true);
        phones.put("+3805(012)-3-4567", true);
        phones.put("+38050(123)-4-567", true);
        phones.put("+380501(234)-5-67", true);
        phones.put("+3805012(345)-6-7", true);
        phones.put("+38050123(456)-7", true);
        phones.put("+(380)5-01-234567", true);
        phones.put("+3(805)0-12-34567", true);
        phones.put("+38(050)1-23-4567", true);
        phones.put("+380(501)2-34-567", true);
        phones.put("+3805(012)3-45-67", true);
        phones.put("+38050(123)4-56-7", true);
        phones.put("+380501(234)5-67", true);
        phones.put("+3805012(345)6-7", true);
        phones.put("+38050123(456)7-", false);

        phones.put("+(380)50-123-4567", true);
        phones.put("+3(805)01-234-567", true);
        phones.put("+38(050)12-345-67", true);
        phones.put("+380(501)23-456-7", true);
        phones.put("+3805(012)34-567", true);
        phones.put("+38050(123)45-67", true);
        phones.put("+380501(234)56-7", true);
        phones.put("+3805012(345)67-", false);
        phones.put("+-38050123(456)7", false);

        phones.put("+(380)501-2345-67", true);
        phones.put("+3(805)012-3456-7", true);
        phones.put("+38(050)123-4567", true);
        phones.put("+380(501)234-567", true);
        phones.put("+3805(012)345-67", true);
        phones.put("+38050(123)456-7", true);
        phones.put("+380501(234)567-", false);

        phones.put("+(380)5012--34567", false);
        phones.put("+3(805)0123--4567", false);
        phones.put("+38(050)1234--567", false);
        phones.put("+380(501)2345--67", false);
        phones.put("+3805(012)3456--7", false);
        phones.put("+38050(123)4567-", false);
        phones.put("+3-80501(234)567", false);
        phones.put("+38-05012(345)67", false);
        phones.put("+380-50123(456)7", false);

        phones.put("+(380)50123-4567", true);
        phones.put("+3(805)01234-567", true);
        phones.put("+38(050)12345-67", true);
        phones.put("+380(501)23456-7", true);
        phones.put("+3805(012)34567-", false);
        phones.put("+38050(123)4567", true);
        phones.put("+380501(234)567", true);
        phones.put("+3805012(345)67", true);
        phones.put("+38050123(456)7", true);


        phones.put("+3805012345q67", false);
        phones.put("+3805012345 67", false);
        phones.put("+3805012345.67", false);
        phones.put("+3805012345,67", false);


        phones.put("+38051202(345)-7", true);
        phones.put("(345)0512027", true);
        phones.put("+-313450531202", true);
        phones.put("+-313450531202-", false);
        phones.put("+380501212334567", false);
        phones.put("+3805012asd34567", false);
        phones.put("+38(050)1234567", true);
        phones.put("+38(150)1234567", true);
        phones.put("+3+8(050)1234567", false);
        phones.put("+38(050)12-34-567", true);
        phones.put("+38(050)12-34567", true);
        phones.put("+38(050)112-34567", false);
        phones.put("+38(050)12-34(5)67", false);
        phones.put("+3(8)(050)12-34567", false);
        phones.put("+38050123-45-67", true);
        phones.put("+38050123-45-6789", false);
        phones.put("050123-4567", true);
        phones.put("050123-45678", false);
        phones.put("+38)050(1234567", false);
        phones.put("+38(050)1-23-45-6-7", false);
        phones.put("050ххх4567", false);
        phones.put("050123456", false);
        phones.put("(0)501234567", false);
        phones.put("+38-(050)1234567", false);
        phones.put("38-(050)34567", false);
        phones.put("-38-(050)34567", false);
        phones.put("38-(050)34567-", false);
        phones.put("38(050)3(45)67", false);
        phones.put("(380)(050)3567", false);
        phones.put("+38(380)(050)3567", false);
        phones.put("8(380)(050)367", false);
        phones.put("8(380)4(050)67", false);
        phones.put("+38((050)1234567", false);
        phones.put("+5(0--5)1234567", false);
        phones.put("7-4-4123689-5", false);
        phones.put("+(012)123456789", true);
        phones.put("+(012)1-2345678-9", true);
        phones.put("+(012)-12345678-9", true);
        phones.put("+(012)-1-23456789", true);
        phones.put("+(012)1234567", false);
        phones.put("+(01-2)123456789", false);
        phones.put("+(012)12345678--9", false);
        phones.put("+(012)--123456789", false);
        phones.put("+38050(123)(456)7", false);


        for (Map.Entry<String, Boolean> entry : phones.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " | " + checkTelNumber(entry.getKey()));
        }
    }

}
