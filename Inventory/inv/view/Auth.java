package inv.view;
import java.util.*;

import inv.controller.Aval;
import inv.model.User;
public class Auth {
    static Scanner sc=new Scanner(System.in);
    public static void SignIn()
    {
        System.out.println("SignIn");
        System.out.print("Enter mail: ");
        String mail=sc.nextLine();
        System.out.print("Enter Password: ");
        String pass=sc.nextLine();
        String ret=Aval.Sin(mail, pass);
        if(ret!=null)
        {
            String g[]=ret.split(",");
            System.out.println();
            System.out.println("--Welcome "+g[0]+"--");
            System.out.println();
            if(g[1].equals("admin"))
            {
                Admin.Menu(g[2]);
            }
            Agent_m.AMenu(g[2]);
        }
        else
        {
            System.out.println("---Invalid Credentials!!---");
            SignIn();
        }
    }
}
