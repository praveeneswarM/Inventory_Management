package inv.controller;
import java.util.*;

import inv.model.feed;
public class Reqval {
    public static String RFeed(String na,String ma,String ph,String fee)
    {
        String mail="^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
        String name="^[A-Za-z]{3,}";
        String phone="^[7-9][0-9]{9}$";
        if(!ma.matches(mail))
        {
            return null;
        }
        else if(!na.matches(name))
        return null;
        else if(!ph.matches(phone))
        return null;
        else
        return feed.req(na, ma, ph, fee);
    }
}
