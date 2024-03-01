package inv.controller;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import inv.model.Stock;
public class Sto {
    public static String Stoo(String na,String ca,String qt,String ppu)
    {
        int cc=0;
        String name="^[A-Za-z0-9]{3,}";
        Pattern nam=Pattern.compile(name);
        Matcher namm=nam.matcher(na);

        String cat=ca.toLowerCase();
        if(cat.equals("tablet") || cat.equals("ointment") || cat.equals("syrup"))
        cc++;

        String qty="^[0-9]{1,}";
        Pattern qq=Pattern.compile(qty);
        Matcher qtt=qq.matcher(qt);


        String pp="^[0-9]{1,}";
        Pattern ppt=Pattern.compile(pp);
        Matcher ppp=ppt.matcher(ppu);

        if((!na.matches(name) ||na==null) || (cc==0 || ca==null) || (!qt.matches(qty) || qt==null) || (!ppu.matches(pp) || ppu==null))
        return null;
        else
        return Stock.ASto(na, cat, qt, ppu);
    }
}
