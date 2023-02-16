package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Credit implements cloneable
{
    String name;
    Long cardno;
    String expdate;
    Logger l = Logger.getLogger("kawin");
    Credit(String name,Long cardno,String expdate)
    {
        this.name=name;
        this.cardno=cardno;
        this.expdate=expdate;
    }
    boolean equalss(Long validcardno)
    {
        return cardno.equals(validcardno);
    }
    Credit cloning()
    {
        try
        {
          return (Credit) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            l.info("cloned error");
            return this;
        }
    }
}

class Creditcard
{
    public static void main(String[]args)
    {
        Scanner inpobject = new Scanner(System.in);
        Logger l = Logger.getLogger("kawin");

        l.info("enter name");
        String name = inpobject.next();
        l.info("enter card no");
        Long cardno = inpobject.nextLong();
        l.info("enter exp date ");
        String expdate = inpobject.next();

        Long validcardno=1234567890L;

        Credit obj1 = new Credit(name,cardno,expdate);
        Credit obj2 = obj1.cloning();

        if(obj2.equalss(validcardno))
        {
            l.info("both are same");
        }
        else
        {
            l.info("both are not same");
        }
        inpobject.close();


    }
}
