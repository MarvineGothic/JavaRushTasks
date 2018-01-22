package com.javarush.task.task33.task3307;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringReader;
import java.util.Objects;

/* 
Десериализация XML объекта
*/
public class Solution {            // solved
    public static void main(String[] args) throws IOException, JAXBException {
        String xmlData = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        Cat cat = convertFromXmlToNormal(xmlData, Cat.class);
        System.out.println(cat);
    }

    //@SuppressWarnings("unchecked")
    public static <T> T convertFromXmlToNormal(String xmlData, Class<T> clazz) throws IOException, JAXBException {
        assert Objects.equals(clazz.getSimpleName(), "Cat");
        StringReader reader = new StringReader(xmlData);
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unMarshaller = context.createUnmarshaller();
        return clazz.cast(unMarshaller.unmarshal(reader));   // checked cast to T
    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        public int age;
        public int weight;

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}
