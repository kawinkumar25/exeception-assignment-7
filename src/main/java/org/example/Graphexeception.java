package org.example;

import java.util.Scanner;
import java.util.logging.Logger;

class Graph1 implements cloneable
{
    Integer x;
    Integer y;
    Logger l = Logger.getLogger("kawin");
    Graph1(Integer a,Integer b)
    {
        x=a;
        y=b;
    }
    boolean equals()
    {
        return x.equals(y);
    }

    Graph1 gp()
    {
        try
        {
            return (Graph1) super.clone();
        }
        catch (CloneNotSupportedException e)
        {
            l.info("cloned error");
            return this;
        }
    }
}

public class Graphexeception
{
    public static void main(String[] args)
    {
        Logger l = Logger.getLogger("kawin");
        Scanner inp = new Scanner(System.in);
        l.info("enter x");
        Integer x = inp.nextInt();
        l.info("enter y");
        Integer y = inp.nextInt();

        Graph1 ob1 = new Graph1(x, y);
        Graph1 ob2 = ob1.gp();
        if(ob2.equals())
        {
            l.info("x and y are same");
        }
        else
        {
            l.info("x and y are not same");
        }
    }
}
