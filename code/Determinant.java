import java.util.Scanner;

public class Determinant {
    public static void main(String[] args) {

        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");

        while(!(scanner.hasNextInt())){
            System.out.println("Пожалуйста, введите  целочисленное значение");
            scanner.next();
        }

        number = scanner.nextInt();

        System.out.print("Введеное число " + number + " является ");
        switch (number%2){
            case (0):
                System.out.print("чётным,");
                break;
            case(1):
                System.out.print("нечётным,");
                break;
        }

        boolean isSimple = true;

        for(int i=2; i < number; i++) {
            if((number%i) == 0) isSimple = false;
        }

        if (isSimple) System.out.println(" простым числом.");
        else
        {
            System.out.println(" составным числом. Кратные ему числа: ");
        }

        for(int i=2; i < number; i++) {
            if((number%i) == 0) System.out.print(i + " ");
        }

    }



}
