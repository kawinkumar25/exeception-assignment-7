package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bankexeception {

    String name;
    long accNo;
    double balance=0;
    Scanner dep =new Scanner(System.in);
    Scanner i = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    Logger l = Logger.getLogger("kawin");
    Bankexeception()
    {
        l.info("Enter name:");
        name=i.nextLine();
        try
        {
            l.info("Enter Account number:");
            accNo=s.nextLong();
        }
        catch (InputMismatchException ex) {
            l.info("Wrong datatype is entered");
            l.info(String.valueOf(ex));
        }

    }

    void deposit()
    {
        l.info("Enter Deposit amount:");
        int deposit = dep.nextInt();
        balance = balance+deposit;
        curBal();
    }

    void withdrawl()
    {
        l.info("Enter withdrawl amount:");
        int withdrawl = dep.nextInt();
        if(withdrawl<=balance)
        {
            balance = balance-withdrawl;
        }
        else
        {
            l.log(Level.INFO, ()->"Access denied, current balance is "+ balance + "\nEnter less than balance amount..");
            withdrawl();
        }
        curBal();
    }
    void curBal()
    {
        l.log(Level.INFO, ()->"Current Balance :"+balance);
    }
    void display()
    {
        l.log(Level.INFO, ()->"Name:"+name+"\nAccount number "+accNo+ "\nBalance "+balance);
    }
    public static void main(String [] args)
    {
        Bankexeception kawin = new Bankexeception();

        Scanner a = new Scanner(System.in);
        boolean inc = true;
        while(inc)
        {
            Logger l = Logger.getLogger("kawin");
            l.info(" 1 Deposit \n 2 Withdrawl \n 3 Balance \n 4 Exit");
            int choice = a.nextInt();
            switch (choice) {
                case 1 -> kawin.deposit();
                case 2 -> kawin.withdrawl();
                case 3 -> kawin.display();
                case 4 -> inc = false;
                default -> l.info("invalid choice");
            }

        }
    }
}
