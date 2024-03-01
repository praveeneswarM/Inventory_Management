package inv.view;
import java.util.*;

import inv.controller.*;
import inv.model.*;
public class Admin {
    static Scanner sc=new Scanner(System.in);
    public static void Menu(String id)
    {
        int n;
        do{
            System.out.println("----------------------");
            System.out.println("     --Admin Menu--");
            System.out.println("----------------------");
            System.out.println("1.Add Admin");
            System.out.println("2.Add Agent");
            System.out.println("3.Add Stocks");
            System.out.println("4.Remove Stocks");
            System.out.println("5.Remove Agent");
            System.out.println("6.View Stocks");
            System.out.println("7.View Order");
            System.out.println("8.View Request");
            System.out.println("9.Accept Request");
            System.out.println("10.Exit");
            System.out.println();
            System.out.print("Enter choice:");
            n=sc.nextInt();

        switch (n) {
            case 1:
                {
                    AddAdmin();
                    break;
                }
            case 2:
            {
                AddAgent();
                break;
            }
            case 3:
            {
                AddStock();
                break;
            }
            case 4:
            {
                RemoveStock();
                break;
            }
            case 5:
            {
                RemoveAgent();
                break;
            }
            case 6:
            {
                ViewStocks();
                break;
            }
            case 7:
            {
                ViewOrders();
                break;
            }
            case 8:
            {
                Admin.ViewReq();
                break;
            }
            case 9:
            {
                Acc();
                break;
            }
            case 10:
            {
                System.out.println("--Exited Succesfully--");
                Main.main(null);
            }
            default:
            {
                System.out.println("Enter Valid Option:");
                Menu(id);
            }
        }

        }while(n!=10);
    }

    public static void AddAdmin()
    {
        sc.nextLine();
        System.out.print("Enter Name:");
        String na=sc.nextLine();
        System.out.print("Enter Mail:");
        String ma=sc.nextLine();
        System.out.print("Enter Pass");
        String pa=sc.nextLine();
        String role="admin";
        String ret=Aval.Sup(na, ma, pa, role);
        System.out.println();
        System.out.println(ret);
        System.out.println();
    }
    public static void AddAgent()
    {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String na=sc.nextLine();
        System.out.print("Enter Mail: ");
        String ma=sc.nextLine();
        System.out.print("Enter Pass: ");
        String pa=sc.nextLine();
        System.out.print("Enter Phone: ");
        String ph=sc.nextLine();
        String role="agent";
    
        String ret=Aval.Aup(na, ma, pa, ph, role);
        System.out.println();
        System.out.println(ret);
        System.out.println();
    }

    public static void AddStock()
    {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String na=sc.nextLine();
        System.out.println("Catogory:");
        System.out.println("Tablet");
        System.out.println("Ointment");
        System.out.println("Syrup");
        System.out.print("Enter Catogory: ");
        String ca=sc.nextLine();
        System.out.print("Enter Quantity: ");
        String qt=sc.nextLine();
        System.out.print("Enter Price: ");
        String ppu=sc.nextLine();

        String ret=Sto.Stoo(na,ca,qt,ppu);
        if(ret!=null)
        {
            System.out.println();
            System.out.println(ret);
            System.out.println();
        }
        else{
            System.out.println("--Enter Valid Details--");
            AddStock();
        }
    }


    public static void RemoveStock()
    {
        sc.nextLine();
        ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
        resultList=Stock.SView();
        System.out.println("Stocks:");
        System.out.println();
        System.out.println("ID   CAT  NAME    QTY     PRICE");
        for (ArrayList<Object> rowData : resultList) {
            for (Object data : rowData) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("Enter Stock ID:");
        String na=sc.nextLine();
        String ret=Stock.Remove(na);
        if(ret!=null)
        {
            System.out.println();
            System.out.println(ret);
            System.out.println();
        }
        else
        {
            System.out.println();
            System.out.println("--Enter Valid Stock--");
            System.out.println();
            RemoveStock();
        }

    }


    public static void RemoveAgent()
    {
        sc.nextLine();
        ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
        resultList=Agent.AView();
        System.out.println("Agents:");
        System.out.println();
        for (ArrayList<Object> rowData : resultList) {
            for (Object data : rowData) {
                System.out.print(data+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("Enter Agent ID: ");
        String id=sc.nextLine();
        String ret=Agent.Remove(id);
        if(ret==null)
        {
            System.out.println();
            // System.out.println();
            System.out.println("--Try Again--");
            RemoveAgent();
        }
        else
        {
            System.out.println();
            System.out.println(ret);
            System.out.println();
        }
    }

    public static void ViewStocks()
    {
        ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
        resultList=Stock.SView();
        System.out.println("Stocks:");
        System.out.println();
        System.out.println("ID   CAT  NAME    QTY     PRICE");
        for (ArrayList<Object> rowData : resultList) {
            for (Object data : rowData) {
                System.out.print(data+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void ViewOrders()
    {
        System.out.println("Orders:");
        System.out.println("ID   A_ID    CAT    NAME    QTY     AMT     DATE");
        ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
        resultList=His.OView();
        System.out.println();
        for (ArrayList<Object> rowData : resultList) {
            for (Object data : rowData) {
                System.out.print(data+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void ViewReq()
    {
        sc.nextLine();
        ArrayList<ArrayList<Object>> resultList = new ArrayList<>();
        resultList=feed.ReqView();
        System.out.println("Stocks:");
        System.out.println();
        System.out.println("ID   NAME  MAIL    PHONE     REQ    DATE");
        for (ArrayList<Object> rowData : resultList) {
            for (Object data : rowData) {
                System.out.print(data+"  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void Acc()
    {
        sc.nextLine();
        ViewReq();
        System.out.println();
        System.out.print("Enter ID:");
        String id=sc.nextLine();
        String ret=feed.AccReq(id);
        if(ret!=null)
        {
            System.out.println();
            System.out.println(ret);
        }
        else
        {
            System.out.println();
            System.out.println("--Try Again--");
            Acc();
        }
    }
}