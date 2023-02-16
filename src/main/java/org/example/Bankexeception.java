package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

public class Bankexeception {

    public static void main(String [] args)
    {
        Scanner inputobject = new Scanner(System.in );
        Logger l = Logger.getLogger("kawin");
        l.info("Enter name:");
        String name=inputobject.nextLine();
        long accno=0;
        try
        {
            l.info("Enter Account number:");
            accno=inputobject.nextLong();
        }
        catch (InputMismatchException ex) {
            l.info(String.valueOf(ex));
        }
        Bankinfo inputobj = new Bankinfo(name,accno);

        boolean inc = true;

        while(inc)
        {
            l.info(" 1 Deposit \n 2 Withdrawl \n 3 Balance \n 4 Exit");
            int choice = inputobject.nextInt();
            switch (choice) {
                case 1 -> inputobj.deposit();
                case 2 -> inputobj.withdrawl();
                case 3 -> inputobj.display();
                case 4 -> inc = false;
                default -> l.info("invalid choice");
            }

        }
    }
}
class Bankinfo
{
    String name;
    long accno;
    double balance;
    Scanner bankinputobject =new Scanner(System.in);
    Logger l = Logger.getLogger("kawin");
    Bankinfo(String name,long accno)
    {
        this.name=name;
        this.accno=accno;
        balance=0;
    }

    void deposit()
    {
        l.info("Enter Deposit amount:");
        int deposit = bankinputobject.nextInt();
        this.balance = balance+deposit;
        curBal();
    }

    void withdrawl()
    {
        l.info("Enter withdrawl amount:");
        int withdrawl = bankinputobject.nextInt();
        if(withdrawl<=balance)
        {
            this.balance = balance-withdrawl;
        }
        else
        {
            l.log(Level.INFO,()-> "Access denied, current balance is "+ balance + "\nEnter less than balance amount..");
            if(balance>0)
            {
                withdrawl();
            }

        }
        curBal();
    }
    void curBal()
    {

        l.log(Level.INFO, ()->"Current Balance :"+balance);
    }
    void display()
    {
        l.log(Level.INFO  , ()->"Name:"+name+"\nAccount number "+accno+ "\nBalance "+balance);
    }
}
