package Generic.Encaps;

public class Main
{
    public static void main(String[] args)
    {
       IDFC pin=new IDFC();
        System.out.println(pin.getATM_pin());
        pin.setATM_pin(43221);
        System.out.println(pin.getATM_pin());
    }

}
