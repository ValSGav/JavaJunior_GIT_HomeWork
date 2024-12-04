package ru.gb.lesson3.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.beans.Introspector;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListAPP {
    public static final String FILE_JSON = "task2.json";
    public static final String FILE_BIN = "task2.bin";
    public static final String FILE_XML = "task2.xml";
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final XmlMapper xmlMapper = new XmlMapper();

    public static void addNewTask(Scanner scanner, List<ToDo> tasks) {
        System.out.println( "Введите название задачи: " );
        String newTaskTitle = scanner.nextLine();
        tasks.add( new ToDo( newTaskTitle ) );

        saveTasksToFile( FILE_JSON, tasks );
        saveTasksToFile( FILE_BIN, tasks );
        saveTasksToFile( FILE_XML, tasks );

        System.out.println( "Новая задача добавлена" );

    }

    public static void saveTasksToFile(String filename, List<ToDo> tasks) {
        try {
            if ( filename.endsWith( ".json" ) ) {
                objectMapper.configure( SerializationFeature.INDENT_OUTPUT, true );
                objectMapper.writeValue( new File( filename ), tasks );

            } else if ( filename.endsWith( ".bin" ) ) {
                try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( filename ) )) {
                    oos.writeObject( tasks );
                }

            } else if ( filename.endsWith( ".xml" ) ) {
                xmlMapper.writeValue( new File( filename ), tasks );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ToDo> loadTasksFromFile(String fileName) {
        List<ToDo> tasks = new ArrayList<>();
        File file = new File( fileName );
        if ( file.exists() ) {
            try {
                if ( fileName.endsWith( ".json" ) ) {
                    tasks = objectMapper.readValue( file, objectMapper.getTypeFactory().constructCollectionType( List.class, ToDo.class ) );
                } else if ( fileName.endsWith( ".bin" ) ) {
                    try (ObjectInputStream ois = new ObjectInputStream( new FileInputStream( file ) )) {
                        tasks = (List<ToDo>) ois.readObject();
                    }
                } else if ( fileName.endsWith( ".xml" ) ) {
                    tasks = objectMapper.readValue( file, xmlMapper.getTypeFactory().constructCollectionType( List.class, ToDo.class ) );
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException( e );
            }
        }
        return tasks;
    }

    public static void markTaskAsDone(Scanner scanner, List<ToDo> tasks) {
        System.out.println( "Введите порядковый номер задачи для отметки ее как выполненной:" );
        String input = scanner.nextLine();

        try {
            int taskNumber = Integer.parseInt( input ) - 1;
            if ( taskNumber >= 0 && taskNumber < tasks.size() ) {
                tasks.get( taskNumber ).setDone( true );
                saveTasksToFile( FILE_JSON, tasks );
                saveTasksToFile( FILE_BIN, tasks );
                saveTasksToFile( FILE_XML, tasks );
                System.out.println( "Задача отмечена как выполненная" );

            } else {
                System.out.println( "Некорректный номер задачи. Попробуйте снова." );
            }
        } catch (NumberFormatException e) {
            System.out.println( "Некорректный ввод. Попробуйте снова." );
        }
    }

    public static void displayTasks(List<ToDo> tasks) {

        System.out.println( "Список здач:" );
        for (int i = 0; i < tasks.size(); i++) {
            ToDo task = tasks.get( i );
            String status = task.isDone() ? "[x]" : "[ ]";
            System.out.println( (i + 1) + ". " + status + " " + task.getTitle() );
        }

    }

}
