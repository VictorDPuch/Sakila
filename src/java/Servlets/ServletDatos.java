/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Cesar
 */
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
            AccesoDatos calidad = new AccesoDatos();
            int idactor = 0;
            String actnombre = "";
            String actapellido="";
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Litado de Calidades</title>");
            out.println(" <link href=Estilo.css rel=stylesheet type=text/css>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table align=center width=289 border=1 class=datos_form>");
            out.println("<tr class=titulo_tabla><td colspan=2>LISTADO DE ACTORES </td></tr> ");
            out.println("<tr><td>ID</td><td>Nombre</td><td>Apellido</td></tr>");
            res = calidad.Listado();
            if ((request.getParameter("ID")=="")&&(request.getParameter("APELLIDO")!=""))
                res=calidad.BuscarPorNombre(request.getParameter("APELLIDO"));
            if ((request.getParameter("ID")!="")&&(request.getParameter("APELLIDO")==""))
                res=calidad.BuscarExistente(Integer.parseInt(request.getParameter("ID")));
            if ((request.getParameter("ID")=="")&&(request.getParameter("APELLIDO")==""))
                  res = calidad.Listado();

            while (res.next()) {
                idactor = res.getInt("actor_id");
                actnombre = res.getString("first_name");
                actapellido = res.getString("last_name");
                out.println("<tr><td>" + idactor + "</td><td>" + actnombre + "</td><td>"+ actapellido + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(ServletDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
