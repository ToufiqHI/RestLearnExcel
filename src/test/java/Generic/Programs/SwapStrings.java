package Generic.Programs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwapStrings
{

    @Test(description = "test description")
    public void swap()
    {
        String s1 = "Toufiq";
        String s2 = "Inamadar";
        String temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println(s1);
        System.out.println(s2);
    }
}
