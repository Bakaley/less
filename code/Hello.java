import java.util.Scanner;

public class Hello {


    public static void main(String[] args) {

        double first;
        double second;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число");

        while(!(scanner.hasNextDouble())){
            System.out.println("Пожалуйста, введите  число");
            scanner.next();
        }

        first = scanner.nextDouble();

        System.out.println("Введите второе число");

        while(!(scanner.hasNextDouble())){
            System.out.println("Пожалуйста, введите  число");
            scanner.next();
        }

        second = scanner.nextDouble();

        System.out.println("Сумма: " + (first+second));
        System.out.println("Разность: " + (first-second));
        System.out.println("Произведение: " + (first*second));
        System.out.println("Частное: " + (first/second));
    }
}