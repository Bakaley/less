package Before_Students;

import java.util.Scanner;

public class Rectangle {


    public static double getInput (String coordinate, String position){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите целое или дробное число (8,27) координаты " + coordinate + " " + position + " точки");

        while(!(scanner.hasNextDouble())){
            System.out.println("Пожалуйста, введите число");
            scanner.next();
        }
        return scanner.nextDouble();

    }

    public static void main(String[] args) {

        double left_top_x = getInput("X", "левой верхней");
        double left_top_y = getInput("Y", "левой верхней");
        double right_bot_x = getInput("X", "правой нижней");
        double right_bot_y = getInput("Y", "правой нижней");
        double check_x = getInput("X", "проверяемой");
        double check_y = getInput("Y", "проверяемой");

        if(check_x > left_top_x && check_x < right_bot_x && check_y > right_bot_y && check_y < left_top_y)
            System.out.println("Точка с введёнными координатами принадлежит прямоугольнику");
        else  System.out.println("Точка с введёнными координатами не принадлежит прямоугольнику");
    }
}
