package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import AccesoDatos.AccesoDatos;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServletDatos extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        

    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         try {
            ResultSet res;
            AccesoDatos Actores = new AccesoDatos();
            int idactor = 0;
            String actnombre = "";
            String actapellido="";
            String fecha="";
            String boton="";
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actores</title>");
            out.println(" <link href=Estilo.css rel=stylesheet type=text/css>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table align=center width=289 border=1 class=datos_form>");
            out.println("<tr class=titulo_tabla><td colspan=2>LISTADO DE ACTORES </td></tr> ");
            out.println("<tr><td>ID</td><td>Nombre</td><td>Apellido</td></tr>");
            
            if(request.getParameter("ID")!="")
                idactor=Integer.parseInt(request.getParameter("ID"));
            if(request.getParameter("NOMBRE")!="")
                actnombre=request.getParameter("NOMBRE");
             if(request.getParameter("APELLIDO")!="")
                actapellido=request.getParameter("APELLIDO");
              if(request.getParameter("FECHA")!="")
                fecha=request.getParameter("FECHA");
            boton=request.getParameter("Boton");
            if (boton.equals("Agregar"))
                Actores.Insertar(idactor,actnombre,actapellido,fecha);
             
            if(boton.equals("Actualizar"))
                Actores.Actualizar(idactor,actapellido);
              
            if(boton.equals("Eliminar"))
                Actores.Eliminar(idactor);
    
            if(boton.equals("Listado"))
            {
                res = Actores.Listado();
            if ((request.getParameter("ID")=="")&&(request.getParameter("NOMBRE")!=""))
                        res=Actores.BuscarPorNombre(request.getParameter("NOMBRE"));
            if ((request.getParameter("ID")!="")&&(request.getParameter("NOMBRE")==""))
                        res=Actores.BuscarExistente(Integer.parseInt(request.getParameter("ID")));
            if ((request.getParameter("ID")=="")&&(request.getParameter("NOMBRE")==""))
                        res = Actores.Listado();

             res = Actores.Listado();
            while (res.next()) {
                idactor = res.getInt("actor_id");
                actnombre = res.getString("first_name");
                actapellido = res.getString("last_name");
                fecha = res.getString("last_update");
                out.println("<tr><td>" + idactor + "</td><td>" + actnombre + "</td><td>"+ actapellido + "</td><td>"+ fecha + "</td></tr>");
            }
            }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) {
            
            out.println("<title>error</title>");
            Logger.getLogger(ServletDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
