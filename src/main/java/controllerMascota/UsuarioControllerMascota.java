package controllerMascota;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beansMascota.Usuario;
import connectionMascota.DBConnection;


public class UsuarioControllerMascota implements IUsuarioControllerMascota {

    @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuario where id_correo_usuario = '" + username + "'";

        try
        {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                String nombre_usuario = rs.getString("nombre_usuario");
                String apellido_usuario = rs.getString("apellido_usuario");
                String celular_usuario = rs.getString("celular_usuario");
                String contrasena_usuario = rs.getString("contrasena_usuario");
                    
                Usuario usuario = new Usuario(username, nombre_usuario, apellido_usuario, celular_usuario, contrasena_usuario);                
                return gson.toJson(usuario);
            }
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        } finally
        {
            con.desconectar();
        }

        return "false";
    }
    
     @Override
    public String register(String correo, String nombre, String apellido, String celular,  String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuario values('" + correo + "', '" + nombre + "', '" + apellido
                + "', '" + celular + "', '" + contrasena  + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(correo, nombre, apellido, celular, contrasena);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
   
}
