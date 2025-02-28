package Generic.Practice;

import io.cucumber.java.hu.Ha;

import java.awt.*;
import java.util.HashSet;
import java.util.Scanner;

public class findDuplicate
{
    public static void main(String[] args)
    {
       Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String : ");
        String str=scanner.nextLine();
        scanner.close();
        HashSet<Character> duplicate=new HashSet<>();
        for (int i=0; i<str.length();i++)
        {
            char ch=str.charAt(i);
            if (str.indexOf(ch)!=i)
            {
                duplicate.add(ch);
            }
        }
        System.out.println(duplicate);
    }
}
