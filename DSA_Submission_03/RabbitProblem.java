// Classic rabbit problem (Fibonacci sequence).
// Start with 1 pair. Each mature pair produces 1 new pair every month.
// Rabbits do not die. This version counts rabbit PAIRS.
import java.util.Scanner;

public class RabbitProblem {
    public static int countPairs(int months) {
        if (months <= 0) {
            return 0;
        }

        if (months == 1 || months == 2) {
            return 1;
        }

        int previousMonth = 1;
        int currentMonth = 1;

        for (int month = 3; month <= months; month++) {
            int nextMonth = previousMonth + currentMonth;
            previousMonth = currentMonth;
            currentMonth = nextMonth;
        }

        return currentMonth;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of months: ");
        int months = input.nextInt();

        if (months < 0) {
            System.out.println("Please enter zero or a positive number.");
        } else {
            System.out.println("Rabbit pairs after " + months
                    + " months: " + countPairs(months));
        }

        input.close();
    }
}
