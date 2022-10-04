package testMascota;

import beansMascota.Mascota;
import java.sql.Date;
import connectionMascota.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        listarMascota();
        actualizarMascotas("lila32", "paco");
        listarMascota();
    }

    public static void actualizarMascotas(String  username_mascota, String nombre_mascota) {
        DBConnection con = new DBConnection();

        String sql = "UPDATE mascota SET nombre_mascota = '" + nombre_mascota + "' where username_mascota  = '" + username_mascota +"'" ;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarMascota() {

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM mascota;";
        

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                String username_mascota = rs.getString("username_mascota");
                String nombre_mascota = rs.getString("nombre_mascota");
                String raza_mascota = rs.getString("raza_mascota");
                String especie_mascota = rs.getString("especie_mascota");
                String tipo_busqueda_mascota = rs.getString("tipo_busqueda_mascota");
                String edad_aproximada_mascota = rs.getString("edad_aproximada_mascota");
                String sexo_mascota = rs.getString("sexo_mascota");
                String color_mascota = rs.getString("color_mascota");
                String descripcion_mascota = rs.getString("descripcion_mascota");
                Date fecha_mascota = rs.getDate("fecha_mascota");
                String estado_busqueda_mascota = rs.getString("estado_busqueda_mascota");
                String foto_mascota = rs.getString("foto_mascota");
                String id_correo_usuario_mascota = rs.getString("id_correo_usuario_mascota");
                

                Mascota mascotas = new Mascota(username_mascota, nombre_mascota, raza_mascota,especie_mascota, tipo_busqueda_mascota, edad_aproximada_mascota, sexo_mascota, color_mascota, descripcion_mascota, fecha_mascota, estado_busqueda_mascota, foto_mascota, id_correo_usuario_mascota);
                System.out.println(mascotas.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
    
    public static void listarUsuario() {

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM mascota;";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                String username_mascota = rs.getString("username_mascota");
                String nombre_mascota = rs.getString("nombre_mascota");
                String raza_mascota = rs.getString("raza_mascota");
                String especie_mascota = rs.getString("especie_mascota");
                String tipo_busqueda_mascota = rs.getString("tipo_busqueda_mascota");
                String edad_aproximada_mascota = rs.getString("edad_aproximada_mascota");
                String sexo_mascota = rs.getString("sexo_mascota");
                String color_mascota = rs.getString("color_mascota");
                String descripcion_mascota = rs.getString("descripcion_mascota");
                Date fecha_mascota = rs.getDate("fecha_mascota");
                String estado_busqueda_mascota = rs.getString("estado_busqueda_mascota");
                String foto_mascota = rs.getString("foto_mascota");
                String id_correo_usuario_mascota = rs.getString("id_correo_usuario_mascota");
                

                Mascota mascotas = new Mascota(username_mascota, nombre_mascota, raza_mascota, especie_mascota, tipo_busqueda_mascota, edad_aproximada_mascota, sexo_mascota, color_mascota, descripcion_mascota, fecha_mascota, estado_busqueda_mascota, foto_mascota, id_correo_usuario_mascota);
                System.out.println(mascotas.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
}