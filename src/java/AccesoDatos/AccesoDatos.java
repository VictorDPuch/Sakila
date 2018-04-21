/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import AccesoDatos.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDatos extends Conexion{
    private int calcodigo;
    private String calnombre;
    private ResultSet resultado;

    public AccesoDatos()
    {
        Conectar();
    }

    public ResultSet Listado()throws Exception
    {
            try{
             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM actor");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }

   
    public ResultSet BuscarExistente(int Codigo) throws Exception
    {   try{
             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM actor WHERE actor_id LIKE'" + Codigo+"%'");
               return resultado;
             } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
        }
    }

    public ResultSet BuscarPorNombre(String Nombre) throws Exception
    {
        try{

             getStmt();
	     resultado= stmt.executeQuery("SELECT * FROM actor WHERE (first_name LIKE '" + Nombre + "%')");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }

}
