package Generic.Programs;

public class Simple
{
    public static void main(String[] args)
    {
        String name ="Toufiq";
        System.out.println(name.length());
       for (int i=0;i<name.length(); i++)
       {
           System.out.println( name.charAt(i));
       }
       char [] c=name.toCharArray();
        System.out.print(c);
    }
}
