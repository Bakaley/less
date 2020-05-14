package Before_Students;

import java.util.Arrays;

public class Students {

    // эта модель данных предполагает, что у всех студентов одинаковое количество дисциплин и занятий по ним

    static void addStudent (String newStudent) {
        String[] newStudentList = new String[studentsSurnames.length + 1];
        for (int i = 0; i < studentsSurnames.length; i++) {
            newStudentList[i] = studentsSurnames[i];
        }

        newStudentList[studentsSurnames.length] = newStudent;
        studentsSurnames = newStudentList;

        // пересоздание 3-мерного массива с сохранением оценок, но с новым студентом

        String [][][][] newRating = new String [studentsSurnames.length][5][16][2];

        for (int i = 0; i <=rating.length; i++){
            newRating[i] = rating[i];

        }


    }

    static void rate (String studentSurname, String discipline, int lesson, String newRating){
        /*
        найти студента из списка studentsSurnames, вернуть индекс
        найти дисциплину из списка disciplines, вернуть индекс
        поставить в rating[студ][дисц][№занятия][1] оценку
         */
    }


    static String [][][][] rating = new String [3][5][16][2];

    // первый уровень - фамилия студента, индекс - номер стундента в массиве

    static String[] studentsSurnames = new String[]{"Иванов", "Петров",  "Сидоров"};

    // второй уровень - дисциплина, индекс - номер дисциплины в массиве
    static String [] disciplines = new String[]{"История", "Матан", "Физика", "Программирование", "Английский"};

    // третий уровень: индекс - номер занятия (всего 16)

    // четвертый уровень: индекс 0 - посещаемость, индекс 1 - оценка



}
