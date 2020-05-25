package Less_1_6.Less_1_3;

import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {

        double first;
        double second;
        String operation;
        String [] operations = {"+", "-", "*", "/"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число");



        while(!(scanner.hasNextDouble())){
            System.out.println("Пожалуйста, введите  число");
            scanner.next();
        }

        first = scanner.nextDouble();


        for (; ;) {
            System.out.println("Введите операцию (+ - * /)");
            operation = scanner.next();
            boolean valid = false;

            for (String operator: operations
                 ) {
                if (operator.equals(operation)) valid = true;
            }
            if(valid) break;
        }



        System.out.println("Введите второе число");

        while(!(scanner.hasNextDouble())){
            System.out.println("Пожалуйста, введите  число");
            scanner.next();
        }

        second = scanner.nextDouble();

        switch (operation){
            case ("+"):
                System.out.println("Сумма: " + (first+second));
                break;
            case ("-"):
                System.out.println("Разность: " + (first-second));
                break;
            case ("*"):
                System.out.println("Произведение: " + (first*second));
                break;
            case ("/"):
                System.out.println("Частное: " + (first/second));
                break;

        }

    }
}