package Generic.colllections;

import java.util.ArrayList;
import java.util.Collections;

public class ListArray
{
    public static void main(String[] args)
    {
        ArrayList arrayList=new ArrayList();
        arrayList.add(34);
        arrayList.add("376467jhdsfhjfgs");
        arrayList.add("Hubli");
        arrayList.add("Belgaum");
        int size = arrayList.size();
        for (int i=0;i<size; i++)
        {
            System.out.println(arrayList.get(i));
        }
        System.out.println(arrayList);
      ArrayList arr =new ArrayList();
      arr.add(4);
        arr.add(900);
        arr.add(191);
        arr.add(1);
        arr.add(6);
        arr.add(8);
        arr.add(0);
        arr.add(9);
       Collections.sort(arr);
        System.out.println(arr);


    }
}
