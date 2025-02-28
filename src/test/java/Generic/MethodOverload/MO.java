package Generic.MethodOverload;

public class MO
{
    public static void send(int a)
    {
        System.out.println(a);
    }
    public static void send( String name)
    {
        System.out.println(name);
    }
    public static void send(int b, String B)
    {
        System.out.println( b +"   "+  B);
    }
    public static void send(int a,int b)
    {
        System.out.println(a+ b);
    }

    public static void main(String[] args)
    {
        send(142);
        send("Touf");
        send(1515,"Toiwefbhwrehf");
        send(671376,141234);

    }
}
