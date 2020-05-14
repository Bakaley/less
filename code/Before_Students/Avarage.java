package Before_Students;

import java.util.Scanner;

public class Avarage {

    public static void main(String[] args) {

        double summ = 0;
        int count = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Вводите числа для расчёта средного арифметического (-2,5 5 6 78) и \"q\" для вывода результата (5 2 q):");

       while(scanner.hasNext()){
            if ((scanner.hasNextDouble())) {
                summ += scanner.nextDouble();
                count++;
            } else {
                String inv = scanner.next();
                if(inv.equals("q")) break;
                else System.out.println("Внимание, нечисловое значение будут пропущено: " + inv);
            }

        }

        if(count==0) System.out.println("Не введено ни одно число");
        else System.out.println("Среднее арифметическое суммы " + count + " введеных чисел: " + summ/count);

    }
}
