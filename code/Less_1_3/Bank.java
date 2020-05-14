package Less_1_3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class Bank {

    public static void main(String[] args) {
        BigDecimal contribution;
        BigDecimal newContibution;
        BigDecimal percents;
        BigDecimal difference;
        BigDecimal sumDifference = new BigDecimal(0);
        int years;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер вклада: (42075,65)");

        while(!(scanner.hasNextBigDecimal())){
            System.out.println("Пожалуйста, введите  число");
            scanner.next();
        }
        contribution = scanner.nextBigDecimal();

        System.out.println("Введите процент годовых: (7,4)");

        while(!(scanner.hasNextBigDecimal())){
            System.out.println("Пожалуйста, введите  число");
            scanner.next();
        }
        percents = scanner.nextBigDecimal().divide(new BigDecimal(100));

        System.out.println("Введите количество лет: (4)");

        while(!(scanner.hasNextInt())){
            System.out.println("Пожалуйста, введите целочисленное значение");
            scanner.next();
        }
        years = scanner.nextInt();

        for(int i = 0; i < years; i++){
            newContibution = contribution.add(contribution.multiply(percents));
            difference = newContibution.subtract(contribution);
            newContibution = newContibution.setScale(2, RoundingMode.DOWN);
            difference = difference.setScale(2, RoundingMode.DOWN);
            sumDifference = sumDifference.add(difference);
            System.out.println("Год № " + (i+1) + ":" + " сумма " + newContibution + ", проценты за год " + difference + ", проценты в сумме: " + sumDifference);
            contribution = newContibution;
        }
    }

}
