package inv.view;
import java.util.*;
public class Main {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Choice:");
        System.out.println("1.SignIn");
        System.out.println("2.Request/FeedBack");
        System.out.println("3.Exit");
        int x=sc.nextInt();
        switch (x) {
            case 1:
            {
                Auth.SignIn();
                break;
            }
            case 2:
            {
                Req.RF();
                break;
            }
            case 3:
            {
                System.out.println("--Exited Succesfully--");
                System.exit(0);
            }
            default:{
                System.out.println("---Enter Valid Choice---");
                Main.main(null);
            }
        }
    }
}
