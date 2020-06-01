package Less_1_6.Less_1_3;

public class Students {

    // эта модель данных предполагает, что у всех студентов одинаковое количество дисциплин и занятий по ним
    static String [][][][] rating = new String [0][5][16][2];

    // первый уровень - фамилия студента, индекс - номер стундента в массиве
    static String[] studentsSurnames = new String[0];

    // второй уровень - дисциплина, индекс - номер дисциплины в массиве
    static String [] disciplines = new String[]{"История", "Матан", "Физика", "Программирование", "Английский"};

    // третий уровень - индекс - номер занятия (всего 16)
    static final int lessonCount = 16;

    // четвертый уровень: индекс 0 - посещаемость, индекс 1 - оценка



    static void addStudent (String newStudent) {

        String[] newStudentList = new String[studentsSurnames.length + 1];
        for (int i = 0; i < studentsSurnames.length; i++) {
            newStudentList[i] = studentsSurnames[i];
        }

        newStudentList[studentsSurnames.length] = newStudent;
        studentsSurnames = newStudentList;

        // пересоздание 4-мерного массива с сохранением оценок, но с новым студентом

        String [][][][] newRating = new String [studentsSurnames.length][disciplines.length][lessonCount][2];

        for (int i = 0; i <rating.length; i++){
            newRating[i] = rating[i];
        }
        newRating[studentsSurnames.length-1] = new String[5][16][2];
        rating = newRating;
    }

    static int getStudentNumber (String surname){
        for (int i = 0; i < studentsSurnames.length; i++) {
            if(studentsSurnames[i].equals(surname))  return i;
        }
        return -1;
    }

    static int getDisciplineNumber (String discipline){
        for (int i = 0; i < disciplines.length; i++) {
            if(disciplines[i].equals(discipline))  return i;
        }
        return -1;
    }

    static void print(){

        for (int i = 0; i < rating.length; i++) {

            System.out.println(studentsSurnames[i] + ": ");
            for (int j = 0; j < rating[0].length; j++) {
                System.out.print("\t" + disciplines[j]  + ": ");

                if(!isAttested(i, j)) System.out.print("N/A");
                else {
                    for (int k = 0; k < rating[i][j].length; k++) {
                        if(rating[i][j][k][1] != null) System.out.print( rating[i][j][k][1] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    static boolean contains(String surname){
        return getStudentNumber(surname)>0;
    }

    static boolean isAttested (int studentNumber, int disciplineNumber){

        for (int i = 0; i < lessonCount; i++) {
            if(rating[studentNumber][disciplineNumber][i][1] != null) return true;
        }
        return false;
    }


    static void rate (String studentSurname, String discipline, int lesson, String newRating){
        rating[getStudentNumber(studentSurname)][getDisciplineNumber(discipline)][lesson][1] = newRating;
    }


    public static void main(String[] args) {
        addStudent("Иванов");
        addStudent("Петров");
        addStudent("Сидоров");

        print();

        rate("Иванов", "Матан", 8, "8");
        rate("Иванов", "Матан", 2, "4");
        rate("Иванов", "Матан", 7, "10");

        System.out.println(contains("Сидоров"));

        print();

    }
}
