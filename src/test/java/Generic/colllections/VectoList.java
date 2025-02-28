package Generic.colllections;


import java.util.Vector;

public class VectoList
{
    public static void main(String[] args) {
        Vector vc=new Vector();
        vc.add(7643);
        vc.add(766726);
        System.out.println(vc);
        System.out.println(vc.capacity());
        vc.add(88);
        System.out.println(vc.capacity());
    }
}
