import java.math.BigDecimal;

public class Fibonacci {

    static  BigDecimal number1 = new BigDecimal(0);
    static  BigDecimal number2 = new BigDecimal(1);
    public static void main(String[] args){
        System.out.println(fibonacci(10));
    }

    static BigDecimal fibonacci (int index){

        if (index == 0) return new BigDecimal(0);
        else if (index == 1) return new BigDecimal(1);
        else {

            BigDecimal result;

            for (int i = 2; i <=index; i++) {

                result = number2;
                result = result.add(number1);

                number1 =  number2;
                number2 = result;
            }
            return number2;
        }
    }
}
