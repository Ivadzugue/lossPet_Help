/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllerMascota;

import java.sql.Date;


public interface IMascotaUsuarioController {

    public String login(String username, String contrasena);

    public String registroMascotaPerdida(String username, String nombre, String raza, String especie, String tipo_busqueda, String edad, String sexo, String color, String descripcion, Date fecha, String estado_busqueda, String foto, String correo);

}
