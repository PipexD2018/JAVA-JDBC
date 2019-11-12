package com.myproyect.introduccionjdbc;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class introduccionJDBC {

    public static void main(String[] args) {
    
        // Paso 1 se crea la cadena de conexión a MYSQL
        String url = "jdbc:mysql://localhost:3306/tabla2?&useSSL=false&useTimezone=true&serverTimezone=UTC";
        
        try {
            //Paso 2 se crea el objeto de conexión a base de datos

            Connection conectar = DriverManager.getConnection(url,"root","admin");
            
            // Paso 3 se crea un objeto de tipo Statement
            
            Statement instruccion = conectar.createStatement();
            
            // Paso 4 se crea el query a ejecutar.
            
            String sql = "select idPersona ,Nombre ,Apellido ,Correo ,Telefono from persona";
            
            // Paso 5 se ejecuta el query.
            
            ResultSet resultado = instruccion.executeQuery(sql);
            
            // Paso 6 se procesa el resultado.
            
            while(resultado.next()){
                System.out.print("Id Persona : "+resultado.getInt(1)+" | ");
                System.out.print("Nombre : "+resultado.getString(2)+" | ");
                System.out.print("Apellido : "+resultado.getString(3)+" | ");
                System.out.print("Correo : "+resultado.getString(4)+" | ");
                System.out.println("Telefono: "+resultado.getString(5)+" | ");
            }
            
            resultado.close();
            instruccion.close();
            conectar.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Se ha presentado un error al momento de realiza la conexión el error es : "+ ex);
        }
    }
    
}
