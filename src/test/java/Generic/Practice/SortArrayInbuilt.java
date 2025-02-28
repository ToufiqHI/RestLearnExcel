package Generic.Practice;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class SortArrayInbuilt
{
    public static void main(String[] args)
    {
        //sort an array
        //find the largest number
        //find the smallest number
        int [] num={3,43,44,4,3,45,62};
        Arrays.sort(num);
        int min=num[0];
        int max=num[0];
        for (int i=0;i<num.length;i++)
        {
            System.out.println(num[i]);
            if(num[i]<min)
            {
                min=num[i];
            }
            if (num[i]>max)
            {
                max=num[i];
            }
        }
        System.out.println(    );
        System.out.println(max);
        System.out.println(min);
    }

}
