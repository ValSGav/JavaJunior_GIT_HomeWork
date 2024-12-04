package ru.gb.lesson3.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class App {
    /*
    Разработайте класс Student  с полями String name, int age, transient double GPA(средний балл)
    Обеспечьте поддержку сериализации этого класса
    Создайте объект класса Student и инициализируйте его данными
    Сериализуйте этот объект в файл
    Десериализуйте этот объект обратно в программу из файла
    Выведите все поля объекта, ключая GPA и обсудите, почему значение GPA не было сохранено/восстановлено
    ++ реализовать сериализацию json и  xml
    * */

    public static final XmlMapper xmlMapper = new XmlMapper();
    public static final ObjectMapper objMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

//        List<Student> students = generateListOfStudents();
//        Student student = new Student("Alex", 26, 9);
//
//
//        try (FileOutputStream fileOutputStream = new FileOutputStream("students.bin")) {
//
//
//            //сериализация в формате бинароного файла
//            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
//            oos.writeObject(student);
//
//            //сериализация в формате json
//
//            objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//            objMapper.writeValue(new File("students.json"), students);
//
//            //сериализация в формате xml
//            xmlMapper.writeValue(new File("students.xml"), students);
//
//            System.out.printf("Сериализовали объект %s", student);
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try (FileInputStream fileInputStream = new FileInputStream("students.bin")) {
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Student readesStudent = (Student) ois.readObject();
            System.out.println();
            System.out.printf("Дериализовали объект %s", readesStudent);

            //Не удалось разобраться с XML - выдает ошибку, что встречается символ
            // "<", а ожидается валидный символ или json строка...
            // File xmlFile = new File("students.xml");
//            FileInputStream fis2 = new FileInputStream(xmlFile);
//            int i;
//            while((i=fis2.read())!= -1){
//
//                System.out.print((char)i);
//            }
            // if (xmlFile.exists()) {
            //    JavaType cType = xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class);
            //     ArrayList<Student> loadedStudent = objMapper.readValue(xmlFile, cType);
            //     System.out.println("Десериализовали объекты xml: ");
            //     System.out.println(loadedStudent);
            // }

            ArrayList<Student> loadedStudentFromJSON = objMapper.readValue(new File("students.json"),
                    objMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
            System.out.println("Десериализовали объекты json: ");
            System.out.println(loadedStudentFromJSON);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static List<Student> generateListOfStudents() {
        List<Student> generatesStudents = new ArrayList<>();
        generatesStudents.add(new Student("Alex", 26, 9));
        generatesStudents.add(new Student("Mary", 21, 7));
        generatesStudents.add(new Student("Suzi", 17, 4));
        generatesStudents.add(new Student("Killian", 29, 5));
        return generatesStudents;
    }

}