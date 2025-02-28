package Generic.Programs;

import java.util.Scanner;

public class SwapNumbers
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        scanner.close();

        // Swapping using a temporary variable
        int temp = a;
        a = b;
        b = temp;
        System.out.println("First number: " + a);
        System.out.println("Second number: " + b);
    }
}
