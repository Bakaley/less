package Less_1_6.Students;

import java.util.*;

public class Student {

    public String name;
    public String surname;
    public HashMap <String, ArrayList<Integer>> marks = new HashMap<>();

    public static ArrayList<Student> group = new ArrayList<>();

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

        addStudent("Петр", "Петров");
        addStudent("Иван", "Иванов");
        addStudent("Сергей", "Сергеев");
        addStudent("Андрей", "Андреев");

        Student student = findStudent("Петров");
        //вывести имя Петрова
        System.out.println(student.name);
        //есть ли в группе Андропов
        System.out.println(findStudent("Андропов"));
        //отчисляем Петрова
        deleteStudent(student);
        //количество студентов после отчисления Петрова
        System.out.println(group.size());

        student = findStudent("Иванов");

        rate(student, "История", 9);
        rate(student, "История", 10);
        rate(student, "История", 8);
        rate(student, "Философия", 9);

        System.out.println("////////////////////////////");

        print();

    }

    public static void addStudent (String name, String surname){
        group.add(new Student(name, surname));
    }

    public static Student findStudent (String surname){
        Iterator iterator = group.iterator();
        while (iterator.hasNext()){
            Student student = (Student)iterator.next();
            if(student.surname.equals(surname)){
              return student;
            }
        }
        return null;
    }

    public static void deleteStudent (Student student){
        Iterator iterator = group.iterator();
        while (iterator.hasNext()){
            Student curStudent = (Student)iterator.next();
            if(student == curStudent){
                iterator.remove();
                group.remove(student);
            }
        }
    }

    public static void print () {

        Iterator iterator = group.iterator();
        Student student;
        while (iterator.hasNext()){
            student = (Student)iterator.next();
            System.out.println(student.surname + ": ");
            Iterator iteratorDiscipline = student.marks.keySet().iterator();

            while (iteratorDiscipline.hasNext()){
                String discipline = (String)iteratorDiscipline.next();
                ArrayList<Integer> currentMarkList = student.marks.get(discipline);
                System.out.print("\t" + discipline  + ": ");

                if (currentMarkList.size() == 0) System.out.print("N/A");
                else {
                    Iterator markIterator = currentMarkList.iterator();
                    while (markIterator.hasNext()){
                        System.out.print(markIterator.next() + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void rate (Student student, String discipline, Integer mark){
        student.marks.get(discipline).add(mark);
    }
}

