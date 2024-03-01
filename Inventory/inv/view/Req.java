package inv.view;

import java.util.*;

import inv.controller.Reqval;
import inv.model.feed;
public class Req {
    static Scanner sc=new Scanner(System.in);
    public static void RF()
    {
        System.out.print("Enter Name:");
        String na=sc.nextLine();
        System.out.print("Enter Mail:");
        String ma=sc.nextLine();
        System.out.print("Enter Phone:");
        String ph=sc.nextLine();
        System.out.print("Enter Feed:");
        String fee=sc.nextLine();
        String ret=Reqval.RFeed(na,ma,ph,fee);
        if(ret!=null)
        {
            System.out.println();
            System.out.println(ret);
            Main.main(null);
        }
        else
        {
            System.out.println();
            System.out.println("--Try Again--");
            RF();
        }
    }
}
