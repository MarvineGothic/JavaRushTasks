package com.javarush.task.task33.task3309;

import javax.xml.bind.annotation.*;

@XmlType(name = "first")
@XmlRootElement
public class FirstSecond {
    class Second {
        public Second() {
        }
    }
}