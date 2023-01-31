package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.logging.Logger;

public class Sqlexeception {
    public static void main(String[] args) {
        String username;
        String password;
        String database;

        Logger l = Logger.getLogger("kawin");

        Scanner inp = new Scanner(System.in);
        l.info("Enter database name:");
        database = inp.next();
        l.info("Enter username:");
        username = inp.next();
        l.info("Enter password:");
        password = inp.next();

        Dbconn ob1 = Dbconn.in(database, username, password);

        boolean loop = true;
        while (loop) {
            l.info("1.connection estabilished\n2.connection close\n3.exit");
            int ch = inp.nextInt();
            if (ch == 1) {
                ob1.connection();
            } else if (ch == 2) {
                ob1.close();
            } else if (ch == 3) {
                loop = false;
                l.info("Exited");
            } else {
                l.info("choice incorrect");
            }
        }
    }
}

class Dbconn {
    String username;
    String password;
    String database;
    Connection conn;
    Logger l = Logger.getLogger("kawin");
    private Dbconn(String database, String username, String password) {
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public static Dbconn in(String database, String username, String password) {
        return new Dbconn(database, username, password);
    }

    void connection() {
        try {
            conn = DriverManager.getConnection(database, username, password);
            l.info("connection established");
        } catch (Exception e) {
            l.info(String.valueOf(e));
        }
    }

    void close() {
        try {
            conn.close();
            l.info("connection closed");
        } catch (Exception e) {
            l.info(String.valueOf(e));
        }
    }
}
