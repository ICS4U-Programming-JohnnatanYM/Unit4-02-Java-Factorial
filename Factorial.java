import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program reads a number from a file,
 * calculates its factorial using recursion,
 * and writes the result to output.txt.
 *
 * @author Johnnatan Yasin Medina
 * @version 1.0
 * @since 2025-05-09
 */
final class Factorial {

    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException
     * @see IllegalStateException
     */
    private Factorial() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * Main method.
     *
     * @param args Unused.
     */
    public static void main(final String[] args) {
        // Check if input file name is provided
        if (args.length < 1) {
            System.out.println("Usage: java "
            + "FactorialCalculator <inputFileName>");
            return;
        }

        // Store the input file name and set the output file name
        String inputFileName = args[0];
        String outputFileName = "output.txt";

        // Try block to read from the input file
        try (Scanner scanner = new Scanner(new File(inputFileName))) {
            // Check if the file has content
            if (scanner.hasNextInt()) {
                // Read the number from the file
                int number = scanner.nextInt();
                // Ca;lculate the factorial
                long factorial = factorial(number);

                // Display the result in the terminal
                System.out.println("Factorial of "
                 + number + " is: " + factorial);

                // Try block to write the result to the output file
                try (FileWriter writer = new FileWriter(outputFileName)) {
                    writer.write("Factorial of "
                     + number + " is: " + factorial);
                }

                // Confirm the output has been saved
                System.out.println("Factorial saved to output.txt.");
            } else {
                // If the file is empty or contains no valid number
                System.out.println("File is empty or"
                + " contains no valid number.");
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the input file is not found
            System.out.println("Error: File \""
             + inputFileName + "\" not found.");
        } catch (IOException e) {
            // Handle any I/O exceptions (e.g., issues with writing to the file)
            System.out.println("Error writing to output.txt.");
        }
    }

    /**
     * Recursively calculates the factorial of a number.
     *
     * @param n The number to calculate the factorial of.
     * @return The factorial of the number.
     */
    private static long factorial(final int n) {
        // Base case: factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive case: n * factorial of (n-1)
        return n * factorial(n - 1);
    }
}
