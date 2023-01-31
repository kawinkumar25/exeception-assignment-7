package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gradeexeception {

    String name;
    String gradeLevel;
    float gpa;
    float ugpa;
    Logger l = Logger.getLogger("kawin");
    Scanner i =new Scanner(System.in);
    Scanner s =new Scanner(System.in);
    Gradeexeception()
    {
        l.info("Enter name:");
        name=s.next();
        l.info("Enter grade  level:");
        gradeLevel=s.next();
        l.info("Enter gpa:");
        gpa=i.nextFloat();




    }
    void update()
    {
        try
        {
            l.info("enter yur updated gpa");
            ugpa=i.nextFloat();
        }
        catch (InputMismatchException ex) {
            l.info("Wrong datatype is entered");
            l.info(String.valueOf(ex));
        }


        gpa=ugpa;
    }
    void show()
    {
        l.log(Level.INFO, ()->name+" has GPA of "+gpa);
    }
    public static void main (String[] args)
    {
        Gradeexeception a = new Gradeexeception();
        Scanner inp =new Scanner(System.in);
        System.out.println("Do you want to update your gpa yes->1/no->2 ?");

        int choice=inp.nextInt();
        if(choice==1)
        {
            a.update();
            a.show();
        }
        else
        {
            a.show();
        }
    }
}