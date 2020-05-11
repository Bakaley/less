import java.util.Arrays;

public class Students {

    static void addStudent (String newStudent) {
        String[] newStudentList = new String[studentsSurnames.length + 1];
        for (int i = 0; i < studentsSurnames.length; i++) {
            newStudentList[i] = studentsSurnames[i];
        }
        newStudentList[studentsSurnames.length] = newStudent;
        // пересоздание 3-мерного массива с сохранением оценок, но с новым студентом

    }

    static void rate (String studentSurname, String discipline, String newRating){
        /*
        найти студента из списка studentsSurnames, вернуть индекс
        найти дисциплину из списка disciplines, вернуть индекс
        поставить в rating[студ][дисц][1] оценку
         */
    }


    static String [][][] rating = new String [3][5][2];

    // первый уровень - фамилия студента, индекс - номер стундента в массиве

    static String[] studentsSurnames = new String[]{"Иванов", "Петров",  "Сидоров"};

    // второй уровень - дисциплина, индекс - номер дисциплины в массиве
    static String [] disciplines = new String[]{"История", "Матан", "Физика", "Программирование", "Английский"};

    // третий уровень: индекс 0 - посещаемость, индекс 1 - оценка



}
