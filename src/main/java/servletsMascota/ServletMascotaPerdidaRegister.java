
package servletsMascota;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllerMascota.MascotaUsuarioController;
import java.sql.Date;

/**
 * Servlet implementation class ServletUsuarioRegister
 */
@WebServlet("/ServletMascotaPerdidaRegister")
public class ServletMascotaPerdidaRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMascotaPerdidaRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

       MascotaUsuarioController  mascota = new MascotaUsuarioController();
        
        String username = request.getParameter("username");
        String nombre = request.getParameter("nombre");
        String raza = request.getParameter("raza");
        String especie = request.getParameter("especie");
        String tipo_busqueda = request.getParameter("tipo_busqueda");
        String edad = request.getParameter("edad");
        String sexo = request.getParameter("sexo");
        String color = request.getParameter("color");
        String descripcion = request.getParameter("descripcion");
        Date fecha = Date.valueOf(request.getParameter("fecha")) ;
        String foto = request.getParameter("foto");
        String correo = request.getParameter("correo");
       
        
        String result = mascota.registroMascotaPerdida( username, nombre, raza, especie,tipo_busqueda, edad, sexo, color, descripcion, fecha, "Perdido", foto, correo);        

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}

