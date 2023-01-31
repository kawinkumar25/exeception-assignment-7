package org.example;

import java.util.Scanner;
import java.util.logging.Logger;




class Credit implements Cloneable
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
    Credit cd()
    {
        try
        {
            return (Credit) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            l.info("cloned");
            return this;
        }
    }
}

public class Creditcardexeception
{
    public static void main(String[]args)
    {

        Scanner i = new Scanner(System.in);
        Logger l = Logger.getLogger("kawin");

        l.info("enter name");
        String name = i.next();
        l.info("enter card no");
        Long cardno = i.nextLong();
        l.info("enter exp date ");
        String expdate = i.next();

        Long validcardno=1234567890L;

        Credit ob1 = new Credit(name,cardno,expdate);
        Credit ob2 = ob1.cd();

        if(ob2.equalss(validcardno))
        {
            l.info("both card are same");
        }
        else
        {
            l.info("both card are not same");
        }
        i.close();


    }
}