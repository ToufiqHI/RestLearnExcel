package Generic.Programs;

import java.util.Arrays;

public class InBuiltSort
{
    public static void main(String[] args) {
        int [] arr={2,45,45,878,7878,56,67,6,878,89,89,9,80,};
        Arrays.sort(arr);
        for (int i=0; i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
