package Generic.Practice;

import java.util.Scanner;

public class CharacterCount
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter string: ");
        String str=scanner.nextLine();
        scanner.close();
        System.out.println(str.length());

    }
}
