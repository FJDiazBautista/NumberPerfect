
/**
 *
 * @author Francisco José Díaz Bautista
 */
public class PerfectNumber {

    private static long calculate(long number) {
        int limit;
        int quotient;
        int sumDivisors = 1; //initialized to 1 because it´s always divisor
        //It´s important to do the square root to optimize the operation
        limit = (int) Math.sqrt(number);
        for (int divisors = 2; divisors <= limit; divisors++) {
            //is a divisor if the remainder between the number and the divisor is 0
            if (number % divisors == 0) {
                sumDivisors = sumDivisors + divisors;
                //If the number is a divisor, we calculate the quotient to find another divisor
                //EXAMPLE: Dividers for the number 28 = 1 + 2 + 4 + 7 + 14
                //For 2, the remainder is 14, where both are divisors. 
                //As well for 2, the remainder is 7 which is also a divisor.
                quotient = (int) (number / divisors);
                if (quotient != divisors) 
                    sumDivisors = sumDivisors + quotient;
            }
        }
        return sumDivisors;
    }

    public static void main(String[] args) {
        //All perfect numbers up to 1000, for example.
        int number=1000;
        for (int i = 1; i <= number; i++) {
            if (i == calculate(i)) 
                System.out.println(i + " is perfect.");
        }
    }
}
