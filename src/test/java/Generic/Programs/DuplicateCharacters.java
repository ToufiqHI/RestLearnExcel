package Generic.Programs;

import java.util.HashSet;
import java.util.Scanner;

public class DuplicateCharacters
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

//        System.out.println("Duplicate characters:");
//        for (int i = 0; i < str.length(); i++)
//        {
//            char ch = str.charAt(i);
//            if (str.indexOf(ch) != i && str.lastIndexOf(ch) != i)
//            {
//                System.out.println(ch);
//            }
//
        HashSet<Character> duplicates = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.indexOf(ch) != i) {
                duplicates.add(ch);
            }
        }

        System.out.println(duplicates);
    }
}
