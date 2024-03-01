package inv.view;
import java.util.*;

import inv.model.*;
public class Agent_m {
    static Scanner sc=new Scanner(System.in);
    public static void AMenu(String id)
    {
        int x;
        do{
            System.out.println("----------------------");
            System.out.println("    --Menu--");
            System.out.println("----------------------");
            System.out.println("1.Buy Medicine");
            System.out.println("2.View Order History");
            System.out.println("3.Exit");
            System.out.println();
            System.out.println("Enter Choice:");
            x=sc.nextInt();
            switch (x) {
                case 1:
                {
                   BuyMed(id);
                   break;
                }
                case 2:
                {
                   OrderHis(id);
                   break;
                }
                case 3:
                {
                   System.out.println("--Exited Succesfully--");
                   Main.main(null);
                }
                default:
                {
                    System.out.println("--Enter Valid Choice--");
                    break;
                }
            }
        }while(x!=3);
    }
    
    public static void BuyMed(String id)
    {
        sc.nextLine();
        ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
        resultList=Stock.SView();
        System.out.println("----------------------");
        System.out.println("      Stocks");
        System.out.println("----------------------");
        System.out.println();
        System.out.println("ID   CAT  NAME    QTY     PRICE");
        for (ArrayList<Object> rowData : resultList) {
            for (Object data : rowData) {
                System.out.print(data+"  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("Enter Med ID:");
        String med=sc.nextLine();
        System.out.print("Enter Quantity:");
        String qty=sc.nextLine();
        String ret=Stock.Bill(med, qty);
        if(ret==null)
        {
            System.out.println("Try again");
                BuyMed(id);
        }
            else{
                System.out.println("----------------------");
            System.out.println("        Bill");
            System.out.println("----------------------");
            System.out.println("NAME    QUANTITY    PRICE");
            System.out.println(ret);
            System.out.println();
            System.out.println("Enter 'yes' to Purchase 'no to Decline");
            String y=sc.nextLine().toLowerCase();
            if(y.equals("yes"))
            {
                String res=Stock.Buy(id, med, qty);
                if(res!=null)
                {
                    System.out.println();
                    System.out.println(res);
                    System.out.println();
                }
                else
                {
                    System.out.println();
                    System.out.println("--Try Again--");
                    BuyMed(id);
                }
            }
        }
    }




    public static void OrderHis(String id)
    {
        sc.nextLine();
        System.out.println("----------------------");
        System.out.println("      Orders");
        System.out.println("----------------------");
        System.out.println("ID   A_ID    CAT    NAME    QTY     AMT     DATE");
        ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
        resultList=His.AHis(id);
        System.out.println();
        for (ArrayList<Object> rowData : resultList) {
            for (Object data : rowData) {
                System.out.print(data+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
