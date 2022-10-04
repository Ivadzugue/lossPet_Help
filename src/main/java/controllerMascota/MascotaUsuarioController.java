/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerMascota;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;
import java.sql.Date;

import beansMascota.Usuario;
import connectionMascota.DBConnection;
import java.util.HashMap;
import java.util.Map;
import beansMascota.Mascota;

public class MascotaUsuarioController implements IMascotaUsuarioController {
    
    @Override
    public String login(String correo, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuario where id_correo_usuario = '" + correo
                + "' and contrasena_usuario = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre_usuario");
                String apellidos = rs.getString("apellido_usuario");
                String celular = rs.getString("celular_usuario");

                Usuario usuario = new Usuario( correo, nombre, apellidos, celular, contrasena);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String registroMascotaPerdida(String username, String nombre, String raza, String especie, String tipo_busqueda, String edad, String sexo, String color, String descripcion, Date fecha, String estado_busqueda, String foto, String correo) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Insert into mascota values('" + username + "', '" + nombre + "', '" + raza + "', '" + especie + "', '" + tipo_busqueda + "', '" + edad
                + "', '" + sexo + "', '" + color + "', '" + descripcion + "', '" + fecha + "','" + estado_busqueda + "', '" + foto + "', '" + correo + "')";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Mascota mascota = new Mascota(username, nombre, raza, especie, tipo_busqueda, edad, sexo, color, descripcion, fecha, estado_busqueda, foto, correo);

            st.close();

            return gson.toJson(mascota);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";
    }

}
