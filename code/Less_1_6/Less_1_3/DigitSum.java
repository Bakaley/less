package Less_1_6.Less_1_3;

import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input;
        int number;
        int sum = 0;

        System.out.println("Введите число");

        while(!(scanner.hasNextInt())){
            System.out.println("Пожалуйста, введите целочисленное значение");
            scanner.next();
        }

        input = scanner.nextInt();
        number = input;

        while (number >= 1){
            sum += number%10;
            number/=10;
        }

        System.out.println("Сумма цифр числа " + input + " равна " + sum);
    }
}
