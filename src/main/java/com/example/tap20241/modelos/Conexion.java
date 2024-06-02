package com.example.tap20241.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static private String DB = "Taqueria";
    static private String USER = "adminTacos";
    static private String PWD = "1234";
    static public Connection connection;



    public static void crearConexion(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB+"?allowPublicKeyRetrieval=true&useSSL=false",USER,PWD);
            System.out.println("Conexion establecida con exito!!");
        }catch (Exception e){
            e.printStackTrace();

        }
    }

}
