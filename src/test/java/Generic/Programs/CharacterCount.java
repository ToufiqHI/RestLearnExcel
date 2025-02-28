package Generic.Programs;

import java.util.Scanner;

public class CharacterCount
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();
        int count = str.length(); // Get the total number of characters
        System.out.println("Number of characters: " + count);
    }
}
