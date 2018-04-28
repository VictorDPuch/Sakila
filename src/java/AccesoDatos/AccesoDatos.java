/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AccesoDatos;

import AccesoDatos.Conexion;
import static java.lang.System.out;
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
	     resultado= stmt.executeQuery("SELECT * from Member");
             return resultado;
              } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           return null;
           }
    }

   
    public ResultSet BuscarExistente(String name, String firstlastname) throws Exception
    {   try{
             getStmt();
	      resultado= stmt.executeQuery
        ("SELECT * FROM Member WHERE (name LIKE '" + name + "%' AND firstLastName LIKE '" +firstlastname+ "%' )");
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
     public void Insertar(String name, String firstlastname,String secondlastname
             ,String email,String phone,int  address,String birthday,
             int gender,int civilstatus,int membertype, boolean baptized,int status) throws Exception
    {
  
           try{
             getStmt();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO Member VALUES(0,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

              //pstmt.setInt(1, codigo);
              pstmt.setString(1, name);
              pstmt.setString(2, firstlastname);
              pstmt.setString(3, secondlastname);
              pstmt.setString(4, email);
              pstmt.setString(5, phone);
              pstmt.setInt(6, address);
              pstmt.setString(7, birthday);
              pstmt.setInt(8, gender);
              pstmt.setInt(9, civilstatus);
              pstmt.setInt(10, membertype);
              pstmt.setBoolean(11, baptized);
              pstmt.setInt(12, status);
              
              

              pstmt.executeUpdate();
               con.setAutoCommit(true);

        }catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
           System.exit(0);
        }
    }
   public void Actualizar(int codigo, String Nombre,String Apellido,String Fecha) throws Exception
    {
           try{
             getStmt();
             PreparedStatement pstmt = con.prepareStatement("UPDATE actor SET first_name= ?, last_name= ?, last_update= ? WHERE actor_id= ? ");
             
              pstmt.setString(1, Nombre);
              pstmt.setString(2, Apellido);
              pstmt.setString(3, Fecha);
              pstmt.setInt(4, codigo);

              pstmt.executeUpdate();
              
        }catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
        }
    }
    public void Eliminar(int codigo)throws Exception
    {
         try{
             getStmt();
	     stmt.executeUpdate("DELETE FROM actor WHERE actor_id=" + codigo);
        } catch (Exception ex){
           System.err.println("SQLException: " + ex.getMessage());
        }
    }
     public ResultSet mostrar(){
       Conexion con = new  Conexion();
       String com = "Select idMember, name from Member";
       ResultSet rs = con.getDatos(com);
       return rs;
   }

}
