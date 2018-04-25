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
            AccesoDatos Members = new AccesoDatos();
            int idactor = 0;
            String name = "";
            String firstlastname="";
            String secondlastname="";
            String email="";
            String phone="";
            int idaddress = 0;
            String birthday="2012-12-12";
            String boton="";
            int idgender = 0;
            int idcivilstatus = 0;
            int membertype = 0;
            boolean baptized=false;
            int idstatus=1;
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Miembros</title>");
            //out.println(" <link href=main.css rel=stylesheet type=text/css>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"stylesheet\" href=\"reset.css\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Lato:400,900\" rel=\"stylesheet\">");
            out.println("<link rel=\"stylesheet\" href=\"tablas.css\">"); 	
            out.println("</head>");
            out.println("<body>");
          
          
            boton=request.getParameter("Boton");
            if (boton.equals("Agregar")){
                
            if(request.getParameter("NOMBRE")!=""){
                name=request.getParameter("NOMBRE");
           }
            
            if(request.getParameter("APELLIDOPATERNO")!=""){
                firstlastname=request.getParameter("APELLIDOPATERNO");
            }
            
            if(request.getParameter("APELLIDOMATERNO")!=""){
                secondlastname=request.getParameter("APELLIDOMATERNO");
            }
             
            if(request.getParameter("CUMPLEANIOS")!=""){
                birthday=request.getParameter("CUMPLEANIOS");
            }
            
            if(request.getParameter("EMAIL")!=""){
                email=request.getParameter("EMAIL");
            }
            
            if(request.getParameter("TELEFONO")!=""){
                phone=request.getParameter("TELEFONO");
            }
            
            if(request.getParameter("DIRECCION")!=""){
                idaddress=Integer.parseInt(request.getParameter("DIRECCION"));
            }
            
            if(request.getParameter("GENERO")!=""){
                idgender=Integer.parseInt(request.getParameter("GENERO"));
            }
            
            if(request.getParameter("ESTADOCIVIL")!=""){
                idcivilstatus=Integer.parseInt(request.getParameter("ESTADOCIVIL"));
            }
            
            if(request.getParameter("TIPOMIEMBRO")!=""){
                membertype=Integer.parseInt(request.getParameter("TIPOMIEMBRO"));
            }
            
            if(request.getParameter("BAUTIZADO")!=""){
                baptized=Boolean.parseBoolean(request.getParameter("BAUTIZADO"));
                
            }
            //out.println("<tr><td>" + name + "</td><td>"+ firstlastname + "</td><td>"+ secondlastname + "</td><td>"+ email + "</td><td>"+ phone + "</td><td>"+idaddress+ "</td><td>"+ birthday + "</td><td>"+idgender + "</td><td>"+ idcivilstatus + "</td><td>"+ membertype + "</td><td>"+ baptized + "</td></tr>");         
              
                Members.Insertar(name,firstlastname,secondlastname,email,phone,idaddress,birthday,idgender,idcivilstatus,membertype,baptized,1);
                out.println("Agregado");
                out.println("<br/><a href=\"index.jsp\">Regresar</a>");
                return;
            }
             
            if(boton.equals("Actualizar")){
                Members.Actualizar(idactor,name,firstlastname,birthday);
                return;
            }
              
            if(boton.equals("Eliminar")){
                Members.Eliminar(idactor);
                return;
            }
    
            if(boton.equals("Buscar"))
            {
                 out.println("<table align=center width=289 border=1 class=datos_form>");
                 out.println("<tr class=titulo_tabla><td colspan=2>LISTADO DE ACTORES </td></tr> ");
                 out.println("<tr><td>ID</td><td>Nombre</td><td>Apellido</td></tr>");
            
                if(request.getParameter("NOMBRE")!=""){
                name=request.getParameter("NOMBRE");
           }
            
                if(request.getParameter("APELLIDOPATERNO")!=""){
                firstlastname=request.getParameter("APELLIDOPATERNO");
               
                }
                
               try{
                  res = Members.BuscarExistente(name, firstlastname);
                 while (res.next()) {
                //idactor = res.getInt("actor_id");
                name = res.getString("name");
                firstlastname = res.getString("firstLastName");
                birthday = res.getString("birthday");
                out.println("<tr><td>" + name + "</td><td>"+ firstlastname + "</td><td>"+ birthday + "</td></tr>");
             
            }
                     out.println("</table>");
                     out.println("</body>");
                     out.println("</html>");
                     out.close();
                }catch (Exception ex){
                    out.println("ERROR: NO FUE LISTAR" + ex.getMessage());
                }
            }
            
            if(boton.equals("Listado"))
            {
                 out.println("<table align=center width=289 border=1 class=datos_form>");
                 out.println("<tr class=titulo_tabla><td colspan=2>LISTADO DE ACTORES </td></tr> ");
                 out.println("<tr><td>ID</td><td>Nombre</td><td>Apellido</td></tr>");
            
                try{
                res = Members.Listado();
                 while (res.next()) {
                //idactor = res.getInt("actor_id");
                name = res.getString("name");
                firstlastname = res.getString("firstLastName");
                birthday = res.getString("birthday");
                out.println("<tr><td>" + name + "</td><td>"+ firstlastname + "</td><td>"+ birthday + "</td></tr>");
              
            }
           out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            out.close();
                 return;
                }catch (Exception ex){
                    out.println("ERROR: NO FUE LISTAR" + ex.getMessage());
                }
     
           
            }
            
          
        } catch (Exception ex) {
            
            out.println("<title>error</title>");
            out.println("ERROR: " + ex.getMessage());
            Logger.getLogger(ServletDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
