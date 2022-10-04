/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerMascota;

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beansMascota.Mascota;

import connectionMascota.DBConnection;

public class MascotaController implements IMascotaController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM mascota;";

        List<String> mascotas = new ArrayList<String>();

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
                java.sql.Date fecha_mascota = rs.getDate("fecha_mascota");
                String estado_busqueda_mascota = rs.getString("estado_busqueda_mascota");
                String foto_mascota = rs.getString("foto_mascota");
                String id_correo_usuario_mascota = rs.getString("id_correo_usuario_mascota");

                Mascota mascota = new Mascota(username_mascota, nombre_mascota, raza_mascota, especie_mascota, tipo_busqueda_mascota, edad_aproximada_mascota, sexo_mascota, color_mascota, descripcion_mascota, fecha_mascota, estado_busqueda_mascota, foto_mascota, id_correo_usuario_mascota);
                System.out.println(mascota.toString());
                mascotas.add(gson.toJson(mascota));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(mascotas);

    }
}
