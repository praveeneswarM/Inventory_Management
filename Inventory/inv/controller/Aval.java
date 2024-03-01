package inv.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import inv.model.*;

public class Aval {
    public static String Sin(String ma,String pa)
    {
        String m = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";  
        Pattern pat = Pattern.compile(m); 
        if (ma == null) 
            return null; 
        if(pat.matcher(ma).matches())
        {
            return User.In(ma, pa);
        }
        return null;
    }

    public static String Sup(String na,String ma,String pa,String role)
    {
        String rx="^[A-Za-z]{3,}";
        Pattern p=Pattern.compile(rx);
        Matcher m=p.matcher(na);
        String mail = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";  
        Pattern pat=Pattern.compile(mail);
        Matcher mai=pat.matcher(ma);
        String pass="^[A-Za-z0-9]{6,}";
        Pattern pas=Pattern.compile(pass);
        Matcher mat=pas.matcher(pa);
        if(!na.matches(na) || na==null){
        return "--Enter Valid Name--";
        }
        else if(!ma.matches(mail) || ma==null)
        return "--Enter Valid Mail--";
        else if(!pa.matches(pass) || pa==null)
        return "--Password Shoud be Atleast 6 Characters--";
        else{
            String ret = User.Up(na, ma, pa,role);
            return ret;
        }
    }
    public static String Aup(String na,String ma,String pa,String ph,String role)
    {
        String rx="^[A-Za-z]{3,}";
        Pattern p=Pattern.compile(rx);
        Matcher m=p.matcher(na);
        String mail = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";  
        Pattern pat=Pattern.compile(mail);
        Matcher mai=pat.matcher(ma);
        String pass="^[A-Za-z0-9]{6,}";
        Pattern pas=Pattern.compile(pass);
        Matcher mat=pas.matcher(pa);


        String phone="^[7-9][0-9]{9}$";
        Pattern phh=Pattern.compile(phone);
        Matcher pho=phh.matcher(ph);

        if(!na.matches(na) || na==null){
        return "--Enter Valid Name--";
        }
        else if(!ma.matches(mail) || ma==null)
        return "--Enter Valid Mail--";
        else if(!pa.matches(pass) || pa==null)
        return "--Password Shoud be Atleast 6 Characters--";

        else if(!ph.matches(phone))
        return "--Enter valid Phone--";

        else{
            String ret = Agent.Aup(na, ma, pa, ph, role);
            return ret;
        }
    }

}
