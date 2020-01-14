package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        DB db = new DB();
        db.printAllCities();
        db.addCity("Bishkek",1);
        Connection connection=db.connect();

        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        if(connection!=null) connection.close();
    }
}

