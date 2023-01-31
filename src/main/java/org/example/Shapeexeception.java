package org.example;



import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


class InvalidChoiceException  extends Exception
{
    public InvalidChoiceException(String str)
    {
        super(str);
    }
}
public class Shapeexeception {


    double height;
    double base;

    double length;
    double breadth;

    double radius;

    Scanner dep =new Scanner(System.in);
    Logger l = Logger.getLogger("kawin");
    Shapeexeception(int choice)
    {
        switch (choice) {
            case 1 -> {

                try
                {
                    l.info("Enter height:");
                    height = dep.nextDouble();
                    l.info("Enter base:");
                    base = dep.nextDouble();
                }
                catch (InputMismatchException ex) {
                    height = 0;
                    base = 0 ;
                    l.info(String.valueOf(ex));
                }



            }
            case 2 -> {


                l.info("Enter length:");
                length = dep.nextDouble();


                l.info("Enter breadth:");
                breadth = dep.nextDouble();
            }


            case 3 -> {

                l.info("Enter radius:");
                radius = dep.nextDouble();
            }

            default ->
                    l.info("Enter valid number");

        }

    }
    void perimeter(int choice)
    {
        double peri;
        if(choice==1)
        {
            l.info("enter side 1");
            double s1=dep.nextDouble();
            l.info("enter side 2");
            double s2=dep.nextDouble();
            peri=(s1+s2)+base;
            l.log(Level.INFO, ()->"perimeter of Triangle is "+peri);
        }
        else if (choice==2)
        {
            peri=(2*length)+(2*breadth);
            l.log(Level.INFO, ()->"perimeter of Rectangle is "+peri);
        }
        else if(choice==3)
        {
            peri=2*3.14*radius;
            l.log(Level.INFO, ()->"perimeter of Circle is "+peri);
        }
    }

    void area(int choice)
    {
        double area;
        if(choice==1)
        {
            area= (height * base) * 0.5;
            l.log(Level.INFO, ()->"Area of Triangle is "+area);
        }
        else if (choice==2)
        {
            area=length*breadth;
            l.log(Level.INFO, ()->"Area of Rectangle is "+area);
        }
        else if(choice==3)
        {
            area=3.14*radius*radius;
            l.log(Level.INFO, ()->"Area of Circle is "+area);
        }

    }
    public static void main (String[] args) {

        Scanner inp =new Scanner(System.in);
        Logger l = Logger.getLogger("kawin");
        l.info(" 1 Triangle \n 2 Rectangle \n 3 circle ");
        int choice =inp.nextInt();
        try
        {
            if(choice >= 4)
            {
                throw new InvalidChoiceException("you have entered invalid choice");
            }
            else {
                System.out.println("correctly entered");
            }
        }
        catch (InvalidChoiceException ex)
        {
            System.out.println("Caught the exception");
            System.out.println("Exception occured: " + ex);
        }

        Shapeexeception b = new Shapeexeception(choice);

        b.perimeter(choice);
        b.area(choice);
    }

}