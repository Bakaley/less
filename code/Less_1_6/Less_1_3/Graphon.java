package Less_1_6.Less_1_3;

import java.util.Scanner;

public class Graphon {

    public static void main(String[] args) {

        int length;
        int height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину: (5)");

        while(!(scanner.hasNextInt())){
            System.out.println("Пожалуйста, целочисленное значение");
            scanner.next();
        }

        length = scanner.nextInt();

        System.out.println("Введите высоту: (7)");

        while(!(scanner.hasNextInt())){
            System.out.println("Пожалуйста, целочисленное значение");
            scanner.next();
        }

        height = scanner.nextInt();

        drawRect(length, height);
        drawEnvelope(length, height);
        drawChess(length, height);


    }

    private static void drawEnvelope (int length, int height){


        char[][]coordinates = new char[height][length];
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                coordinates[i][j] = ' ';
            }
        }

        for(int i = 0; i < length; i++){
            coordinates[0][i] = '*';
            coordinates[height-1][i] = '*';
        }

        for(int j = 0; j < height; j++){
            coordinates[j][0] = '*';
            coordinates[j][length-1] = '*';
        }

        double k = (height)/((length)*1.0);


        for (int y = 0; y < height; y++) {
            int x =(int)Math.round(y/k);
            coordinates[y][x] = '*';
            coordinates[y][length-x-1] = '*';
        }

        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                System.out.print(coordinates[i][j]);
            }
            System.out.println();
        }

    }

    private static void drawRect (int length, int height){

        char[][]coordinates = new char[height][length];
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
               coordinates[i][j] = ' ';
            }
        }

        for(int i = 0; i < length; i++){
            coordinates[0][i] = '*';
            coordinates[height-1][i] = '*';
        }

        for(int j = 0; j < height; j++){
            coordinates[j][0] = '*';
            coordinates[j][length-1] = '*';
        }

        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                System.out.print(coordinates[i][j]);
            }
            System.out.println();
        }

    }

    private static void drawChess (int length, int height) {


        char[][] coordinates = new char[height][length];
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                if ((Math.abs(i - j) %2 == 0)) coordinates[i][j] = '*';
                else coordinates[i][j] = ' ';
            }
        }

        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                System.out.print(coordinates[i][j]);
            }
            System.out.println();
        }
    }
}
