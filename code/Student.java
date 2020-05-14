import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Student {

    public String name;
    public String surname;

    public HashMap <String, ArrayList<Integer>> marks = new HashMap<>();

    Student(String name, String surname){

        this.name = name;
        this.surname = surname;

        marks.put("Матан", new ArrayList<>());
        marks.put("История", new ArrayList<>());
        marks.put("Философия", new ArrayList<>());
        marks.put("Программирование", new ArrayList<>());
        marks.put("Английский", new ArrayList<>());
    }

    public static void main(String[] args) {
        HashMap <Integer, Student> group = new HashMap<>();

       addStudent(group, "Петр", "Петров");
       addStudent(group, "Иван", "Иванов");
       addStudent(group, "Сергей", "Сергеев");

        System.out.println(group.containsKey(2));
    }

    public static void addStudent (HashMap <Integer, Student> group, String name, String surname){

        if(group.size()==0){
            group.put(1, new Student(name, surname));
        }
        else {
            group.put(Collections.min(group.keySet()) + 1, new Student(name, surname));
        }

    }



}
