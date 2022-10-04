package controllerMascota;

public interface IUsuarioControllerMascota {

  
    public String pedir(String username);

    public String register(String correo, String nombre, String apellido, String celular, String contrasena);

}
