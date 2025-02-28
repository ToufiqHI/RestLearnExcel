package Generic.MethodOverload;

public class MO_Nonstatic
{
    public  void send(int a)
    {
        System.out.println(a);
    }
    public  void send( String name)
    {
        System.out.println(name);
    }
    public  void send(int b, String B)
    {
        System.out.println( b +"   "+  B);
    }
    public  void send(int a,int b)
    {
        System.out.println(a+ b);
    }

    public static void main(String[] args)
    {
        MO_Nonstatic mo =new MO_Nonstatic();
         mo.  send(142);
       mo. send("Touf");
        mo.send(1515,"Toiwefbhwrehf");
       mo. send(671376,141234);

    }
}
