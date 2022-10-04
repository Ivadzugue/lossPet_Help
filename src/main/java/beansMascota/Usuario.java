
package beansMascota;


public class Usuario {
    private String id_correo_usuario;
    private String nombre_usuario;
    private String apellido_usuario;
    private String celular_usuario;
    private String contrasena_usuario;

    public Usuario(String id_correo_usuario, String nombre_usuario, String apellido_usuario, String celular_usuario, String contrasena_usuario) {
        this.id_correo_usuario = id_correo_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.celular_usuario = celular_usuario;
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getId_correo_usuario() {
        return id_correo_usuario;
    }

    public void setId_correo_usuario(String id_correo_usuario) {
        this.id_correo_usuario = id_correo_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getCelular_usuario() {
        return celular_usuario;
    }

    public void setCelular_usuario(String celular_usuario) {
        this.celular_usuario = celular_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }

    @Override
    public String toString() {
        return "usuario{" + "id_correo_usuario=" + id_correo_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", celular_usuario=" + celular_usuario + ", contrasena_usuario=" + contrasena_usuario + '}';
    }
    
    
}
