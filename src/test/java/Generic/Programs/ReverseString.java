package Generic.Programs;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseString
{
      @Test
      public void Run()
    {
                String str = "RahulShettyAcademy";
                String reversed = new StringBuilder(str).reverse().toString();
                System.out.println("Reversed String: " + reversed);
    }

    @Test
    public void execute()
    {
        String str="Toufiq";
        String name=new StringBuilder(str).reverse().toString();
        System.out.println("Reversed Name: " + name);

    }
    @Test(description = "test description")
    public void testName()
    {
                String str = "RahulShettyAcademy";
                char[] charArray = str.toCharArray();
                String reversed = "";
                for (int i = charArray.length - 1; i >= 0; i--)
                {
                    reversed += charArray[i]; // Inefficient due to string immutability
                }

                System.out.println("Reversed String: " + reversed);

    }
}
