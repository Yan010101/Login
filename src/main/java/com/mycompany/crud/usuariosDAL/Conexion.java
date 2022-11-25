
package com.mycompany.crud.usuariosDAL;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author laptop
 */
public class Conexion {
      public static Connection conex;
    public static PreparedStatement ps;
    public static ResultSet rs;
    
    private static final String strConexionDB ="jdbc:mysql://localhost:3306/registro";
    
   private static final String DRIVER = "com.mysql.jdbc.Driver";
   private static final String USER = "root";
   private static final String PASSWORD = "londres1122";
    
    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conex = DriverManager.getConnection(strConexionDB, USER, PASSWORD);
            
           if (conex != null) {
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Se produjo un error al conectar " + e);
        }
    }
    
     public Connection getConnection() {
        return conex;
    }
    
    public int ejecutarsentenciaSQL(String strSentenciaSQL) {
        
        try {
            PreparedStatement pstm= conex.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistro (String strSentenciaSQL) {
        try {
            PreparedStatement pstm= conex.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
}
