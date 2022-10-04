var usernameD = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

 
    $("#form-register").submit(function (event) {
        event.preventDefault();
        registrarUsuario();
    });

 
});




function registrarUsuario() {
    let correo1 = $("#correo").val();
    let nombre = $("#nombre").val();
    let apellido = $("#apellido").val();
    let celular = $("#telefono").val();
    let contrasena = $("#contrasena").val();


    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./ServletUsuarioRegister",
        data: $.param({
            nombre: nombre,
            apellido: apellido,
            celular: celular,
            correo1: correo1,
            contrasena: contrasena

        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {
                $("#register-error").addClass("d-none");             
                document.location.href = "LoginMascota.html?mascota=";
            } else {
                $("#register-error").removeClass("d-none");
                $("#register-error").html("Ya tienes una cuenta, Error en el registro del usuario");
            }
        }
    });

}



