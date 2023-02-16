package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Graphclone implements Cloneable
{
    Integer x;
    Integer y;
    Logger l = Logger.getLogger("kawin");
    Graphclone(Integer x,Integer y)
    {
        this.x=x;
        this.y=y;
    }
    boolean equals()
    {
        return x.equals(y);
    }

    Graphclone gp()
    {
        try
        {
            return (Graphclone) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            l.info("cloned error");
            return this;
        }
    }
}

class Graphexeception
{
    public static void main(String[] args)
    {
        Logger l = Logger.getLogger("kawin");
        Scanner inpobject = new Scanner(System.in);
        l.info("enter x");
        Integer x = inpobject.nextInt();
        l.info("enter y");
        Integer y = inpobject.nextInt();

        Graphclone obj1 = new Graphclone(x, y);
        Graphclone obj2 = obj1.gp();
        if(obj2.equals())
        {
            l.info("x and y are same");
        }
        else
        {
            l.info("x and y are not same");
        }
    }
}
