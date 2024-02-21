import java.util.Scanner;

public class Exercises1 {

    public static class InputNumbers {
        public static void inputAndPrintNumbers() {
            Scanner scanner = new Scanner(System.in);
            int[] numbers = new int[100];
            int count = 0;

            System.out.println("Enter numbers, one per line. Enter a blank line to stop.");

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (count < numbers.length) {
                    numbers[count] = number;
                    count++;
                } else {
                    System.out.println("Array is full. Cannot add more numbers.");
                    break;
                }
            }

            System.out.println("You entered the following numbers:");
            for (int i = 0; i < count; i++) {
                System.out.print("  " + numbers[i]);
            }

            scanner.close();
        }
    }

    public static void main(String[] args) {
        InputNumbers.inputAndPrintNumbers();
    }
}